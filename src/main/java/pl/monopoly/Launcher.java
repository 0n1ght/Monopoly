package pl.monopoly;

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
