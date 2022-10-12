package pl.monopoly.view;

import java.io.IOException;

public class ViewFactory {

    public void createMenu() {

        MenuView menuView = new MenuView(this);
        menuView.displayMenu();
    }

    public void createSettings() {

        SettingsView settingsView = new SettingsView(this);
        settingsView.displaySettings();
    }

    public void createGame() throws IOException {
        MouseManager manager = new MouseManager();

        Gameplay gameplay = new Gameplay(manager);

        Display display = new Display(gameplay);
        display.addListener(manager);

        GameEngine gameEngine = new GameEngine(display, gameplay);
        gameEngine.start();

        display.showGame();
    }
}
