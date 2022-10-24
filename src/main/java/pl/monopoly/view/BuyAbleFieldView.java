package pl.monopoly.view;


import pl.monopoly.logic.BuyAbleField;

import javax.swing.*;
import java.awt.*;

public class BuyAbleFieldView {
    private final BuyAbleField field;

    public BuyAbleFieldView(BuyAbleField field) {
        this.field = field;
    }

    public void render(Graphics g) {
        ImageIcon crossImage = switch (field.getOwner().getId()) {

            case 0 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\X_marks\\X_red.png");
            case 1 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\X_marks\\X_blue.png");
            case 2 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\X_marks\\X_green.png");
            case 3 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\X_marks\\X_purple.png");
            default -> throw new IllegalStateException("Unexpected value: " + field.getOwner().getId());
        };


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

        if (field.getNumber() > 0) {distance1 -= bigFieldAddition;}
        if (field.getNumber() >= 10) {distance1 -= bigFieldAddition;}
        if (field.getNumber() > 10) {distance2 -= bigFieldAddition;}
        if (field.getNumber() >= 20) {distance2 -= bigFieldAddition;}
        if (field.getNumber() > 20) {distance1 += bigFieldAddition;}
        if (field.getNumber() >= 30) {distance1 += bigFieldAddition;}
        if (field.getNumber() > 30) {distance2 += bigFieldAddition;}

        g.drawImage(crossImage.getImage(), 790 + distance1, 790 + distance2, 100, 100, null);
    }
}
