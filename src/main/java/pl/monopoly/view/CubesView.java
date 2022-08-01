package pl.monopoly.view;

import pl.monopoly.logic.Cubes;

import javax.swing.*;
import java.awt.*;

public class CubesView {
    private Cubes cubes;
    private final ImageIcon imageIcon = new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubeImage.png");
    private final int positionX = 460;
    private final int positionY = 550;
    private final int width = 240;
    private final int height = 240;

    // create
    public CubesView(Cubes cubes) {
        this.cubes = cubes;
    }

    // methods
    public void render(Graphics g) {

        g.drawString("Click to randomize !", positionX+30, positionY+2);
        g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesFrameImage.png").getImage(), positionX, positionY, 240, 150, null);
        g.drawImage(imageIcon.getImage(), positionX-10, positionY+15, 200, 130, null);
        g.drawImage(imageIcon.getImage(), positionX+50, positionY+20, 200, 130, null);

        if (cubes.getRoll1() != 0 && cubes.getRoll2() != 0) {

            g.drawString(String.valueOf(cubes.getRoll1()), positionX + width + 10, positionY);
            g.drawString(String.valueOf(cubes.getRoll2()), positionX + width + 10 + 15, positionY);

            switch (cubes.getRoll1()) {
                case 1: g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesAllImages\\cube1pImage.png").getImage(), positionX+50, positionY+40, 60, 60, null);
                    break;
                case 2: g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesAllImages\\cube2pImage.png").getImage(), positionX+50, positionY+40, 60, 60, null);
                    break;
                case 3: g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesAllImages\\cube3pImage.png").getImage(), positionX+50, positionY+40, 60, 60, null);
                    break;
                case 4: g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesAllImages\\cube4pImage.png").getImage(), positionX+50, positionY+40, 60, 60, null);
                    break;
                case 5: g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesAllImages\\cube5pImage.png").getImage(), positionX+50, positionY+40, 60, 60, null);
                    break;
                case 6: g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesAllImages\\cube6pImage.png").getImage(), positionX+50, positionY+40, 60, 60, null);
            }

            switch (cubes.getRoll2()) {
                case 1: g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesAllImages\\cube1pImage.png").getImage(), positionX+115, positionY+40, 60, 60, null);
                    break;
                case 2: g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesAllImages\\cube2pImage.png").getImage(), positionX+115, positionY+40, 60, 60, null);
                    break;
                case 3: g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesAllImages\\cube3pImage.png").getImage(), positionX+115, positionY+40, 60, 60, null);
                    break;
                case 4: g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesAllImages\\cube4pImage.png").getImage(), positionX+115, positionY+40, 60, 60, null);
                    break;
                case 5: g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesAllImages\\cube5pImage.png").getImage(), positionX+115, positionY+40, 60, 60, null);
                    break;
                case 6: g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesAllImages\\cube6pImage.png").getImage(), positionX+115, positionY+40, 60, 60, null);
            }
        }

    }

    public void roll() {

        cubes.rollTheDice();

    }

    // get/set
    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public Rectangle getBounds() {

        Rectangle rectangle = new Rectangle(positionX, positionY, width, height);
        return rectangle;
    }

}
