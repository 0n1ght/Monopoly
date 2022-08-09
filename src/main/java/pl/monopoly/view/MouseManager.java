package pl.monopoly.view;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class MouseManager implements MouseListener {

    private CubesView cubesView;

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {

        Rectangle rectangle = new Rectangle(e.getX(), e.getY(), 1, 1);
        if (cubesView.getBounds().intersects(rectangle)) {
            try { //todo D
                Gameplay.playSound("src\\main\\resources\\sounds\\mixkit-mouse-click-close-1113.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
            cubesView.roll();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // get/set
    public void setCubesView(CubesView cubesView) {
        this.cubesView = cubesView;
    }
}
