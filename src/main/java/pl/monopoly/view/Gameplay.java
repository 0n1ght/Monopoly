package pl.monopoly.view;

import pl.monopoly.logic.Cubes;
import pl.monopoly.logic.Game;
import pl.monopoly.logic.Player;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Gameplay {
    private final Game game = new Game();
    private final Player player1 = new Player(game), player2 = new Player(game);
    private final PlayerView[] playerViews = {new PlayerView(player1), new PlayerView(player2)}; //new PlayerView(player3), new PlayerView(player4)};
    private final CubesView cubesView = new CubesView(new Cubes(game));

    // create
    public Gameplay(MouseManager manager) {

        game.setPlayers(player1, player2);
        manager.setCubesView(cubesView);

    }

    public void tick() {

//        System.out.println("start");

    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0,0,Display.getWidth(),Display.getHeight());
        graphics.translate(Display.getRelativeX(),Display.getRelativeY());
        Image image = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\board.png");
        graphics.drawImage(image, 0,0, null);
        cubesView.render(graphics);
        playerViews[0].render(graphics);
        playerViews[1].render(graphics);
    }

    public static void playSound(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File musicFile = new File(path);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.start();
    }
}
