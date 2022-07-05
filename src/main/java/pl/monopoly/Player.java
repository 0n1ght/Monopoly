package pl.monopoly;

public class Player {
    private int field = 0;
    private static int nextId = 0;
    private int id;

    // create
    public Player() {
        id = nextId;
        nextId++;
    }

    // get/set
    public int getId() {
        return id;
    }

}
