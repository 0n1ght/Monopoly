package pl.monopoly.logic;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldFactory {

    public List<Field> buildFields() throws IOException {
        List<Field> fields = new ArrayList<>();
        int fieldNumber, price, tax;
        boolean buyAble;
        FieldGroup fieldGroup;

        BufferedReader bufferedWriter = new BufferedReader(new FileReader("src\\main\\resources\\fields.csv"));

        for (int i = 0; i < 40; i++) {
            String csv = bufferedWriter.readLine();
            String[] split = csv.split(",");

            System.out.println(Arrays.toString(split));

            fieldNumber = Integer.parseInt(split[0]);
            buyAble = split[1].equals("BUY");

            if (buyAble) {

                price = Integer.parseInt(split[2]);
                tax = Integer.parseInt(split[3]);
                fieldGroup = FieldGroup.valueOf(split[4]);
            }

        }

        return fields;
    }
}
