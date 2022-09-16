package pl.monopoly.view;

import javax.swing.*;
import java.awt.*;

public class SettingsButtonView extends CustomButtonView{

    public SettingsButtonView() {
        super(140, 45, Display.DEFAULT_WIDTH - 270, Display.DEFAULT_HEIGHT - 750);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(new ImageIcon("src\\main\\java\\pl\\monopoly\\images\\cubesFrameImage.png").getImage(), positionX, positionY, width, height, null); //todo dynamiczne ścieżki

    }

    @Override
    public void click() {
        SoundPlayer.playSound(Sound.BUTTON_CLICK);
        System.out.println("show settings");  //todo ma wyskoczyć okno, było wcześniej robione przez metode klasy Display
    }
}
