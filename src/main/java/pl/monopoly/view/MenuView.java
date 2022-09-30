package pl.monopoly.view;

import pl.monopoly.logic.SettingsState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuView {
    private final ViewFactory viewFactory;
    private final JFrame startMenu = new JFrame("Monopoly");
    private final JCheckBox musicCheckBox = new JCheckBox();

    public MenuView(ViewFactory viewFactory) {
        this.viewFactory = viewFactory;
    }

    public void displayMenu() {

        // images
        addResizedImage("src\\main\\java\\pl\\monopoly\\images\\logoMonopoly.png", 400, 120, 50, 0, startMenu);
        addResizedImage("src\\main\\java\\pl\\monopoly\\images\\redCubesImage1.png", 140, 140, 10, 130, startMenu);
        addResizedImage("src\\main\\java\\pl\\monopoly\\images\\redCubesImage1.png", 140, 140, 10, 250, startMenu);
        addResizedImage("src\\main\\java\\pl\\monopoly\\images\\redCubesImage2.png", 140, 140, 335, 130, startMenu);
        addResizedImage("src\\main\\java\\pl\\monopoly\\images\\redCubesImage2.png", 140, 140, 335, 250, startMenu);

        // buttons
        MyButton myButton1 = new MyButton("PLAY", 168, 140, 150, 75);
        myButton1.addActionListener(e -> {
            startMenu.setVisible(false);
            try {
                viewFactory.createGame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            if (SettingsState.getInstance().isSoundPlaying()) {
                SoundPlayer.playSound(Sound.MUSIC);
            }
        });
        startMenu.add(myButton1);

        MyButton myButton2 = new MyButton("SETTINGS", 168, 230, 150, 75);
        myButton2.addActionListener(e -> {startMenu.setVisible(false);
            viewFactory.createSettings();});
        startMenu.add(myButton2);

        MyButton myButton3 = new MyButton("QUIT", 168, 320, 150, 75);
        myButton3.addActionListener(e -> startMenu.dispose());
        startMenu.add(myButton3);


        //menu
        startMenu.setIconImage(new ImageIcon("src\\main\\resources\\icon.png").getImage());
        startMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        startMenu.setResizable(false);
        startMenu.setSize(500, 500);
        startMenu.setLocationRelativeTo(null);
        startMenu.setLayout(null);
        addResizedImage("src\\main\\java\\pl\\monopoly\\images\\menuBackgroundImage.png", 500, 500, 0, 0, startMenu);
        startMenu.setVisible(true);
    }

    public void addResizedImage(String filePath, int width, int height, int x, int y, JFrame frame) {

        JLabel label = new JLabel();
        Image image = new ImageIcon(filePath)
                .getImage();
        Image scaledImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(scaledImage));
        label.setBounds(x, y, width, height);

        frame.add(label);

    }
}
