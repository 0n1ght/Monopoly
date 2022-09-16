package pl.monopoly.view;

import pl.monopoly.logic.Cubes;
import pl.monopoly.logic.Game;
import pl.monopoly.logic.Player;
import pl.monopoly.logic.SettingsState;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gameplay {
    private final Game game = new Game();
    private final List<PlayerView> playerViewList = new ArrayList<>();
    private List<CustomButtonView> customButtonViewList = new ArrayList<>();
    private static Graphics graphics;
    protected static int colorIndex = 0;

    // create
    public Gameplay(MouseManager manager) {

        // private final Player player1 = new Player(), player2 = new Player(), player3 = new Player(), player4 = new Player();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < SettingsState.getInstance().getPlayersNumber(); i++) {
            Player player = new Player(game);
            players.add(player);
            playerViewList.add(new PlayerView(player));
        }
        game.addPlayers(players);
        CubesView cubesView = new CubesView(new Cubes(game));
        SettingsButtonView settingsButtonView = new SettingsButtonView();
        customButtonViewList.addAll(List.of(settingsButtonView, cubesView));
        manager.setCustomButtonViewList(customButtonViewList);

    }

    public void tick() {

//        System.out.println("start");

    }

    public void render(Graphics g) {
        graphics = g;
        setBackgroundColor(colorIndex);
        graphics.fillRect(0,0,Display.getWidth(),Display.getHeight());
        Gameplay.graphics.translate(Display.getRelativeX(),Display.getRelativeY());
        Image image = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\board.png");
        Gameplay.graphics.drawImage(image, 0,0, null);
        for (CustomButtonView customButtonView : customButtonViewList) {
            customButtonView.render(g);
        }
        //todo refactoring -> using g(Graphics), not graphics(Graphics)

        //TODO refactoring
        switch (Game.playersNumber) {
            case 2 -> {
                playerViewList.get(0).render(Gameplay.graphics);
                playerViewList.get(1).render(Gameplay.graphics);
            }
            case 3 -> {
                playerViewList.get(0).render(Gameplay.graphics);
                playerViewList.get(1).render(Gameplay.graphics);
                playerViewList.get(2).render(Gameplay.graphics);
            }
            case 4 -> {
                playerViewList.get(0).render(Gameplay.graphics);
                playerViewList.get(1).render(Gameplay.graphics);
                playerViewList.get(2).render(Gameplay.graphics);
                playerViewList.get(3).render(Gameplay.graphics);
            }
        }
    }

    public static void setBackgroundColor(int colorIndex) {

        switch (colorIndex) {
            case 0 -> graphics.setColor(new Color(102, 255, 102));
            case 1 -> graphics.setColor(new Color(51, 153, 255));
            case 2 -> graphics.setColor(new Color(255, 102, 102));
            case 3 -> graphics.setColor(new Color(255, 255, 0));
        }

        graphics.fillRect(0,0,Display.getWidth(),Display.getHeight());

    }

//    public static void playSound(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
//
//        File musicFile = new File(path);
//        AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
//        Clip clip = AudioSystem.getClip();
//        clip.open(audioStream);
//
//        clip.start();
//    }
}
