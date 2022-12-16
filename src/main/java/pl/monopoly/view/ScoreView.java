package pl.monopoly.view;

import pl.monopoly.logic.Player;

import java.awt.*;
import java.util.List;

public class ScoreView {
    private final List<Player> playerList;

    public ScoreView(List<Player> playerList) {

        this.playerList = playerList;
    }

    public void render(Graphics g) {
        int x = Display.getWidth()-730-Display.getRelativeX()*2;
        int y = Display.getHeight()-205-Display.getRelativeY()*2;

        g.setColor(new Color(255,255,204));
        g.fillRect(x, y, 250, 60);
        g.setColor(new Color(255,204,0));
        g.drawRect(x, y, 250, 60);
        g.setFont(new Font("Serif", Font.BOLD, 20));

        g.setColor(new Color(204,0,0));
        if (playerList.get(0).getMoney() > 0) {
            g.drawString("red: " + playerList.get(0).getMoney()+"$", x+15, y+23);
        } else {
            g.drawString("red: " + "----", x+15, y+23);
        }

        g.setColor(new Color(0,0,225));
        if (playerList.size() >= 2 && playerList.get(1).getMoney() > 0) {
            g.drawString("blue: " + playerList.get(1).getMoney()+"$", x+130, y+23);
        } else {
            g.drawString("blue: " + "----", x+130, y+23);
        }

        g.setColor(new Color(0,153,0));
        if (playerList.size() >= 3 && playerList.get(2).getMoney() > 0) {
            g.drawString("vert: " + playerList.get(2).getMoney()+"$", x+15, y+50);
        } else {
            g.drawString("vert: " + "----", x+15, y+50);
        }

        g.setColor(new Color(102,0,153));
        if (playerList.size() >= 4 && playerList.get(3).getMoney() > 0) {
            g.drawString("pink: " + playerList.get(3).getMoney()+"$", x+130, y+50);
        } else {
            g.drawString("pink: " + "----", x+130, y+50);
        }
    }
}
