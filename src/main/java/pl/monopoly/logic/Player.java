package pl.monopoly.logic;

public class Player {
    private int field;
    private static int nextId = 0;
    private final int id;
    private int money = 1_500; //todo menu
    private final Game game;

    // create
    public Player(Game game) {

        id = nextId;
        nextId++;

        this.game = game;
    }

    // methods

    public void move(int movesNumber){

        field += movesNumber;

        if (field > 40) {

            money += 100;
            field -= 40;
        }

    }

    public void pay(int price) {

        money -= price;

    }

    // get/set
    public int getId() {
        return id;
    }

    public int getFieldNumber() {
        return field;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Player " + id;
    }
}
