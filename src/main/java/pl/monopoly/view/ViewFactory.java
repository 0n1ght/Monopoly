package pl.monopoly.view;

public class ViewFactory {

    public void createMenu() {

        MenuView menuView = new MenuView(this);
        menuView.displayMenu();
    }

    public void createSettings() {

        SettingsView settingsView = new SettingsView(this);
        settingsView.displaySettings();
    }

    public void createGame() {
        MouseManager manager = new MouseManager();

        Gameplay gameplay = new Gameplay(manager, 4);

        Display display = new Display(gameplay);
        display.addListener(manager);

        GameEngine gameEngine = new GameEngine(display, gameplay);
        gameEngine.start();

        display.showGame();
    }

}
