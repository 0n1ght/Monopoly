package pl.monopoly;

import pl.monopoly.view.Display;
import pl.monopoly.view.GameEngine;
import pl.monopoly.view.Gameplay;
import pl.monopoly.view.MouseManager;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        MouseManager manager = new MouseManager();

        Display display = new Display();
        display.addListener(manager);

        Gameplay gameplay = new Gameplay(manager);



        GameEngine gameEngine = new GameEngine(display, gameplay);
        gameEngine.start();

    }

}
