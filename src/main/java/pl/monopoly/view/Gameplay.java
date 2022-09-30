package pl.monopoly.view;

import pl.monopoly.logic.Cubes;
import pl.monopoly.logic.Game;
import pl.monopoly.logic.Player;
import pl.monopoly.logic.SettingsState;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gameplay {
    private final Game game = new Game();
    private final List<PlayerView> playerViewList = new ArrayList<>();
    private List<CustomButtonView> customButtonViewList = new ArrayList<>();
    private ScoreView scoreView;
    protected static int colorIndex = 0;

    // create
    public Gameplay(MouseManager manager) throws IOException {

        // private final Player player1 = new Player(), player2 = new Player(), player3 = new Player(), player4 = new Player();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < SettingsState.getInstance().getPlayersNumber(); i++) {
            Player player = new Player(game);
            players.add(player);
            playerViewList.add(new PlayerView(player));
        }
        game.addPlayers(players);
        scoreView = new ScoreView(players);
        CubesView cubesView = new CubesView(new Cubes(game));
        SettingsButtonView settingsButtonView = new SettingsButtonView();
        customButtonViewList.addAll(List.of(settingsButtonView, cubesView));
        manager.setCustomButtonViewList(customButtonViewList);

    }

    public void tick() {

    }

    public void render(Graphics g) {
        setBackgroundColor(colorIndex,g);
        g.fillRect(0,0,Display.getWidth(),Display.getHeight());
        g.translate(Display.getRelativeX(),Display.getRelativeY());
        Image image = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\board.png");
        g.drawImage(image, 0,0, null);
        for (CustomButtonView customButtonView : customButtonViewList) {
            customButtonView.render(g);
        }

        scoreView.render(g);
        for (PlayerView playerView : playerViewList) {
            playerView.render(g);
        }
    }

    public static void setBackgroundColor(int colorIndex, Graphics g) {

        switch (colorIndex) {
            case 0 -> g.setColor(new Color(102, 255, 102));
            case 1 -> g.setColor(new Color(51, 153, 255));
            case 2 -> g.setColor(new Color(255, 102, 102));
            case 3 -> g.setColor(new Color(255, 255, 0));
        }

        g.fillRect(0,0,Display.getWidth(),Display.getHeight());

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
