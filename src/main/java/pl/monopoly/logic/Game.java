package pl.monopoly.logic;

import pl.monopoly.view.BoardView;

public class Game {
    private Player player1;
    private Player player2;
    private int roundNumber;
    private final Board board = new Board(this);
    private final BoardView boardView = new BoardView();

    // methods
    public Player actualPlayer() {

        if (roundNumber%2 == 0) {
            return player1;
        }

        return player2;

    }

    public void interactiveField() {

        board.getField(actualPlayer().getFieldNumber()).action(actualPlayer());

    }

    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void nextRound() {
        roundNumber++;
    }

    // get/set
    public BoardView getBoardView() {
        return boardView;
    }
}
