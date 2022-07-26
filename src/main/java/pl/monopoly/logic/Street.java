package pl.monopoly.logic;

public class Street extends Field{
    private static int nextPrice = 60;
    private final int price = nextPrice+=10;
    private int housesNumber;
    private Player owner;

    public Street(Game game) {
        super(game);
    }

    @Override
    public void action(Player player) {

        System.out.println("To pole nalezy do: " + owner);
        System.out.println("na polu " + number + " stanal gracz " + player);

        if (player.getMoney() > price) {
            game.getBoardView().askForBuy(this);
        }

    }

    public void buyField() {

        System.out.println("pole kupione " + number + " kupione!");
        owner = game.actualPlayer();
        owner.pay(price);

    }

    public int getPrice() {
        return price;
    }


}
