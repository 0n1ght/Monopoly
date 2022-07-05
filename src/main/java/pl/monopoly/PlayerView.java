package pl.monopoly;

import java.awt.*;

public class PlayerView {
    private Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.MAGENTA};
    private Player player = new Player();

    public void render(Graphics graphics) {
        graphics.setColor(colors[player.getId()]);

        if (player.getId() == 0) {
            graphics.fillOval(770, 795, 50, 50);
        } else if (player.getId() == 1) {
            graphics.fillOval(825, 795, 50, 50);
        }

    }

}
