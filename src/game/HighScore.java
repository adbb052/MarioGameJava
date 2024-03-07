package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class HighScore {
    private JPanel pnlScore;
    private JPanel pnlControls;
    private JLabel lblPlayerName;
    private JTextField txtName;
    private JLabel lblScoreTitle;
    private JLabel lblScore;
    private JButton btnSave;
    private JButton btnCancel;
    private JScrollPane scrollPaneScore;
    private JList<String> lstScores;


    private Game game;
    private HighScoreWriter highScoreWriter;
    private HighScoreReader highScoreReader;
    private final String fileName = "highScores.txt";

    public HighScore(Game game){
        this.game = game;

        lblScore.setText(game.getPlayer().getCoinCount()+"");

        File scores = new File(fileName);
        try {
            scores.createNewFile();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        highScoreWriter = new HighScoreWriter(fileName);
        highScoreReader = new HighScoreReader(fileName);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    highScoreWriter.writeHighScore(
                            txtName.getText(),
                            game.getPlayer().getCoinCount(), game.getPlayer().getCoinCount()
                    );
                } catch (IOException ex){
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        DefaultListModel<String> model = new DefaultListModel<>();
        try {
            model.addAll(highScoreReader.readScores());
        } catch (IOException ex){
            ex.printStackTrace();
        }
        lstScores.setModel(model);

    }

    public JPanel getPnlScore(){
        return pnlScore;
    }

}
