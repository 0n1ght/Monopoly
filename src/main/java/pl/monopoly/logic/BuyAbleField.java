package pl.monopoly.logic;

import javax.swing.*;

public class BuyAbleField extends Field{
    private Player owner;
    private FieldSet set;
    private int setSize;
    private int price;
    private int tax;

    public BuyAbleField(Game game, FieldSet set, int setSize, int price, int tax) {
        super(game);
        this.set = set;
        this.setSize = setSize;
        this.price = price;
        this.tax = tax;
    }

    @Override
    public void action(Player player, Board board) {

        if (owner == null && player.getMoney() >= price){

            int answer = game.getBoardView().askForBuyDialog(this);

            if (answer == JOptionPane.OK_OPTION) {
                player.pay(price);
                owner = player;
            }

        } else if (owner != null && !player.toString().equals(owner.toString())) {

            game.getBoardView().payRentInformation();
            player.setMoney(player.getMoney()-tax);

            owner.setMoney(owner.getMoney()+tax);

        }

    }

    public int getPrice() {
        return price;
    }
}
