package pl.monopoly.view;

import pl.monopoly.logic.BuyAbleField;
import pl.monopoly.logic.Player;

import javax.swing.*;


// must ask player is he want to buy a new field and send back answer
// sluzy do tego zeby komponenty logiczne mogly wysylac sygnal widoczny graficznie i otrzymywac odpowiedz
public class BoardView {

    // methods
    public int askForBuyDialog(BuyAbleField buyAbleField) {

        return JOptionPane.showConfirmDialog(null, "Do you want to buy this field for " + buyAbleField.getPrice() + "?" , "BUY FIELD", JOptionPane.YES_NO_OPTION);
    }

    public void payRentInformation(BuyAbleField buyAbleField) {

        JOptionPane.showMessageDialog(null, "This field is already owned!\nYou have to pay a rent of " + buyAbleField.getFullTax() + "$ to the owner", "OTHER PLAYER'S FIELD", JOptionPane.INFORMATION_MESSAGE);
    }

    public void giveFreeBoundsInformation() {

        JOptionPane.showMessageDialog(null, "You earned extra 200$ bounds!", "INCOME", JOptionPane.INFORMATION_MESSAGE);
    }

    public void giveFreeDrawInformation() {

        JOptionPane.showMessageDialog(null, "You have one more roll!\nRoll again", "BONUS ROLL", JOptionPane.INFORMATION_MESSAGE);
    }

    public int goToJailInformation() {

        return JOptionPane.showConfirmDialog(null, "Oh, you are going to the jail.\nDo you want to pay 400$ fine? If you won't, you will lose the next roll", "ARREST", JOptionPane.YES_NO_OPTION);
    }

    public void loseInformation(String nickname) {

        JOptionPane.showMessageDialog(null, "Player " + nickname + " has lost the game", "Lose", JOptionPane.INFORMATION_MESSAGE);
    }

    public int buildHouseDialog(BuyAbleField buyAbleField) {

        return JOptionPane.showConfirmDialog(null, "You already owned this field.\nDo you want to build a house for 350$?", "CONSTRUCTION CREW", JOptionPane.YES_NO_OPTION);
    }

    public void getLoseInformation(Player player) {
        JOptionPane.showMessageDialog(null, "Player " + player.getColor() + " lost the game.", "YOU LOST", JOptionPane.INFORMATION_MESSAGE);
    }

}
