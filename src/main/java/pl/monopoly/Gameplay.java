package pl.monopoly;

import java.awt.*;

public class Gameplay {
    public void tick() {
        System.out.println("start");
    }

    public void render(Graphics graphics) {
        Image image = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\monopoly-plansza.jpg");
        graphics.drawImage(image, 0, 0, null);
    }
}
