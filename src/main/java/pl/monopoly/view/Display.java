package pl.monopoly.view;

import pl.monopoly.logic.Game;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Objects;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

//manages game frame and canvas
public final class Display {

    private static final int DEFAULT_WIDTH = 880;
    private static final int DEFAULT_HEIGHT = 880;
    private static JFrame frame;
    private static Canvas canvas;
    private final JFrame startMenu = new JFrame("Monopoly");
    private final JFrame settingsFrame = new JFrame("Monopoly");

    private Dimension size;
    public static Gameplay gameplay = new Gameplay(new MouseManager());
    private final JCheckBox musicCheckBox = new JCheckBox();
    JComboBox<String> playersComboBox = new JComboBox<>(new String[] {"4", "3", "2"});
    private static JMenu scoreGap1 = new JMenu(gameplay.getPlayer1().getMoney() + "                   ");
    private static JMenu scoreGap2 = new JMenu(gameplay.getPlayer2().getMoney() + "                   ");
    private static JMenu scoreGap3 = new JMenu(gameplay.getPlayer3().getMoney() + "                   ");
    private static JMenu scoreGap4 = new JMenu(gameplay.getPlayer4().getMoney() + "                   ");

    // create
    public Display(Gameplay gameplay) {

        Display.gameplay = gameplay;

        displayMenu();
        displayGame();
    }

    public void displayMenu() {

        // images
        addResizedImage("src\\main\\java\\pl\\monopoly\\images\\logoMonopoly.png", 400, 120, 50, 0, startMenu);
        addResizedImage("src\\main\\java\\pl\\monopoly\\images\\redCubesImage1.png", 140, 140, 10, 130, startMenu);
        addResizedImage("src\\main\\java\\pl\\monopoly\\images\\redCubesImage1.png", 140, 140, 10, 250, startMenu);
        addResizedImage("src\\main\\java\\pl\\monopoly\\images\\redCubesImage2.png", 140, 140, 335, 130, startMenu);
        addResizedImage("src\\main\\java\\pl\\monopoly\\images\\redCubesImage2.png", 140, 140, 335, 250, startMenu);

        // buttons
        addingButton("PLAY", 168, 140, 150, 75, e -> {
            startMenu.setVisible(false);
            showGame();
            if (musicCheckBox.isSelected()) {
                try {
                    Gameplay.playSound("src\\main\\resources\\sounds\\music.wav");
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
            }
            }, startMenu);

        addingButton("SETTINGS", 168, 230, 150, 75, e -> displaySettings(), startMenu);

        addingButton("QUIT", 168, 320, 150, 75, e -> System.exit(0), startMenu);


        //menu
        startMenu.setIconImage(new ImageIcon("src\\main\\resources\\icon.png").getImage());
        startMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        startMenu.setResizable(false);
        startMenu.setSize(500, 500);
        startMenu.setLocationRelativeTo(frame);
        startMenu.setLayout(null);
        addResizedImage("src\\main\\java\\pl\\monopoly\\images\\menuBackgroundImage.png", 500, 500, 0, 0, startMenu);
        startMenu.setVisible(true);
    }

    public void displayGame() {

        size = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        createAndSetupFrame();
        createAndSetupCanvas();
        frame.pack();
    }

    public void displaySettings() {

        startMenu.setVisible(false);
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
        playersComboBox.addActionListener(e -> {Game.playersNumber = Integer.parseInt((String) Objects.requireNonNull(playersComboBox.getSelectedItem())); addScoreBoard();});


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
        addingButton("BACK", 5, 205, 100, 50, e -> {settingsFrame.setVisible(false); startMenu.setVisible(true);}, settingsFrame);

        settingsFrame.setVisible(true);

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

    public void addingButton(String name, int x, int y, int width, int height, ActionListener l, JFrame frame) {

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

    private void createAndSetupFrame() {

        frame = new JFrame("Monopoly");

        frame.setSize(size);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setIconImage(new ImageIcon("src\\main\\resources\\icon.png").getImage());
        frame.setLayout(new BorderLayout());

        addScoreBoard();
    }

    private void createAndSetupCanvas() {
        canvas = new Canvas();

        canvas.setPreferredSize(size);
        canvas.setMaximumSize(size);
        canvas.setMinimumSize(size);
        frame.add(canvas, BorderLayout.CENTER);
        canvas.setFocusable(true);
        canvas.requestFocusInWindow();
    }

    public void addScoreBoard() {

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(255, 204, 51));
        menuBar.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));

        JMenu player1 = new JMenu("           RED: ");
        player1.setForeground(Color.RED);
        scoreGap1 = new JMenu(gameplay.getPlayer1().getMoney() + "$                   ");
        JMenu player2 = new JMenu("BLUE: ");
        player2.setForeground(Color.BLUE);
        scoreGap2 = new JMenu(gameplay.getPlayer2().getMoney() + "$                   ");
        JMenu player3 = new JMenu("GREEN: ");
        player3.setForeground(Color.GREEN);
        scoreGap3 = new JMenu(gameplay.getPlayer3().getMoney() + "$                   ");
        JMenu player4 = new JMenu("PURPLE: ");
        player4.setForeground(Color.MAGENTA);
        scoreGap4 = new JMenu(gameplay.getPlayer4().getMoney() + "$");

        player1.setFont(new Font("Serif", Font.ITALIC, 15));
        player2.setFont(new Font("Serif", Font.ITALIC, 15));
        player3.setFont(new Font("Serif", Font.ITALIC, 15));
        player4.setFont(new Font("Serif", Font.ITALIC, 15));

        scoreGap1.setFont(new Font("Serif", Font.ITALIC, 20));
        scoreGap2.setFont(new Font("Serif", Font.ITALIC, 20));
        scoreGap3.setFont(new Font("Serif", Font.ITALIC, 20));
        scoreGap4.setFont(new Font("Serif", Font.ITALIC, 20));


        if (Objects.equals(playersComboBox.getSelectedItem(), "4")) {

            menuBar.add(player1);
            menuBar.add(scoreGap1);
            menuBar.add(player2);
            menuBar.add(scoreGap2);
            menuBar.add(player3);
            menuBar.add(scoreGap3);
            menuBar.add(player4);
            menuBar.add(scoreGap4);

        } else if (Objects.equals(playersComboBox.getSelectedItem(), "3")) {

            menuBar.add(player1);
            menuBar.add(scoreGap1);
            menuBar.add(player2);
            menuBar.add(scoreGap2);
            menuBar.add(player3);
            menuBar.add(scoreGap3);

        } else {

            menuBar.add(player1);
            menuBar.add(scoreGap1);
            menuBar.add(player2);
            menuBar.add(scoreGap2);

        }

        frame.setJMenuBar(menuBar);
    }

    public static void refreshScoreBoard() {
        scoreGap1.setText(gameplay.getPlayer1().getMoney() + "$                   ");
        scoreGap2.setText(gameplay.getPlayer2().getMoney() + "$                   ");
        scoreGap3.setText(gameplay.getPlayer3().getMoney() + "$                   ");
        scoreGap4.setText(gameplay.getPlayer4().getMoney() + "$");
    }

    public void addListener(MouseListener listener) {
        canvas.addMouseListener(listener);
    }

    public void showGame() {
        frame.setVisible(true);
    }

    // get/set
    public Canvas getCanvas() {
        return canvas;
    }

    public static int getHeight() {
        return canvas.getHeight();
    }

    public static int getWidth() {
        return canvas.getWidth();
    }

    public static int getRelativeX() {

        if (getWidth() > DEFAULT_WIDTH) {
            return (getWidth()-DEFAULT_WIDTH)/2;
        }

        return 0;
    }

    public static int getRelativeY() {

        if (getHeight() > DEFAULT_HEIGHT) {
            return (getHeight()-DEFAULT_HEIGHT)/2;
        }

        return 0;
    }
}
