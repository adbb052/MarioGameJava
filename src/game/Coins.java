package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.Color;
import java.io.IOException;


/**
 * coins.
 */
public class Coins extends Walker {
    private static final Shape shape = new CircleShape(0.5f);
    private static final BodyImage CoinImage =
            new BodyImage("data/coin.gif", 3f);

    private static SoundClip coinSound;

    static {
        try {
            coinSound = new SoundClip("data/music/coinPickupSound.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Coins(World world) {
        super(world, shape);
        addImage(CoinImage);

    }

    @Override
    public void destroy() {
        coinSound.play();
        super.destroy();
    }
}
