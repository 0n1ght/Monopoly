package pl.monopoly.view;


import pl.monopoly.logic.BuyAbleField;

import javax.swing.*;
import java.awt.*;

public class BuyAbleFieldView {
    private BuyAbleField field;

    public BuyAbleFieldView(BuyAbleField field) {
        this.field = field;
    }

    public void render(Graphics g) {
        ImageIcon crossImage = new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\X_marks\\X_red.png");

        int distance1 = 0, distance2 = 0, normalField = 73, bigFieldAddition = 15;

        if (field.getNumber() <= 10) {

            distance1 = - normalField * field.getNumber();

        } else if (field.getNumber() > 10 && field.getNumber() <= 20) {

            distance1 = - normalField * 10;
            distance2 = - normalField * (field.getNumber() - 10);

        } else if (field.getNumber() > 20 && field.getNumber() <= 30) {

            distance1 = -normalField * 10 + normalField * (field.getNumber() - 20);
            distance2 = -normalField * 10;

        } else if (field.getNumber() > 30) {

            distance2 = -normalField * 10 + normalField * (field.getNumber() - 30);

        }

        g.drawImage(crossImage.getImage(), 790 + distance1, 790 + distance2, 50, 50, null);
    }
}
