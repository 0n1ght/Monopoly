package pl.monopoly;

import java.awt.*;

public class PlayerView {
    private final Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.MAGENTA};
    private final Player player = new Player();

    public void render(Graphics graphics) {
        graphics.setColor(colors[player.getId()]);

        int distance1 = 0, distance2 = 0;

        if (player.getField() > 40) {
            player.setField(player.getField()-40);
        }

        if (player.getField() <= 10) {

            distance1 = - 73 * player.getField();
            distance2 = 0;

        } else if (player.getField() > 10 && player.getField() <= 20) {

            distance1 = - 73 * 10;
            distance2 = - 73 * (player.getField() - 10);

        } else if (player.getField() > 20 && player.getField() <= 30) {

            distance1 = -73 * 10 + 73 * (player.getField() - 20);
            distance2 = -73 * 10;

        } else if (player.getField() > 30) {

            distance1 = 0;
            distance2 = -73 * 10 + 73 * (player.getField() - 30);

        }

        if (player.getField() > 0) {distance1 -= 15;}
        if (player.getField() >= 10) {distance1 -= 15;}
        if (player.getField() > 10) {distance2 -= 15;}
        if (player.getField() >= 20) {distance2 -= 15;}
        if (player.getField() > 20) {distance1 += 15;}
        if (player.getField() >= 30) {distance1 += 15;}
        if (player.getField() > 30) {distance2 += 15;}

        graphics.fillOval(790+10*player.getId() + distance1, 790+10*player.getId() + distance2, 50, 50);

    }

}

/*

    int HorizontalField = player.getField() > 10 ? player.getField()-10 : 0;
    int VerticalField = Math.min(player.getField(), 10);
    int distance1, distance2;

    if (player.getField() <= 20
            distance1 = 73 * (player.getField()-HorizontalField);
            distance2 = 73 * (player.getField()-VerticalFiel
            } else if (player.getField() > 20 && player.getField() <= 3
            distance1 = 73 * 10 - player.getField() * 73;
            distance2 = 73 * 1
            } els
            distance1 = 0;
            distance2 =

            if (player.getField() > 0) {distance1 += 15;}
            if (player.getField() >= 10) {distance1 += 15;}
            if (player.getField() > 10) {distance2 += 15;}
            if (player.getField() >= 20) {distance2 += 15;}
            if (player.getField() > 20) {distance1 -= 15;}
            if (player.getField() >= 30) {distance1 -= 15;}
            if (player.getField() > 30) {distance2 -= 15;}
            graphics.fillOval(790+10*player.getId() - distance1, 790+10*player.getId() - distance2, 50, 50);
            */
