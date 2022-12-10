package pl.monopoly.logic;

import pl.monopoly.view.BoardView;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Game {
    private final Board board = new Board(this);
    private final BoardView boardView = new BoardView();
    private List<Player> players;
    private int actual = 0;
    public static int playersNumber;

    public Game() throws IOException {}

    // methods
    //setup

    public void addPlayers(List<Player> players) {

        playersNumber = players.size();
        this.players = new LinkedList<>(players.subList(0, SettingsState.getInstance().getPlayersNumber()));
    }

    public Player actualPlayer() {
        return players.get(actual);
    }

    public void interactiveField() {
        board.getField(actualPlayer().getFieldNumber()).action(actualPlayer(), board);
    }

    public void nextRound() {

        if (playersNumber == 1) {
            int answer = boardView.getWinInformation(actualPlayer());
            if (answer == JOptionPane.OK_CANCEL_OPTION) {
                // odpalic createMenu z ViewFactry
            } else {
                // wywolac stop z GameEngine
                System.exit(0);
            }

        } else if (actualPlayer().isBankrupt()) {
            boardView.getLoseInformation(actualPlayer());
            board.clearBankruptsFields(actualPlayer());
            players.remove(actualPlayer());
            playersNumber-=1;
        }

        if (actual<playersNumber-1) {
            actual++;
        } else {
            actual = 0;
        }
    }

    public boolean hasAllSet(Player player, FieldSet fieldSet) {

        return board.hasAllSet(player, fieldSet);
    }

    // get/set
    public BoardView getBoardView() {
        return boardView;
    }

    public boolean playerSingle(Player player) {
        int replays = 0;

        for (Player player1 : players) {
            if (player.getFieldNumber() == player1.getFieldNumber()) {
                replays++;
            }
        }

        if (replays == 1) {
            return true;
        }
        return false;

    }

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }
}
