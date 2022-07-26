package pl.monopoly.view;

import pl.monopoly.logic.Street;

import javax.swing.*;

// must ask player is he want to buy a new field and send back answer
// sluzy do tego zeby komponenty logiczne mogly wysylac sygnal widoczny graficznie i otrzymywac odpowiedz
public class BoardView {

    // methods
    public void askForBuy(Street street) {

        int answer = JOptionPane.showConfirmDialog(null, "Do you want to buy this field for " + street.getPrice() + "?" , "Buying field", JOptionPane.YES_NO_OPTION);

        if (answer == JOptionPane.OK_OPTION) {

            street.buyField();

        }

    }

}
