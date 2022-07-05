package pl.monopoly;

public class Launcher {

    public static void main(String[] args) {

        Display display = new Display("Monopoly");
        Gameplay gameplay = new Gameplay();
        GameEngine gameEngine = new GameEngine(display, gameplay);
        
        gameEngine.start();

    }

}
