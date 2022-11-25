package pl.monopoly.logic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FieldFactory {
    private final Game game;
    private List<Field> fields;

    public FieldFactory(Game game) {
        this.game = game;
    }

    public List<Field> buildFields() throws IOException {
        fields = new ArrayList<>();

        BufferedReader bufferedWriter = new BufferedReader(new FileReader("src\\main\\resources\\fields.csv"));

        for (int i = 0; i < 40; i++) {

            String csv = bufferedWriter.readLine();
            String[] split = csv.split(",");

            if (split[1].equals("BUY")) {
                fields.add(new BuyAbleField(game, FieldSet.valueOf(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[2]), Integer.parseInt(split[3])));
            } else {
                fields.add(new UnBuyAbleField(game));
            }
        }

        return fields;
    }
}
