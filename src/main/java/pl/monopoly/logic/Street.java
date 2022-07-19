package pl.monopoly.logic;

public class Street extends Field{
    private static int nextPrice = 60;
    private final int price = nextPrice+=10;
    private int housesNumber;
    private Player owner;
}
