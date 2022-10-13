package pl.monopoly.logic;

import pl.monopoly.view.BoardView;
import pl.monopoly.view.Display;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Game {
    private final Board board = new Board(this);
    private final BoardView boardView = new BoardView();
    private static LinkedList<Player> queue;
    public static int playersNumber;

    public Game() throws IOException {}

    // methods
    //setup

    public void addPlayers(List<Player> players) {

        playersNumber = players.size();
        queue = new LinkedList<>(players.subList(0, SettingsState.getInstance().getPlayersNumber()));
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

    public boolean playerSingle(Player player) {
        int replays = 0;

        for (Player player1 : queue) {
            if (player.getFieldNumber() == player1.getFieldNumber()) {
                replays++;
            }
        }

        if (replays == 1) {
            return true;
        }
        return false;

    }
    public static List getQueue() {
        return queue;
    }
}
