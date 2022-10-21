package pl.monopoly.view;

import pl.monopoly.logic.Game;
import pl.monopoly.logic.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ScoreView {
    private List<Player> playerList;

    public ScoreView(List<Player> playerList) {

        this.playerList = playerList;
    }

    public void render(Graphics g) {
        int x = Display.getWidth()-730;
        int y = Display.getHeight()-205;

        g.setColor(new Color(255,255,204));
        g.fillRect(x, y, 250, 60);
        g.setColor(new Color(255,204,0));
        g.drawRect(x, y, 250, 60);
        g.setFont(new Font("Serif", Font.BOLD, 20));
        g.setColor(Color.RED);
        g.setColor(new Color(204,0,0));
        g.drawString("red: " + playerList.get(0).getMoney()+"$", x+15, y+23);
        g.setColor(new Color(0,0,225));
        g.drawString("blue: " + playerList.get(1).getMoney()+"$", x+130, y+23);
        g.setColor(new Color(0,153,0));
        g.drawString("vert: " + playerList.get(2).getMoney()+"$", x+15, y+50);
        g.setColor(new Color(102,0,153));
        g.drawString("pink: " + playerList.get(3).getMoney()+"$", x+130, y+50);
    }
}

//    private void addScoreBoard() {
//
//        JPanel panel = new JPanel();
//        panel.setBorder(BorderFactory.createBevelBorder(0, new Color(255,204,0), new Color(255,204,0)));
//        panel.setBackground(new Color(255,255,204));
//        panel.setBounds(frame.getWidth()-730, frame.getHeight()-205, 250, 60);
//        panel.setLayout(null);
//
//        SBLabels.get(1).setText("blue: " + ((Player) Game.getPlayers().get(1)).getMoney()+"$");
//        SBLabels.get(1).setFont(new Font("Serif", Font.ITALIC, 20));
//        SBLabels.get(1).setForeground(new Color(0,0,225));
//        SBLabels.get(1).setBounds(130,5,125,25);
//
//        SBLabels.get(2).setText("vert: " + ((Player) Game.getPlayers().get(2)).getMoney()+"$");
//        SBLabels.get(2).setFont(new Font("Serif", Font.ITALIC, 20));
//        SBLabels.get(2).setForeground(new Color(0,153,0));
//        SBLabels.get(2).setBounds(15,32,125,25);
//
//        SBLabels.get(3).setText("pink: " + ((Player) Game.getPlayers().get(3)).getMoney()+"$");
//        SBLabels.get(3).setFont(new Font("Serif", Font.ITALIC, 20));
//        SBLabels.get(3).setForeground(new Color(102,0,153));
//        SBLabels.get(3).setBounds(130,32,125,25);
//
//        panel.add(SBLabels.get(0));
//        panel.add(SBLabels.get(1));
//        panel.add(SBLabels.get(2));
//        panel.add(SBLabels.get(3));
//
//        frame.add(panel);
//    }
//
//    public static void refreshScoreBoard() {
//
//        SBLabels.get(0).setText("red: " + (Game.getPlayers().get(0)).getMoney()+"$");
//        SBLabels.get(1).setText("blue: " + ((Player) Game.getPlayers().get(1)).getMoney()+"$");
//        SBLabels.get(2).setText("vert: " + ((Player) Game.getPlayers().get(2)).getMoney()+"$");
//        SBLabels.get(3).setText("pink: " + ((Player) Game.getPlayers().get(3)).getMoney()+"$");
//    }