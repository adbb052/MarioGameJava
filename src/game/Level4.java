package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 3 of the game
 */
public class Level4 extends GameLevel {

    private static final int NUM_COINS = 1;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(7, 0.6f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(-17, -14f));
        ground.addImage(new BodyImage("data/platform4.png", 12f));

        for (int i = 0; i < 5; i++) {
            Body ground2 = new StaticBody(this, groundShape);
            ground2.setPosition(new Vec2(i * 4, 10f));
            ground2.addImage(new BodyImage("data/platform4.png", 12f));
        }

        Body ground3 = new StaticBody(this, groundShape);
        ground3.setPosition(new Vec2(-2, -13f));
        ground3.addImage(new BodyImage("data/platform4.png", 12f));

        Body ground4 = new StaticBody(this, groundShape);
        ground4.setPosition(new Vec2(13, -11.5f));
        ground4.addImage(new BodyImage("data/platform4.png", 12f));

        Body ground5 = new StaticBody(this, groundShape);
        ground5.setPosition(new Vec2(0, 0f));
        ground5.addImage(new BodyImage("data/platform4.png", 12f));

        Body ground6 = new StaticBody(this, groundShape);
        ground6.setPosition(new Vec2(-10.5f, 4.5f));
        ground6.addImage(new BodyImage("data/platform4.png", 12f));

        Body ground7 = new StaticBody(this, groundShape);
        ground7.setPosition(new Vec2(9.5f, -5f));
        ground7.addImage(new BodyImage("data/platform4.png", 12f));

        // walls
        Shape leftWallShape = new BoxShape(0.5f, 20);
        Body leftWall = new StaticBody(this, leftWallShape);
        leftWall.setPosition(new Vec2(-19.5f, 0));
        leftWall.addImage(new BodyImage("data/invisible.png", 0f));


        for (int i = 0; i < NUM_COINS; i++) {
            Body coin = new Coins(this);
            coin.setPosition(new Vec2(i * 2 + 2, 11.5f));
            coin.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < NUM_COINS; i++) {
            Body coin = new Coins(this);
            coin.setPosition(new Vec2(-11, i * 2 - 6));
            coin.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 4; i++) {
            Body coin = new Coins(this);
            coin.setPosition(new Vec2(i * 4 + 5, -10f));
            coin.addCollisionListener(new Pickup(getPlayer()));
        }


        Head head = new Head(this);
        head.setPosition(new Vec2(-2, 0f));
        head.addCollisionListener(new Pickup(this.getPlayer()));

        Goomba goomba = new Goomba(this);
        goomba.setPosition(new Vec2(15, 12f));
        goomba.addCollisionListener(new Pickup(this.getPlayer()));

        Goomba goomba1 = new Goomba(this);
        goomba1.setPosition(new Vec2(0, -3f));
        goomba1.addCollisionListener(new Pickup(this.getPlayer()));

        Coins coins = new Coins(this);
        coins.setPosition(new Vec2(0, -3f));
        coins.addCollisionListener(new Pickup(this.getPlayer()));

        Sounds.getBackground4().loop();

    }

    @Override
    public void stop(){
        super.stop();
        Sounds.getBackground4().stop();
    }



    @Override
    public Vec2 startPosition() {
        return new Vec2(-5, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(20f, 12f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getLiveCount() >= NUM_COINS;
    }

    @Override
    public int getLevelNumber() {
        return 4;
    }
}
