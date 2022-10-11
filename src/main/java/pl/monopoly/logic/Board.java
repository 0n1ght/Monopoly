package pl.monopoly.logic;

import java.io.IOException;
import java.util.List;

public class Board {
    private final List<Field> fields;

    public Board(Game game) throws IOException {

        FieldFactory fieldFactory = new FieldFactory(game);
        fields = fieldFactory.buildFields();

    }

    // get/set
    public Field getField(int number) {
        number = number == 40 ? 0 : number;
        return fields.get(number);
    }

}
