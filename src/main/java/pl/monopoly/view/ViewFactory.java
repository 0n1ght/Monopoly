package pl.monopoly.view;

import java.io.IOException;

public class ViewFactory {

    //przechowywanie game Engine

    public void createMenu() {

        MenuView menuView = new MenuView(this);
        menuView.displayMenu();
    }

    public void createSettings() {

        SettingsView settingsView = new SettingsView(this);
        settingsView.displaySettings();
    }

    public void createGame() throws IOException {
        //jesli jest engine to nie rob nic
        MouseManager manager = new MouseManager();

        Gameplay gameplay = new Gameplay(manager); //przekazać mu VF

        Display display = new Display();
        display.addListener(manager);

        GameEngine gameEngine = new GameEngine(display, gameplay);
        gameEngine.start();

        display.showGame();
    }

    //stop engine ktora wywoluje stop i np. ustawia null
}
