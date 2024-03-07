package game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AudioControls {
    private JPanel pnlControls;
    private JLabel lblVolume;
    private JSlider sldVolume;
    private JButton btnMute;


    public AudioControls(){
        double volume =1;

        btnMute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sounds.getBackground().setVolume(0.0001);
                sldVolume.setValue(1);
            }
        });

        sldVolume.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                float volume = scale((float)sldVolume.getValue(), 1.0f, 10.0f, 0.0001f, 2.0f);
                Sounds.getBackground().setVolume(volume);
            }
        });

    }

    private float scale(float value, float minInput, float maxInput, float minRange, float maxRange){

        return ((maxRange - minRange)*(value - minInput) / (maxInput - minInput)) + minRange;
    }

    public JPanel getPnlControls(){
        return pnlControls;
    }
}
