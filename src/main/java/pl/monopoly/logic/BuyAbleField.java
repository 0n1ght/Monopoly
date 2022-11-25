package pl.monopoly.logic;

import javax.swing.*;

public class BuyAbleField extends Field{
    private Player owner;
    private FieldSet set;
    private int setSize;
    private final int price;
    private final int baseTax;

    // methods
    public BuyAbleField(Game game, FieldSet set, int setSize, int price, int tax) {
        super(game);
        this.set = set;
        this.setSize = setSize;
        this.price = price;
        this.baseTax = tax;
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

            game.getBoardView().payRentInformation(this);
            player.setMoney(player.getMoney()- baseTax);

            owner.setMoney(owner.getMoney()+ baseTax);

        }

    }

    @Override
    public boolean isBuyAble() {
        return true;
    }

    // get/set
    public int getPrice() {
        return price;
    }

    public Player getOwner() {
        return owner;
    }

    public int getFullTax() {
        if (game.hasAllSet(owner, set)) {
            return baseTax*2;
        }

        return baseTax;
    }

    public FieldSet getSet() {
        return set;
    }

    @Override
    public String toString() {
        return "BuyAbleField{" +
                "owner=" + owner +
                ", set=" + set +
                ", setSize=" + setSize +
                ", price=" + price +
                ", tax=" + baseTax +
                '}';
    }
}
