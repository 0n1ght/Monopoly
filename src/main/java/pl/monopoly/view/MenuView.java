package pl.monopoly.view;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
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
        addButton("PLAY", 168, 140, 150, 75, e -> {
            startMenu.setVisible(false);
            viewFactory.createGame();
            if (musicCheckBox.isSelected()) {
                try {
                    Gameplay.playSound("src\\main\\resources\\sounds\\music.wav");
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }, startMenu);

        addButton("SETTINGS", 168, 230, 150, 75, e -> {startMenu.setVisible(false);
            viewFactory.createSettings();}, startMenu);

        addButton("QUIT", 168, 320, 150, 75, e -> System.exit(0), startMenu);


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

    public void addButton(String name, int x, int y, int width, int height, ActionListener l, JFrame frame) {

        JButton button = new JButton(name);
        button.setFont(new Font("Serif", Font.ITALIC, 30));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.RED);
        button.setBounds(x, y, width, height);
        button.setFocusable(false);
        button.addActionListener(l);
        button.addActionListener(e -> {
            try {
                Gameplay.playSound("src\\main\\resources\\sounds\\soundClickDefault.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        });
        button.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));

        frame.add(button);
    }
}
