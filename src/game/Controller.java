package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 15;
    private static final float WALKING_SPEED = 4;

    private enum STATE{
        MENU,
        GAME
    };

    private STATE State = STATE.MENU;
    
    private Walker body;

    private GameLevel currentLevel;

    public Controller(Walker body, GameLevel level) {
        this.body = body;
        currentLevel = level;
    }
    
    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (State == STATE.GAME);{

        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_SPACE) { // SPACE = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_LEFT) {
            body.startWalking(- WALKING_SPEED); // LEFT ARROW = walk left

        } else if (code == KeyEvent.VK_RIGHT) {
            body.startWalking(WALKING_SPEED); // RIGHT ARROW = walk right
        }


        else if (code == KeyEvent.VK_S) {
            GameSaver scoreWriter = new GameSaver("data/highScores.txt");
            try {
                scoreWriter.saveGame(currentLevel);
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        else if (code == KeyEvent.VK_R){
            HighScoreReader scoreReader = new HighScoreReader("data/highScores.txt");
            try {
                scoreReader.readScores();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }



        }
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            body.stopWalking();
        }
    }
    
    public void setBody(Walker body) {
        this.body = body;
    }
}
