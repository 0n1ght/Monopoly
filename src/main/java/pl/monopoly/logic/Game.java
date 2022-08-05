package pl.monopoly.logic;

import pl.monopoly.view.BoardView;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {
    Player player1, player2, player3, player4;
    private final Board board = new Board(this);
    private final BoardView boardView = new BoardView();
    private Deque<Player> queue;
    public static int playersNumber = 4;
    private static boolean checkedPlayersNumber = false;

    // methods

    public Player actualPlayer() {

        if (!checkedPlayersNumber) {
            checkedPlayersNumber = true;
            switch (playersNumber) {
                case 2 -> {queue.removeLast(); queue.removeLast();}
                case 3 -> queue.removeLast();
            }
        }

        if (queue.isEmpty()) {

            switch (playersNumber) {
                case 2 -> queue = new LinkedList<>(List.of(player1, player2));
                case 3 -> queue = new LinkedList<>(List.of(player1, player2, player3));
                case 4 -> queue = new LinkedList<>(List.of(player1, player2, player3, player4));
            }

            return queue.peek();
        }

        return queue.peek();
    }

    public void interactiveField() {

        board.getField(actualPlayer().getFieldNumber()).action(actualPlayer());

    }

    public void nextRound() {
        queue.remove();
    }

    public void setPlayers(Player player1, Player player2, Player player3, Player player4) {

        switch (playersNumber) {
            case 2 -> {
                this.player1 = player1;
                this.player2 = player2;
            }
            case 3 -> {
                this.player1 = player1;
                this.player2 = player2;
                this.player3 = player3;
            }
            case 4 -> {
                this.player1 = player1;
                this.player2 = player2;
                this.player3 = player3;
                this.player4 = player4;
            }
        }

        queue = new LinkedList<>(List.of(this.player1, this.player2, this.player3, this.player4));

        switch (playersNumber) {
            case 2 -> {
                queue.removeLast();
                queue.removeLast();
            }
            case 3 -> queue.removeLast();
        }
    }

    // get/set
    public BoardView getBoardView() {
        return boardView;
    }
}
