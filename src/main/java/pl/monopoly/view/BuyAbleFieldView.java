package pl.monopoly.view;


import pl.monopoly.logic.BuyAbleField;

import javax.swing.*;
import java.awt.*;

public record BuyAbleFieldView(BuyAbleField field) {

    public void renderX(Graphics g) {

        if (field.getOwner() == null) {
            return;
        }

        ImageIcon crossImage = switch (field.getOwner().getId()) {

            case 0 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\X_marks\\X_red.png");
            case 1 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\X_marks\\X_blue.png");
            case 2 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\X_marks\\X_green.png");
            case 3 -> new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\X_marks\\X_purple.png");
            default -> throw new IllegalStateException("Unexpected value: " + field.getOwner().getId());
        };


        int distance1 = 0, distance2 = 0, normalField = 73, bigFieldAddition = 15;

        if (field.getNumber() <= 10) {

            distance1 = -normalField * field.getNumber();

        } else if (field.getNumber() > 10 && field.getNumber() <= 20) {

            distance1 = -normalField * 10;
            distance2 = -normalField * (field.getNumber() - 10);

        } else if (field.getNumber() > 20 && field.getNumber() <= 30) {

            distance1 = -normalField * 10 + normalField * (field.getNumber() - 20);
            distance2 = -normalField * 10;

        } else if (field.getNumber() > 30) {

            distance2 = -normalField * 10 + normalField * (field.getNumber() - 30);

        }

        if (field.getNumber() > 0) {
            distance1 -= bigFieldAddition;
        }
        if (field.getNumber() >= 10) {
            distance1 -= bigFieldAddition;
        }
        if (field.getNumber() > 10) {
            distance2 -= bigFieldAddition;
        }
        if (field.getNumber() >= 20) {
            distance2 -= bigFieldAddition;
        }
        if (field.getNumber() > 20) {
            distance1 += bigFieldAddition;
        }
        if (field.getNumber() >= 30) {
            distance1 += bigFieldAddition;
        }
        if (field.getNumber() > 30) {
            distance2 += bigFieldAddition;
        }

//        g.setColor(Color.blue);
//        g.drawString("OWNED", 760 + distance1, 775 + distance2);
        g.drawImage(crossImage.getImage(), 760 + distance1, 775 + distance2, 100, 100, null);
    }

    public void renderHouse(Graphics g) {
        if (field.getOwner() == null || field.getHouses() < 1) {
            return;
        }

        ImageIcon crossImage = new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\houseImage.png");


        int distance1 = 0, distance2 = 0, normalField = 73, bigFieldAddition = 15;

        if (field.getNumber() <= 10) {

            distance1 = -normalField * field.getNumber();

        } else if (field.getNumber() > 10 && field.getNumber() <= 20) {

            distance1 = -normalField * 10;
            distance2 = -normalField * (field.getNumber() - 10);

        } else if (field.getNumber() > 20 && field.getNumber() <= 30) {

            distance1 = -normalField * 10 + normalField * (field.getNumber() - 20);
            distance2 = -normalField * 10;

        } else if (field.getNumber() > 30) {

            distance2 = -normalField * 10 + normalField * (field.getNumber() - 30);

        }

        if (field.getNumber() > 0) {
            distance1 -= bigFieldAddition;
        }
        if (field.getNumber() >= 10) {
            distance1 -= bigFieldAddition;
        }
        if (field.getNumber() > 10) {
            distance2 -= bigFieldAddition;
        }
        if (field.getNumber() >= 20) {
            distance2 -= bigFieldAddition;
        }
        if (field.getNumber() > 20) {
            distance1 += bigFieldAddition;
        }
        if (field.getNumber() >= 30) {
            distance1 += bigFieldAddition;
        }
        if (field.getNumber() > 30) {
            distance2 += bigFieldAddition;
        }


        if (field.getHouses() == 1) {
            g.drawImage(crossImage.getImage(), 785 + distance1, 780 + distance2, 35, 35, null);
        } else if (field.getHouses() == 2) {
            g.drawImage(crossImage.getImage(), 785 + distance1, 780 + distance2, 35, 35, null);
            g.drawImage(crossImage.getImage(), 820 + distance1, 780 + distance2, 35, 35, null);
        } else if (field.getHouses() == 3) {
            g.drawImage(crossImage.getImage(), 785 + distance1, 780 + distance2, 35, 35, null);
            g.drawImage(crossImage.getImage(), 820 + distance1, 780 + distance2, 35, 35, null);
            g.drawImage(crossImage.getImage(), 785 + distance1, 820 + distance2, 35, 35, null);
        } else if (field.getHouses() == 4) {
            g.drawImage(crossImage.getImage(), 785 + distance1, 780 + distance2, 35, 35, null);
            g.drawImage(crossImage.getImage(), 820 + distance1, 780 + distance2, 35, 35, null);
            g.drawImage(crossImage.getImage(), 785 + distance1, 820 + distance2, 35, 35, null);
            g.drawImage(crossImage.getImage(), 820 + distance1, 820 + distance2, 35, 35, null);
        }
    }
}
