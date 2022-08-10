package pl.monopoly.view;

import pl.monopoly.logic.Street;

import javax.swing.*;


// must ask player is he want to buy a new field and send back answer
// sluzy do tego zeby komponenty logiczne mogly wysylac sygnal widoczny graficznie i otrzymywac odpowiedz
public class BoardView {

    // methods
    public void askForBuyDialog(Street street) {

        int answer = JOptionPane.showConfirmDialog(null, "Do you want to buy this field for " + street.getPrice() + "?" , "BUY FIELD", JOptionPane.YES_NO_OPTION);

        if (answer == JOptionPane.OK_OPTION)
            street.buyField();
    }

    public void payRentInformation() {

        JOptionPane.showMessageDialog(null, "This field is already owned!\nYou have to pay a rent of 300$ to the owner", "OTHER PLAYER'S FIELD", JOptionPane.INFORMATION_MESSAGE);
    }

    public void giveFreeBoundsInformation() {

        JOptionPane.showMessageDialog(null, "You earned extra 200$ bounds!", "INCOME", JOptionPane.INFORMATION_MESSAGE);
    }

    public void giveFreeDrawInformation() {

        JOptionPane.showMessageDialog(null, "You have one more roll!\nRoll again", "BONUS ROLL", JOptionPane.INFORMATION_MESSAGE);
    }

    public void goToJailInformation() {

        JOptionPane.showMessageDialog(null, "Oh, you are going to the jail", "ARREST", JOptionPane.INFORMATION_MESSAGE);
    }

}
