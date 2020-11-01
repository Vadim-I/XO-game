package com.xo;

import com.xo.model.Field;
import com.xo.model.Figure;
import com.xo.model.Game;
import com.xo.model.Player;
import com.xo.view.ConsoleView;

public class XO {

    public static void main(String[] args) {
        String name1 = "Sergei";
        String name2 = "Vlad";

        Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        Game gameXO = new Game(players, new Field(3));

        ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while(consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }

}
