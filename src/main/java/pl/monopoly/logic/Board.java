package pl.monopoly.logic;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Field> fields = new ArrayList<>();

    public Board(Game game) {

        for (int i = 0; i < 40; i++) {
            fields.add(new Street(game));
        }

    }

    // getq/set
    public Field getField(int number) {
        number = number == 40 ? 0 : number;
        return fields.get(number);
    }

}
