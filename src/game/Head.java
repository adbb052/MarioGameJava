package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Head extends Walker implements StepListener {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.684f,1.121f, -1.111f,0.419f, -1.107f,-0.427f, -0.585f,-1.111f, 0.716f,-1.107f, 1.098f,-0.418f, 1.098f,0.702f, 0.419f,1.121f);

    private static final BodyImage image =
            new BodyImage("data/head.png", 1.25f);

    private static SoundClip lifeSound;

    static {
        try {
            lifeSound = new SoundClip("data/music/gainlife.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private int counter, speed;

    public Head(World world) {
        super(world, shape);
        addImage(image);
        world.addStepListener(this);
        counter = 0;
        speed = 5;
        startWalking(speed);
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        counter++;
        if (counter % 120 == 0){
            this.stopWalking();
            this.startWalking(speed*=-1);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }

    @Override
    public void destroy() {
        lifeSound.play();
        super.destroy();
    }
}
