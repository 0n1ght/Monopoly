package pl.monopoly.logic;

import java.util.Random;

public class Cubes {
    private Random random;
    private int lastRoll;
    private Game game;

    // create
    public Cubes(Game game) {
        this.game = game;
    }

    // methods
    public int rollTheDice() { //todo 2 numbers

        random = new Random();
        lastRoll = random.nextInt(6)+1;

       // player.setField(player.getField()+lastRoll);
        //todo przerobić program tak, żeby łatwo było w tym miejscu uzyskać gracza, którego jest teraz runda np. klasa logiki zarzadzajaca rundą

        System.out.println(game);

        game.actualPlayer().move(lastRoll);

        return lastRoll;
    }

    public int getLastRoll() {
        return lastRoll;
    }
}
