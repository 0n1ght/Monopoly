package pl.monopoly.view;

import pl.monopoly.logic.Board;
import pl.monopoly.logic.Field;
import pl.monopoly.logic.Game;
import pl.monopoly.logic.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

// class which manages all visible frames
public final class Display {

    public static final int DEFAULT_WIDTH = 880;
    public static final int DEFAULT_HEIGHT = 880;
    private static JFrame frame;
    private static Canvas canvas;
    private final JFrame optionsFrame = new JFrame("Monopoly");

    private Dimension size;
    public static Gameplay gameplay = null; //TODO
    private final JCheckBox musicCheckBox = new JCheckBox();
    JComboBox<String> playersComboBox = new JComboBox<>(new String[] {"4", "3", "2"});
//    private static JMenu scoreGap1 = new JMenu(gameplay.getPlayer1().getMoney() + "                   ");
//    private static JMenu scoreGap2 = new JMenu(gameplay.getPlayer2().getMoney() + "                   ");
//    private static JMenu scoreGap3 = new JMenu(gameplay.getPlayer3().getMoney() + "                   ");
//    private static JMenu scoreGap4 = new JMenu(gameplay.getPlayer4().getMoney() + "                   ");

    // create
    public Display(Gameplay gameplay) {

        Display.gameplay = gameplay;
        displayGame();
    }

    public void displayGame() {

        size = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        createAndSetupFrame();
        createAndSetupCanvas();
        frame.pack();
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

    private void addScoreBoard() {

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createBevelBorder(0, new Color(255,204,0), new Color(255,204,0)));
        panel.setBackground(new Color(255,255,204));
        panel.setBounds(frame.getWidth()-730, frame.getHeight()-205, 250, 60);
        panel.setLayout(null);

        JLabel label1 = new JLabel("red: " + ((Player) Game.getQueue().get(0)).getMoney());
        label1.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        label1.setForeground(new Color(204,0,0));
        label1.setBounds(10,5,125,25);

        JLabel label2 = new JLabel("blue: " + ((Player) Game.getQueue().get(1)).getMoney());
        label2.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        label2.setForeground(new Color(0,0,225));
        label2.setBounds(135,5,125,25);

        JLabel label3 = new JLabel("green: " + ((Player) Game.getQueue().get(2)).getMoney());
        label3.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        label3.setForeground(new Color(0,153,0));
        label3.setBounds(10,32,125,25);

        JLabel label4 = new JLabel("pink: " + ((Player) Game.getQueue().get(3)).getMoney());
        label4.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        label4.setForeground(new Color(102,0,153));
        label4.setBounds(135,32,125,25);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);

        frame.add(panel);
    }

    private void displayOptions() {

        frame.setVisible(false);
        optionsFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        optionsFrame.setResizable(false);
        optionsFrame.setIconImage(new ImageIcon("src\\main\\resources\\icon.png").getImage());
        optionsFrame.setSize(250, 300);
        optionsFrame.setLocationRelativeTo(null);
        optionsFrame.setLayout(null);


        JLabel backgroundComboBoxText = new JLabel("Background color:");
        backgroundComboBoxText.setBounds(15, 15, 110, 20);

        JComboBox<String> backgroundComboBox = new JComboBox<>(new String[] {"green", "blue", "red", "yellow"});
        backgroundComboBox.setFocusable(false);
        backgroundComboBox.setBackground(Color.RED);
        backgroundComboBox.setBounds(130, 10, 65, 30);
        backgroundComboBox.addActionListener(e -> Gameplay.colorIndex = backgroundComboBox.getSelectedIndex());


        //todo-> music checkbox doesn't work
        JLabel label3 = new JLabel("Background music:");
        label3.setBounds(15, 70, 110, 20);

        musicCheckBox.setFocusable(false);
        musicCheckBox.setBounds(140, 65, 20, 20);

        optionsFrame.getContentPane().setBackground(Color.WHITE);
        optionsFrame.add(backgroundComboBoxText);
        optionsFrame.add(backgroundComboBox);
        optionsFrame.add(label3);
        optionsFrame.add(musicCheckBox);

        MyButton myButton = new MyButton("BACK", 5, 205, 100, 50);
        myButton.addActionListener(e -> {optionsFrame.setVisible(false); frame.setVisible(true);});
        optionsFrame.add(myButton);

        optionsFrame.setVisible(true);
    }

//    public void addScoreBoard() {
//
//        JMenuBar menuBar = new JMenuBar();
//        menuBar.setBackground(new Color(255, 204, 51));
//        menuBar.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));
//
//        JMenu player1 = new JMenu("           RED: ");
//        player1.setForeground(Color.RED);
//        scoreGap1 = new JMenu(gameplay.getPlayer1().getMoney() + "$                   ");
//        JMenu player2 = new JMenu("BLUE: ");
//        player2.setForeground(Color.BLUE);
//        scoreGap2 = new JMenu(gameplay.getPlayer2().getMoney() + "$                   ");
//        JMenu player3 = new JMenu("GREEN: ");
//        player3.setForeground(Color.GREEN);
//        scoreGap3 = new JMenu(gameplay.getPlayer3().getMoney() + "$                   ");
//        JMenu player4 = new JMenu("PURPLE: ");
//        player4.setForeground(Color.MAGENTA);
//        scoreGap4 = new JMenu(gameplay.getPlayer4().getMoney() + "$");
//
//        player1.setFont(new Font("Serif", Font.ITALIC, 15));
//        player2.setFont(new Font("Serif", Font.ITALIC, 15));
//        player3.setFont(new Font("Serif", Font.ITALIC, 15));
//        player4.setFont(new Font("Serif", Font.ITALIC, 15));
//
//        scoreGap1.setFont(new Font("Serif", Font.ITALIC, 20));
//        scoreGap2.setFont(new Font("Serif", Font.ITALIC, 20));
//        scoreGap3.setFont(new Font("Serif", Font.ITALIC, 20));
//        scoreGap4.setFont(new Font("Serif", Font.ITALIC, 20));
//
//
//        if (Objects.equals(playersComboBox.getSelectedItem(), "4")) {
//
//            menuBar.add(player1);
//            menuBar.add(scoreGap1);
//            menuBar.add(player2);
//            menuBar.add(scoreGap2);
//            menuBar.add(player3);
//            menuBar.add(scoreGap3);
//            menuBar.add(player4);
//            menuBar.add(scoreGap4);
//
//        } else if (Objects.equals(playersComboBox.getSelectedItem(), "3")) {
//
//            menuBar.add(player1);
//            menuBar.add(scoreGap1);
//            menuBar.add(player2);
//            menuBar.add(scoreGap2);
//            menuBar.add(player3);
//            menuBar.add(scoreGap3);
//
//        } else {
//
//            menuBar.add(player1);
//            menuBar.add(scoreGap1);
//            menuBar.add(player2);
//            menuBar.add(scoreGap2);
//
//        }
//
//        frame.setJMenuBar(menuBar);
//    }

    public static void refreshScoreBoard() {
//        scoreGap1.setText(gameplay.getPlayer1().getMoney() + "$                   ");
//        scoreGap2.setText(gameplay.getPlayer2().getMoney() + "$                   ");
//        scoreGap3.setText(gameplay.getPlayer3().getMoney() + "$                   ");
//        scoreGap4.setText(gameplay.getPlayer4().getMoney() + "$");
    }

    public void showDisplay() {
        frame.setVisible(true);
    }

    public void hideDisplay() {
        frame.setVisible(false);
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
