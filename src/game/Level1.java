package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel implements ActionListener {

    private static final int NUM_COINS = 5;


    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(30, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        ground.setFillColor(Color.BLUE);

        // walls
        Shape leftWallShape = new BoxShape(0.5f, 20, new Vec2(-15.5f, 2.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 20, new Vec2(15.5f, 2.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);



        // make platforms
        Shape boxShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-6, 4.5f));
        platform1.setFillColor(Color.green);

        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(5, -6.5f));
        platform2.setFillColor(Color.green);

        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(-5, -4.5f));
        platform3.setFillColor(Color.green);

        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(0, 0f));
        platform4.setFillColor(Color.green);

        Body platform5 = new StaticBody(this, boxShape);
        platform5.setPosition(new Vec2(5, 4.5f));
        platform5.setFillColor(Color.green);


        for (int i = 0; i < 11; i++) {
            Body coin = new Coins(this);
            coin.setPosition(new Vec2(i*2-10, 10));
            coin.addCollisionListener(new Pickup(getPlayer()));
        }

        Body coin = new Coins(this);
        coin.setPosition(new Vec2(5, -9));
        coin.addCollisionListener(new Pickup(getPlayer()));

        Head head = new Head(this);
        head.setPosition(new Vec2(-4, -4f));
        head.addCollisionListener(new Pickup(this.getPlayer()));

        Goomba goomba = new Goomba(this);
        goomba.setPosition(new Vec2(1, -8f));
        goomba.addCollisionListener(new Pickup(this.getPlayer()));

        Sounds.getBackground().loop();

    }

    @Override
    public void stop(){
        super.stop();
        Sounds.getBackground().stop();
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCoinCount() >= NUM_COINS;
    }

    @Override
    public int getLevelNumber() {
        return 1;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
