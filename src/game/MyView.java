package game;

import java.awt.*;
import javax.swing.ImageIcon;
import city.cs.engine.*;

/**
 * extended view
 */
public class MyView extends UserView {
    Mario mario;
    Game game;

    private Image background;
    private int levelNo;


    public MyView(World world, Game game, int width, int height) {
        super(world, width, height);
        this.game = game;
        levelNo = 1;

    }

    public void addLevel(){levelNo++;}


    @Override
    protected void paintBackground(Graphics2D g) {
        super.paintBackground(g);
        if (levelNo == 1){
            background = new ImageIcon("data/bg1.png").getImage();
            g.drawImage(background, 0, 0, this);}
        else if (levelNo==2){
            background = new ImageIcon("data/bg2.gif").getImage();
            g.drawImage(background, 0, 0, this);}
        else if (levelNo==3){
            background = new ImageIcon("data/bg3.jpg").getImage();
            g.drawImage(background, 0, 0, this);}
        else if (levelNo==4){
            background = new ImageIcon("data/bg4.png").getImage();
            g.drawImage(background, 0, 0, this);}
        }


    @Override
    protected void paintForeground(Graphics2D g) {

        Font myFont = new Font ("Helvetica", Font.BOLD,  20);
        g.setFont(myFont);
        g.setColor(Color.RED);

        g.drawString("Coins: " + game.getPlayer().getCoinCount(), 100, 75);
        g.drawString("Lives: " + game.getPlayer().getLiveCount(), 100, 100);


        }


}

