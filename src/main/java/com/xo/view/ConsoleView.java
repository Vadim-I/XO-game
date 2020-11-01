package com.xo.view;

import com.xo.controllers.CurrentMoveController;
import com.xo.controllers.MoveController;
import com.xo.controllers.WinnerController;
import com.xo.model.Field;
import com.xo.model.Figure;
import com.xo.model.Game;
import com.xo.model.exceptions.AlreadyOccupiedException;
import com.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();

    public void show(Game game) {
        Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            if (x != 0)
                printSeparator();
            printLine(field, x);
        }
    }

    public boolean move(Game game) {
        Field field = game.getField();
        Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("\nWinner is: %s\n", winner);
            return false;
        }
        Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println("No winner and no moves left!");
            return false;
        }
        System.out.format("It's move point for: %s\n", currentFigure);
        Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Point is invalid!");
        }
        return true;
    }

    private Point askPoint() {

        System.out.format("Please input coordinates X and Y (through a space): ");
        Scanner in = new Scanner(System.in);
        int[] coordinates = new int[2];
        try {
            coordinates[0] = in.nextInt();
            coordinates[1] = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Coordinates are incorrect");
        }
        return new Point(coordinates[0] - 1, coordinates[1] - 1);
    }

    private void printLine(Field field, int x) {
        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0)
                System.out.print("|");
            System.out.print(" ");
            Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("~~~~~~~~~~~");
    }
}

