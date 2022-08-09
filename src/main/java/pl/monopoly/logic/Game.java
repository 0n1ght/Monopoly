package pl.monopoly.logic;

import pl.monopoly.view.BoardView;
import pl.monopoly.view.Display;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
   private Player player1, player2, player3, player4;
    private final Board board = new Board(this);
    private final BoardView boardView = new BoardView();
    private LinkedList<Player> queue;
    public static int playersNumber = 4;
    private static boolean checkedPlayersNumber = false;
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

      /*  if (!checkedPlayersNumber) {
            checkedPlayersNumber = true;
            switch (playersNumber) {
                case 2 -> {queue.removeLast(); queue.removeLast();}
                case 3 -> queue.removeLast();
            }
        }*/

      /*  if (queue.isEmpty()) {
            switch (playersNumber) {
                case 2 -> queue = new LinkedList<>(List.of(player1, player2));
                case 3 -> queue = new LinkedList<>(List.of(player1, player2, player3));
                case 4 -> queue = new LinkedList<>(List.of(player1, player2, player3, player4));
            }

            return queue.peek();
        }*/
        return queue.peek();
    }

    public void interactiveField() {

        board.getField(actualPlayer().getFieldNumber()).action(actualPlayer(), board);

    }

    public void nextRound() {
        Display.refreshScoreBoard();
        Player actual = queue.remove();
        queue.add(actual);
        System.out.println(queue);
    }

    // get/set
    public BoardView getBoardView() {
        return boardView;
    }

    public static void refresh(){
        game.queue = new LinkedList<>(game.queue.subList(0,playersNumber));
    }
}
