package game;

import city.cs.engine.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import javax.management.InvalidApplicationException;
import javax.swing.*;

import org.jbox2d.common.Vec2;

/**
 * The computer game.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyView view;

    private int level;

    private Controller controller;

    private final JFrame frame;

    private SoundClip gameMusic;


    /**
     * Initialise a new Game.
     */
    public Game() {


        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);


        view = new MyView(world, this, 1000, 690);
        view.setZoom(30);


        // make a view
        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame
        frame = new JFrame("Mario Game");
        ControlPanel buttons = new ControlPanel(this);
        frame.add(buttons.getMainPanel(), BorderLayout.NORTH);
        frame.add(new AudioControls().getPnlControls(), BorderLayout.SOUTH);


        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));

        controller = new Controller(world.getPlayer(), world);
        frame.addKeyListener(controller);


        // uncomment to make the view track the bird
        // world.addStepListener(new Tracker(view, world.getPlayer()));

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);//

        // start!
        world.start();
    }


    /**
     * The player in the current level.
     */
    public Mario getPlayer() {
        return world.getPlayer();
    }

    /**
     * Is the current level of the game finished?
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     * Advance to the next level of the game.
     */
    public void goNextLevel() {

        world.stop();
        if (level == 4) {
            JDialog diaScore = new JDialog(frame, true);
            HighScore highScore = new HighScore(this);
            diaScore.getContentPane().add(highScore.getPnlScore());
            diaScore.pack();
            diaScore.setVisible(true);


        } else if (level == 1) {
            level++;
            view.addLevel();
            // get a new world

            world = new Level2();
            // fill it with bodies
            world.populate(this);


            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());

            // show the new world in the view
            view.setWorld(world);
            world.start();
        } else if (level == 2) {
            level++;
            view.addLevel();
            // get a new world

            world = new Level3();
            // fill it with bodies
            world.populate(this);



            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.start();
        } else if (level == 3) {
            level++;
            view.addLevel();
            // get a new world

            world = new Level4();
            // fill it with bodies
            world.populate(this);


            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.start();
        }


    }

    /**
     * Run the game.
     */
    public static void main(String[] args) {
        new Game();


    }

    public void pause() {
        world.stop();
    }

    public void play() {
        world.start();
    }

}
