package pl.monopoly;

import java.util.Random;

public class Cubes {
    private Random random;
    private int lastRoll;

    // methods
    public int rollTheDice() { //todo 2 numbers

        random = new Random();
        lastRoll = random.nextInt(6)+1;

       // player.setField(player.getField()+lastRoll);
        //todo przerobić program tak, żeby łatwo było w tym miejscu uzyskać gracza, którego jest teraz runda np. klasa logiki zarzadzajaca rundą

        return lastRoll;
    }

    public int getLastRoll() {
        return lastRoll;
    }
}
