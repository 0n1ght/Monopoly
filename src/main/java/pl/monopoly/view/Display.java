package pl.monopoly.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

//manages game frame and canvas
public final class Display {

    private static final int DEFAULT_WIDTH = 880;
    private static final int DEFAULT_HEIGHT = 880;
    private static JFrame frame;
    private static Canvas canvas;
    private final JFrame startMenu = new JFrame("Monopoly");
    private final JFrame optionsFrame = new JFrame("Monopoly");

    private Dimension size;

    // create
    public Display() {
        displayMenu();
        displayGame();
    }

    // methods
    public void displayMenu() {

        addResizedImageToMenu("src\\main\\java\\pl\\monopoly\\images\\logoMonopoly.png", 400, 120, 50, 0);
        addResizedImageToMenu("src\\main\\java\\pl\\monopoly\\images\\redCubesImage1.png", 140, 140, 10, 130);
        addResizedImageToMenu("src\\main\\java\\pl\\monopoly\\images\\redCubesImage1.png", 140, 140, 10, 250);
        addResizedImageToMenu("src\\main\\java\\pl\\monopoly\\images\\redCubesImage2.png", 140, 140, 335, 130);
        addResizedImageToMenu("src\\main\\java\\pl\\monopoly\\images\\redCubesImage2.png", 140, 140, 335, 250);

        // buttons
        JButton button1 = new JButton("PLAY");
        button1.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.RED);
        button1.setBounds(168, 140, 150, 75);
        button1.setFocusable(false);
        button1.addActionListener(e -> {
            startMenu.setVisible(false);
            showGame();
        });
        button1.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));

        JButton button2 = new JButton("OPTIONS");
        button2.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.RED);
        button2.setBounds(168, 230, 150, 75);
        button2.setFocusable(false);
        button2.addActionListener(e -> optionsFrame.setVisible(true));
        button2.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));

        JButton button3 = new JButton("EXIT");
        button3.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.RED);
        button3.setBounds(168, 320, 150, 75);
        button3.setFocusable(false);
        button3.addActionListener(e -> System.exit(0));
        button3.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));

        //menu
        startMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        startMenu.setResizable(false);
        startMenu.setSize(500, 500);
        startMenu.setLocationRelativeTo(frame);
        startMenu.setLayout(null);
        startMenu.add(button1);
        startMenu.add(button2);
        startMenu.add(button3);
        addResizedImageToMenu("src\\main\\java\\pl\\monopoly\\images\\menuBackgroundImage.png", 500, 500, 0, 0);
        startMenu.setVisible(true);
    }

    public void displayGame() {

        size = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        createAndSetupFrame();
        createAndSetupCanvas();
        frame.pack();
    }

    public void displayOptions() {}

    public void addResizedImageToMenu(String fileName, int width, int height, int x, int y) {

        JLabel label = new JLabel();
        Image image = new ImageIcon(fileName)
                .getImage();
        Image scaledImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(scaledImage));
        label.setBounds(x, y, width, height);

        startMenu.add(label);

    }

    private void createAndSetupFrame() {
        frame = new JFrame("Monopoly");

        frame.setSize(size);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // ustawia okno na środku
        frame.setResizable(true);
//        frame.getContentPane().setBackground(Color.CYAN);
        frame.setLayout(new BorderLayout());

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

    public void addListener(MouseListener listener) {
        canvas.addMouseListener(listener);
    }

    public void showGame() {
        frame.setVisible(true);
    }
}
