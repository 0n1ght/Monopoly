package pl.monopoly;

public class Player {
    private int field;
    private static int nextId = 0;
    private int id;

    private int money = 1_500;

    // create
    public Player() {

        id = nextId;
//        field = id;
        nextId++;
    }

    // methods
    public void checkPlayersMoves() {

        Thread thread = new Thread(()-> {
            try {
                while (true) {
                    Thread.sleep(500);
                    field++;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
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
