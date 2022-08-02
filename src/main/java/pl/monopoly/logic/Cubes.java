package pl.monopoly.logic;

import java.util.Random;

public class Cubes {
    private Random random;
    private int roll1, roll2;
    private final Game game;

    // create
    public Cubes(Game game) {
        this.game = game;
    }

    // methods
    public void rollTheDice() {

        random = new Random();
        roll1 = random.nextInt(6)+1;
        roll2 = random.nextInt(6)+1;

        game.actualPlayer().move(roll1+roll2);

        game.interactiveField();

        game.nextRound();

    }

    public int getRoll1() {
        return roll1;
    }
    public int getRoll2() {
        return roll2;
    }
}
