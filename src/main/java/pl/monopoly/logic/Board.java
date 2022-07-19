package pl.monopoly.logic;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Field> fields = new ArrayList<>();

    public Board() {

        for (int i = 0; i < 40; i++) {
            fields.add(new Street());
        }

    }

    // get/set
    public Field getField(int number) {
        return fields.get(number);
    }

}
