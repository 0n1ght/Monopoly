package pl.monopoly.logic;

import javax.swing.*;
import java.awt.*;

public class Street extends Field{
    private static int nextPrice = 60;
    private final int price = nextPrice+=10;
    private int housesNumber;
    private Player owner;
    private static int[] buyAbleFields = {1, 3, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 27, 29, 31, 32, 34, 37, 39};

    public Street(Game game) {
        super(game);
    }

    @Override
    public void action(Player player, Board board) {

        for (int buyAbleField : buyAbleFields) {

            if (player.getFieldNumber() == buyAbleField) {

                if (owner == null && player.getMoney() > price)
                    game.getBoardView().askForBuy(this);

            }
        }



    }

    public void buyField() {

        owner = game.actualPlayer();
        owner.pay(price);

    }

    public int getPrice() {
        return price;
    }


}
