package pl.monopoly;

import java.awt.*;

public class Gameplay {
    public void tick() {

        System.out.println("start");

    }

    public void render(Graphics graphics) {

        Image image = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\monopoly-plansza.jpg");
        graphics.drawImage(image, 0, 0, null);

        graphics.setColor(Color.blue);
        graphics.fillOval(770, 795, 50, 50);
        graphics.setColor(Color.red);
        graphics.fillOval(825, 795, 50, 50);

    }
}
