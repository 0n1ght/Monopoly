package pl.monopoly.view;

import pl.monopoly.view.CubesView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener {

    private CubesView cubesView;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        Rectangle rectangle = new Rectangle(e.getX(), e.getY(), 1, 1);
        if (cubesView.getBounds().intersects(rectangle)) {

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
