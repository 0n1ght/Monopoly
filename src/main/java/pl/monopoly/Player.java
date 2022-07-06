package pl.monopoly;

public class Player {
    private int field;
    private static int nextId = 0;
    private int id;

    // create
    public Player() {
        id = nextId;
//        field = id;
        nextId++;
    }

    // get/set
    public int getId() {
        return id;
    }

    public int getField() {
        return field;
    }

}
