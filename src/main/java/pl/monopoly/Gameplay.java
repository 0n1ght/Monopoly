package pl.monopoly;

import java.awt.*;

public class Gameplay {
    private PlayerView[] playerViews = {new PlayerView(), new PlayerView()};

    public void tick() {

        System.out.println("start");

    }

    public void render(Graphics graphics) {

        Image image = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\monopoly-plansza.jpg");
        graphics.drawImage(image, 0, 0, null);

        playerViews[0].render(graphics);
        playerViews[1].render(graphics);

    }
}
