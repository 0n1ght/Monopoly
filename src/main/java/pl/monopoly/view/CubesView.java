package pl.monopoly.view;

import pl.monopoly.logic.Cubes;

import javax.swing.*;
import java.awt.*;

public class CubesView extends CustomButtonView{
    private final Cubes cubes;
    private int heightOneCube = 130;
    private int widthOneCube = 200;

    // create
    public CubesView(Cubes cubes) {
        super(240, 150, 460, 550);
        this.cubes = cubes;
    }

    // methods
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("Click to randomize !", positionX + 30, positionY + 2);
        g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesFrameImage.png").getImage(), positionX, positionY, width, height, null);

        showCube(cubes.getRoll1(), 0,g);
        showCube(cubes.getRoll2(), 72,g);
    }

    public void showCube(int number, int gap, Graphics g) {
        ImageIcon imageIcon;
        imageIcon = new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesAllImages\\cube" + number + "pImage.png");
        if (number != 0) {
            g.drawImage(imageIcon.getImage(), positionX + 35+gap, positionY + 27, 100, 100, null);
            return;
        }
        g.drawImage(imageIcon.getImage(), positionX - 10, positionY + 15, widthOneCube, heightOneCube, null);
        g.drawImage(imageIcon.getImage(), positionX + 50, positionY + 20, widthOneCube, heightOneCube, null);
    }

    public void click() {
        SoundPlayer.playSound(Sound.DRAW_CLICK);
        cubes.rollTheDice();
    }
}
