package pl.monopoly.view;

import pl.monopoly.logic.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerView {
    private final Player player;

    // create
    public PlayerView(Player player, Player player1, Player player2, Player player3) {

        player.setEnemies(new Player[]{player1, player2, player3});

        this.player = player;

    }

    public void render(Graphics graphics) {

        int distance1=0, distance2=0, normalField = 73, bigFieldAddition = 15;

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

        new ImageIcon("");
        ImageIcon playerIcon = switch (player.getId()) {
            case 0 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\playersImages\\red.png");
            case 1 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\playersImages\\blue.png");
            case 2 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\playersImages\\green.png");
            case 3 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\playersImages\\purple.png");
            default -> new ImageIcon();
        };
        graphics.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 30));
        graphics.setColor(Color.GREEN);


        if (player.getId() == 0) {

            if (player.getFieldNumber() == player.getEnemies()[0].getFieldNumber() || player.getFieldNumber() == player.getEnemies()[1].getFieldNumber() || player.getFieldNumber() == player.getEnemies()[2].getFieldNumber()) {
                graphics.drawImage(playerIcon.getImage(), 790-10 + distance1, 790-10 + distance2, 50, 50, null);
            } else {
                graphics.drawImage(playerIcon.getImage(), 790 + distance1, 790 + distance2, 50, 50, null);
            }

        }

        if (player.getId() == 1) {

            if (player.getFieldNumber() == player.getEnemies()[0].getFieldNumber() || player.getFieldNumber() == player.getEnemies()[1].getFieldNumber() || player.getFieldNumber() == player.getEnemies()[2].getFieldNumber()) {
                graphics.drawImage(playerIcon.getImage(), 790+10 + distance1, 790-10 + distance2, 50, 50, null);
            } else {
                graphics.drawImage(playerIcon.getImage(), 790 + distance1, 790 + distance2, 50, 50, null);
            }

        }

        if (player.getId() == 2) {

            if (player.getFieldNumber() == player.getEnemies()[0].getFieldNumber() || player.getFieldNumber() == player.getEnemies()[1].getFieldNumber() || player.getFieldNumber() == player.getEnemies()[2].getFieldNumber()) {
                graphics.drawImage(playerIcon.getImage(), 790-10 + distance1, 790+10 + distance2, 50, 50, null);
            } else {
                graphics.drawImage(playerIcon.getImage(), 790 + distance1, 790 + distance2, 50, 50, null);
            }

        }

        if (player.getId() == 3) {

            if (player.getFieldNumber() == player.getEnemies()[0].getFieldNumber() || player.getFieldNumber() == player.getEnemies()[1].getFieldNumber() || player.getFieldNumber() == player.getEnemies()[2].getFieldNumber()) {
                graphics.drawImage(playerIcon.getImage(), 790+10 + distance1, 790+10 + distance2, 50, 50, null);
            } else {
                graphics.drawImage(playerIcon.getImage(), 790 + distance1, 790 + distance2, 50, 50, null);
            }

        }

    }

}
