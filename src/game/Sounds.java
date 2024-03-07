package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Sounds {

    private static SoundClip background;
    private static SoundClip background2;
    private static SoundClip background3;
    private static SoundClip background4;


    static {
        try {
            background = new SoundClip("data/music/level1.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }

        try {
            background2 = new SoundClip("data/music/level2.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }

        try {
            background3 = new SoundClip("data/music/level3.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }

        try {
            background4 = new SoundClip("data/music/level4.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public static SoundClip getBackground(){
        return background;
    }

    public static SoundClip getBackground2() {
        return background2;
    }

    public static SoundClip getBackground3() {
        return background3;
    }

    public static SoundClip getBackground4() {
        return background4;
    }

}
