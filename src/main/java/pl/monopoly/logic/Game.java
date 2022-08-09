package pl.monopoly.logic;

import pl.monopoly.view.BoardView;
import pl.monopoly.view.Display;

import java.util.LinkedList;
import java.util.List;

public class Game {
   private Player player1, player2, player3, player4;
    private final Board board = new Board(this);
    private final BoardView boardView = new BoardView();
    private LinkedList<Player> queue;
    public static int playersNumber = 4;
    private static Game game = null;

    public Game() {
        game = this;
    }

    // methods
    //setup
    public static void setPlayers(List<Player> players) {
        game.queue = new LinkedList<>(players.subList(0,playersNumber));
    }

    public Player actualPlayer() {
        return queue.peek();
    }

    public void interactiveField() {

        board.getField(actualPlayer().getFieldNumber()).action(actualPlayer(), board);

    }

    public void nextRound() {
        Display.refreshScoreBoard();
        Player actual = queue.remove();
        queue.add(actual);
    }

    // get/set
    public BoardView getBoardView() {
        return boardView;
    }

    public static void refresh(){
        game.queue = new LinkedList<>(game.queue.subList(0,playersNumber));
    }
}
