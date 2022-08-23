package pl.monopoly.view;

import pl.monopoly.logic.Game;
import pl.monopoly.logic.SettingsState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SettingsView {
    private final JFrame settingsFrame = new JFrame("Monopoly");
    private final JComboBox<String> playersComboBox = new JComboBox<>(new String[] {"4", "3", "2"});
    private final JCheckBox musicCheckBox = new JCheckBox();
    private final ViewFactory viewFactory;
    private final SettingsState settingsState = SettingsState.getInstance();

    public SettingsView(ViewFactory viewFactory) {
        this.viewFactory = viewFactory;
    }

    public void displaySettings() {

        settingsFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        settingsFrame.setResizable(false);
        settingsFrame.setIconImage(new ImageIcon("src\\main\\resources\\icon.png").getImage());
        settingsFrame.setSize(250, 300);
        settingsFrame.setLocationRelativeTo(null);
        settingsFrame.setLayout(null);


        JLabel playersComboBoxText = new JLabel("Players number:");
        playersComboBoxText.setBounds(15, 15, 110, 20);

        playersComboBox.setFocusable(false);
        playersComboBox.setBackground(Color.RED);
        playersComboBox.setBounds(130, 10, 65, 30);
        playersComboBox.addActionListener(e -> {
            settingsState.setPlayersNumber(Integer.parseInt((String) Objects.requireNonNull(playersComboBox.getSelectedItem())));
            System.out.println("addScoreBoard();");});


        JLabel backgroundComboBoxText = new JLabel("Background color:");
        backgroundComboBoxText.setBounds(15, 70, 110, 20);

        JComboBox<String> backgroundComboBox = new JComboBox<>(new String[] {"green", "blue", "red", "yellow"});
        backgroundComboBox.setFocusable(false);
        backgroundComboBox.setBackground(Color.RED);
        backgroundComboBox.setBounds(130, 65, 65, 30);
        backgroundComboBox.addActionListener(e -> Gameplay.colorIndex = backgroundComboBox.getSelectedIndex());


        JLabel label3 = new JLabel("Background music:");
        label3.setBounds(15, 125, 110, 20);

        musicCheckBox.setFocusable(false);
        musicCheckBox.setBounds(140, 126, 20, 20);


        settingsFrame.getContentPane().setBackground(Color.WHITE);
        settingsFrame.add(playersComboBoxText);
        settingsFrame.add(playersComboBox);
        settingsFrame.add(backgroundComboBoxText);
        settingsFrame.add(backgroundComboBox);
        settingsFrame.add(label3);
        settingsFrame.add(musicCheckBox);
        addButton("BACK", 5, 205, 100, 50, e -> {settingsFrame.setVisible(false);
            viewFactory.createMenu();}, settingsFrame);

        settingsFrame.setVisible(true);

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
