package pl.monopoly.view;

import pl.monopoly.logic.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gameplay {
    private final Game game = new Game();
    private final List<PlayerView> playerViewList = new ArrayList<>();
    private final List<BuyAbleFieldView> buyAbleFieldViewList = new ArrayList<>();
    private final List<CustomButtonView> customButtonViewList = new ArrayList<>();
    private final ScoreView scoreView;
    private static Graphics graphics;
    protected static int colorIndex = 0;

    // create
    public Gameplay(MouseManager manager) throws IOException {


        List<Player> players = new ArrayList<>();
        for (int i = 0; i < SettingsState.getInstance().getPlayersNumber(); i++) {

            Player player = new Player(game);
            players.add(player);
            playerViewList.add(new PlayerView(player));

        }

        game.addPlayers(players);
        scoreView = new ScoreView(players);
        CubesView cubesView = new CubesView(new Cubes(game));
        SettingsInGameButtonView settingsButtonView = new SettingsInGameButtonView();
        customButtonViewList.addAll(List.of(settingsButtonView, cubesView));
        manager.setCustomButtonViewList(customButtonViewList);

//        int[] buyAbleFieldsNumbers = {1, 3, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 27, 29, 31, 32, 34, 37, 39};

        for (Field field : FieldFactory.fields) {

            if (field.getNumber() == 1 || field.getNumber() == 3 || field.getNumber() == 6 || field.getNumber() == 8 || field.getNumber() == 9
                    || field.getNumber() == 11 || field.getNumber() == 13 || field.getNumber() == 14 || field.getNumber() == 16
                    || field.getNumber() == 18 || field.getNumber() == 19 || field.getNumber() == 21 || field.getNumber() == 23
                    || field.getNumber() == 24 || field.getNumber() == 26 || field.getNumber() == 27 || field.getNumber() == 29
                    || field.getNumber() == 31 || field.getNumber() == 32 || field.getNumber() == 34 || field.getNumber() == 37
                    || field.getNumber() == 39) {
                buyAbleFieldViewList.add(new BuyAbleFieldView((BuyAbleField) field));
            }
        }

//        for (int i =  0; i < FieldFactory.fields.size(); i++) {
//            if (i == 1 || i == 3 || i == 6 || i == 8 || i == 9 || i == 11 || i == 13 || i == 14 || i == 16 || i == 18 || i == 19 || i == 21 || i == 23 || i == 24 || i == 26 || i == 27 || i == 29 || i == 31 || i == 32 || i == 34 || i == 37 || i == 39) {
//                buyAbleFieldViewList.add(new BuyAbleFieldView((BuyAbleField) FieldFactory.fields.get(i)));
//            }
//        }

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

        for (PlayerView playerView : playerViewList) {
            playerView.render(g);
        }

        scoreView.render(g);
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
}
