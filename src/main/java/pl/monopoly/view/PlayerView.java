package pl.monopoly.view;

import pl.monopoly.logic.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerView {
    private final Player player;

    // create
    public PlayerView(Player player) {
        this.player = player;
    }

    public void render(Graphics graphics) {

        if (player.getMoney() < 0) {
            return;
        }

        int distance1 = 0, distance2 = 0, normalField = 73, bigFieldAddition = 15;

        if (player.getFieldNumber() <= 10) {

            distance1 = - normalField * player.getFieldNumber();

        } else if (player.getFieldNumber() > 10 && player.getFieldNumber() <= 20) {

            distance1 = - normalField * 10;
            distance2 = - normalField * (player.getFieldNumber() - 10);

        } else if (player.getFieldNumber() > 20 && player.getFieldNumber() <= 30) {

            distance1 = -normalField * 10 + normalField * (player.getFieldNumber() - 20);
            distance2 = -normalField * 10;

        } else if (player.getFieldNumber() > 30) {

            distance2 = -normalField * 10 + normalField * (player.getFieldNumber() - 30);

        }

        if (player.getFieldNumber() > 0) {distance1 -= bigFieldAddition;}
        if (player.getFieldNumber() >= 10) {distance1 -= bigFieldAddition;}
        if (player.getFieldNumber() > 10) {distance2 -= bigFieldAddition;}
        if (player.getFieldNumber() >= 20) {distance2 -= bigFieldAddition;}
        if (player.getFieldNumber() > 20) {distance1 += bigFieldAddition;}
        if (player.getFieldNumber() >= 30) {distance1 += bigFieldAddition;}
        if (player.getFieldNumber() > 30) {distance2 += bigFieldAddition;}

        ImageIcon playerIcon = switch (player.getColor()) {
            case RED -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\playersImages\\red.png");
            case BLUE -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\playersImages\\blue.png");
            case GREEN -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\playersImages\\green.png");
            case PURPLE -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\playersImages\\purple.png");
        };
        graphics.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 30));
        graphics.setColor(Color.GREEN);

        int[] xModifier = {-10, +10, -10, +10};
        int[] yModifier = {-10, -10, +10, +10};

        if (player.isSingle()) {
            graphics.drawImage(playerIcon.getImage(), 790 + distance1, 790 + distance2, 50, 50, null);
        } else {
            graphics.drawImage(playerIcon.getImage(), 790+xModifier[player.getId()] + distance1, 790+yModifier[player.getId()] + distance2, 50, 50, null);
        }

    }

}
