package game;

import java.io.FileWriter;
import java.io.IOException;

public class GameSaver {
    private String fileName;

    public GameSaver(String fileName) {
        this.fileName = fileName;
    }

    public void saveGame(GameLevel gameWorld) throws IOException {
        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);

            writer.write(gameWorld.getLevelNumber() + "," + gameWorld.getPlayer().getPosition() + "\n");

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
