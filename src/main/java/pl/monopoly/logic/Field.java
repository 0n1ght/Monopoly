package pl.monopoly.logic;

public abstract class Field {
    private static int nextNumber = 0;
    private final int number = nextNumber++;

    // methods
    public void action(Player player) {
        System.out.println("na polu " + number + " stanal gracz " + player);
    }

    // get/set
    public int getNumber() {
        return number;
    }
}
