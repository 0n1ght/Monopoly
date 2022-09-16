package pl.monopoly.view;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    public MyButton(String name, int x, int y, int width, int height) {

        setText(name);
        setFont(new Font("Serif", Font.ITALIC, 30));
        setForeground(Color.WHITE);
        setBackground(Color.RED);
        setBounds(x, y, width, height);
        setFocusable(false);
        initSound();
        setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));
    }

    private void initSound() { //todo refactoring

        addActionListener(e -> {
           SoundPlayer.playSound(Sound.BUTTON_CLICK);
        });
    }
}
