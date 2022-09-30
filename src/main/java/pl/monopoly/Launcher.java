package pl.monopoly;

import pl.monopoly.view.*;

import java.util.Arrays;

public class Launcher {

    public static void main(String[] args) {

        ViewFactory viewFactory = new ViewFactory();
        viewFactory.createMenu();

    }

}
