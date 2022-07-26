package pl.monopoly.logic;

public abstract class Field {
    private static int nextNumber = 0;
    protected final int number = nextNumber++;
    protected Game game;

    // create
    public Field(Game game) {
        this.game = game;
    }

    // methods
    public abstract void action(Player player);

    // get/set
    public int getNumber() {
        return number;
    }
}
