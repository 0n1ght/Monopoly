package pl.monopoly;

import pl.monopoly.view.Display;
import pl.monopoly.view.GameEngine;
import pl.monopoly.view.Gameplay;
import pl.monopoly.view.MouseManager;

public class Launcher {

    public static void main(String[] args) {

        MouseManager manager = new MouseManager();

        Display display = new Display("Monopoly");
        display.addListener(manager);

        Gameplay gameplay = new Gameplay(manager);



        GameEngine gameEngine = new GameEngine(display, gameplay);
        gameEngine.start();

    }

}
