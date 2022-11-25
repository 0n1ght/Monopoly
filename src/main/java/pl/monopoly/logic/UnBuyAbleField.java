package pl.monopoly.logic;

public class UnBuyAbleField extends Field{

    public UnBuyAbleField(Game game) {
        super(game);
    }

    @Override
    public void action(Player player, Board board) {

    }

    @Override
    public boolean isBuyAble() {
        return false;
    }
}
