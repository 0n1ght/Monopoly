package pl.monopoly.view;

import pl.monopoly.logic.Player;

import java.awt.*;

public class PlayerView {
    private final Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.MAGENTA};
    private Player player;

    // create
    public PlayerView(Player player) {

        this.player = player;

    }

    public void render(Graphics graphics) {
        graphics.setColor(colors[player.getId()]);

        int distance1=0, distance2=0, normalField = 73, bigFieldAddition = 15;

        if (player.getField() <= 10) {

            distance1 = - normalField * player.getField();

        } else if (player.getField() > 10 && player.getField() <= 20) {

            distance1 = - normalField * 10;
            distance2 = - normalField * (player.getField() - 10);

        } else if (player.getField() > 20 && player.getField() <= 30) {

            distance1 = -normalField * 10 + normalField * (player.getField() - 20);
            distance2 = -normalField * 10;

        } else if (player.getField() > 30) {

            distance2 = -normalField * 10 + normalField * (player.getField() - 30);

        }

        if (player.getField() > 0) {distance1 -= bigFieldAddition;} //todo refactoring
        if (player.getField() >= 10) {distance1 -= bigFieldAddition;}
        if (player.getField() > 10) {distance2 -= bigFieldAddition;}
        if (player.getField() >= 20) {distance2 -= bigFieldAddition;}
        if (player.getField() > 20) {distance1 += bigFieldAddition;}
        if (player.getField() >= 30) {distance1 += bigFieldAddition;}
        if (player.getField() > 30) {distance2 += bigFieldAddition;}

        graphics.fillOval(790+10*player.getId() + distance1, 790+10*player.getId() + distance2, 50, 50);
        graphics.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 30));
        graphics.setColor(Color.GREEN);
        graphics.drawString(player.getMoney()+"", 790+10*player.getId() + distance1, 790+10*player.getId() + distance2);

    }

}
