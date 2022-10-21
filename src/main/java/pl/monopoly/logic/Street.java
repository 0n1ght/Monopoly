package pl.monopoly.logic;

import javax.swing.*;

public class Street extends Field{
    private static int nextPrice = 60;
    private final int price = nextPrice+=10;
    private Player owner;

    public Street(Game game) {
        super(game);
    }

    @Override
    public void action(Player player, Board board) {
        int[] giftFields = {2, 4, 5, 12, 15, 17, 25, 28, 33, 35, 38};
        int[] bonusDrawFields = {7, 22, 63};
        int[] jailFields = {10, 30};

        //

        for (int giftField : giftFields) {

            if (player.getFieldNumber() == giftField) {

                game.getBoardView().giveFreeBoundsInformation();
                player.setMoney(player.getMoney()+200);
            }
        }

        for (int bonusDrawField : bonusDrawFields) {

            if (player.getFieldNumber() == bonusDrawField) {

                game.getBoardView().giveFreeDrawInformation();
            }
        }

        for (int jailField : jailFields) {

            if (player.getFieldNumber() == jailField) {

                int answer = game.getBoardView().goToJailInformation();

                if (answer == JOptionPane.OK_OPTION) {
                    player.pay(400);
                }
            }
        }

        if (player.getMoney() < 0) {

            game.getBoardView().loseInformation(String.valueOf(player.getId()));

        }

    }

}
