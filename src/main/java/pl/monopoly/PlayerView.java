package pl.monopoly;

import java.awt.*;

public class PlayerView {
    private Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.MAGENTA};
    private Player player = new Player();

    public void render(Graphics graphics) {
        graphics.setColor(colors[player.getId()]);

        int distance1 = 73 * player.getField();

//        if (player.getField() > 0) {distance1 += 15;}
        distance1 = player.getField() > 0 ? distance1+15 : distance1;

//        if (player.getField() >= 10) {distance1 += 15;}
        distance1 = player.getField() >= 10 ? distance1+15 : distance1;


        graphics.fillOval(790+10*player.getId() - distance1, 790+10*player.getId(), 50, 50);

    }

}
