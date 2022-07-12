package pl.monopoly;

import java.awt.*;

public class Gameplay {
    private PlayerView[] playerViews = {new PlayerView(), new PlayerView()};
    private final CubesView cubesView = new CubesView();
    private MouseManager manager;

    // create
    public Gameplay(MouseManager manager) {

        this.manager = manager;
        manager.setCubesView(cubesView);

    }

    public void tick() {

//        System.out.println("start");

    }

    public void render(Graphics graphics) {

        Image image = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\monopoly-plansza.jpg");
        graphics.drawImage(image, 0, 0, null);

        cubesView.render(graphics);

        playerViews[0].render(graphics);
        playerViews[1].render(graphics);

    }
}
