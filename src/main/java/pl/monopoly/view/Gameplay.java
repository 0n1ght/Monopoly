package pl.monopoly.view;

import pl.monopoly.logic.Cubes;
import pl.monopoly.logic.Game;
import pl.monopoly.logic.Player;

import java.awt.*;

public class Gameplay {
    private final Game game = new Game();
    private final Player player1 = new Player(game), player2 = new Player(game); //player3 = new Player(game), player4 = new Player(game);
    private final PlayerView[] playerViews = {new PlayerView(player1), new PlayerView(player2)}; //new PlayerView(player3), new PlayerView(player4)};
    private MouseManager manager;
    private final CubesView cubesView = new CubesView(new Cubes(game));

    // create
    public Gameplay(MouseManager manager) {

        game.setPlayers(player1, player2);
        this.manager = manager;
        manager.setCubesView(cubesView);

    }

    public void tick() {

//        System.out.println("start");

    }

    public void render(Graphics graphics) {

        Image image = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\board.jpg");
        graphics.drawImage(image, 0, 0, null);

        cubesView.render(graphics);

        playerViews[0].render(graphics);
        playerViews[1].render(graphics);
//        playerViews[2].render(graphics);
//        playerViews[3].render(graphics);

    }
}
