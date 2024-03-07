package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

    private static final int NUM_COINS = 1;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(21, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        ground.setFillColor(Color.blue);

        // walls
        Shape leftWallShape = new BoxShape(0.5f, 12, new Vec2(-16.5f, 1f));
        Body leftWall = new StaticBody(this, leftWallShape);
        leftWall.setFillColor(Color.BLUE);
        Shape rightWallShape = new BoxShape(0.5f, 12, new Vec2(13.5f, 1f));
        Body rightWall = new StaticBody(this, rightWallShape);
        rightWall.setFillColor(Color.BLUE);

        //rightWall.addCollisionListener(new HeadCollide1(getHead()));

        // make some platforms
        Shape platformShape = new BoxShape(10, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-7, 5.5f));
        platform1.setFillColor(Color.RED);

        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(3, -2.5f));
        platform2.setFillColor(Color.RED);

        /*Shape platformShape1 = new BoxShape(0.5f, 4f);
        Body platform3 = new StaticBody(this, platformShape1);
        platform3.setPosition(new Vec2(0, -3f));*/


        for (int i = 0; i < NUM_COINS; i++) {
            Body orange = new Coins(this);
            orange.setPosition(new Vec2(i * 2-10, 10));
            orange.addCollisionListener(new Pickup(getPlayer()));
        }

        Head head = new Head(this);
        head.setPosition(new Vec2(-2, 0f));
        head.addCollisionListener(new Pickup(this.getPlayer()));

        Goomba goomba = new Goomba(this);
        goomba.setPosition(new Vec2(-8, 8f));
        goomba.addCollisionListener(new Pickup(this.getPlayer()));

        Goomba goomba1 = new Goomba(this);
        goomba1.setPosition(new Vec2(0, -3f));
        goomba1.addCollisionListener(new Pickup(this.getPlayer()));

        Coins coins = new Coins(this);
        coins.setPosition(new Vec2(0, -3f));
        coins.addCollisionListener(new Pickup(this.getPlayer()));

        Sounds.getBackground3().loop();

    }

    @Override
    public void stop(){
        super.stop();
        Sounds.getBackground3().stop();
    }


    @Override
    public Vec2 startPosition() {
        return new Vec2(-5, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-12.4f, 7.4f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getLiveCount() >= NUM_COINS;
    }

    @Override
    public int getLevelNumber() {
        return 3;
    }
}
