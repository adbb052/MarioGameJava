package game;


import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Mario extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            0.437f,1.121f, 0.711f,0.716f, 0.837f,-0.139f, 0.842f,-1.107f, -0.859f,-1.111f, -0.846f,0.572f, -0.688f,0.995f, -0.274f,1.112f);

    private static final BodyImage image =
            new BodyImage("data/mario1.png", 2.25f);

    private static SoundClip hurtSound;

    static {
        try {
            hurtSound = new SoundClip("data/music/hurt.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private int coinCount;
    private int liveCount;

    public Mario(World world) {
        super(world, shape);
        addImage(image);
        coinCount = 0;
        liveCount = 3;
    }

    public int getCoinCount() {
        return coinCount;
    }

    public void incrementCoinCount() {
        coinCount++;
        System.out.println("Congratulations, Gold Coins = " + coinCount);
        if (coinCount == 15){
            System.out.println("You have all gold coins!");
        }
    }

    public int getLiveCount() {
        return liveCount;
    }

    public void decrementLiveCount() {
        liveCount--;
        System.out.println("Lost life! You have " + liveCount + " lives left");
        if (liveCount == 0){
            System.out.println("GAME OVER");
        }
    }

    public void incrementLiveCount() {
        liveCount++;
        System.out.println("Gained a life! You have " + liveCount + " lives ");
    }

    public void playSound() {
        hurtSound.play();
    }


}


