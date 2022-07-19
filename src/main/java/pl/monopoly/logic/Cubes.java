package pl.monopoly.logic;

import java.util.Random;

public class Cubes {
    private Random random;
    private int roll1, roll2;
    private Game game;

    // create
    public Cubes(Game game) {
        this.game = game;
    }

    // methods
    public void rollTheDice() { //todo 2 numbers

        random = new Random();
        roll1 = random.nextInt(6)+1;
        roll2 = random.nextInt(6)+1;

       // player.setField(player.getField()+lastRoll);
        //todo przerobić program tak, żeby łatwo było w tym miejscu uzyskać gracza, którego jest teraz runda np. klasa logiki zarzadzajaca rundą

        game.actualPlayer().move(roll1+roll2);

        game.interactiveField(); //todo refactor

    }

    public int getRoll1() {
        return roll1;
    }
    public int getRoll2() {
        return roll2;
    }
}
