package pl.monopoly.logic;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Field> fields = new ArrayList<>();
    private Game game;

    public Board(Game game) {
        this.game = game;

        for (int i = 0; i < 40; i++) {
            fields.add(new Street(game));
        }

    }

    // get/set
    public Field getField(int number) {
        return fields.get(number);
    }

}
