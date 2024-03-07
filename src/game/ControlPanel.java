package game;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPanel {

    private JPanel mainPanel;
    private JButton saveButton;
    private JButton loadButton;
    private JButton playButton;
    private JButton pauseButton;
    private JButton stopButton;
    private Game game;


    public ControlPanel(Game game) {
        this.game = game;

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                //Input box to enter the name for game saving
                name=JOptionPane.showInputDialog("Enter your name: ");
                try {
                    //writes the game to SaveFiles as a .txt file
                    HighScoreWriter writer = new HighScoreWriter("data/SaveFiles/" + name + ".txt");
                    writer.writeHighScore(name, game.getPlayer().getCoinCount(), game.getPlayer().getLiveCount());
                }
                catch (IOException error){
                    error.printStackTrace();
                }

            }
        });


        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { game.play();

            }
        });


        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { game.pause();

            }
        });


        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { System.exit(0);

            }
        });

    }


    public JPanel getMainPanel() {return mainPanel;}
}
