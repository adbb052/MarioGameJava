package game;

import city.cs.engine.*;

/**
 * Collision listener that allows Mario to collect things.
 */
public class Pickup implements CollisionListener {
    private Mario mario;

    public Pickup(Mario mario) {this.mario = mario;
    }

    @Override
    public void collide(CollisionEvent e) {

        if (e.getReportingBody() instanceof Coins && e.getOtherBody() == mario) {
            mario.incrementCoinCount();
            e.getReportingBody().destroy();
        }
        else if (e.getReportingBody() instanceof Goomba && e.getOtherBody() == mario) {
            mario.decrementLiveCount();
            e.getReportingBody().destroy();
            mario.playSound();
        }
        else if (e.getReportingBody() instanceof Head && e.getOtherBody() == mario) {
            mario.incrementLiveCount();
            e.getReportingBody().destroy();
        }
    }
}