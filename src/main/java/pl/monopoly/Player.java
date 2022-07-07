package pl.monopoly;

public class Player {
    private int field;
    private static int nextId = 0;
    private int id;

    // create
    public Player() {
        id = nextId;
        field = id+35;
        nextId++;
    }

    // get/set
    public int getId() {
        return id;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

}
