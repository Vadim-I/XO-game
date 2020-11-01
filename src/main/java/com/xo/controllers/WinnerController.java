package com.xo.controllers;

import com.xo.model.Field;
import com.xo.model.Figure;
import com.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(Field field) {
        try {

            for (int i = 0; i < 3; i++) {
                if (field.getFigure(new Point(0,i)) == field.getFigure(new Point(1,i))
                        && field.getFigure(new Point(0,i)) == field.getFigure(new Point(2,i))
                        && field.getFigure(new Point(0,i)) != null)
                    return field.getFigure(new Point(0,i));
            }

            for (int i = 0; i < 3; i++) {
                if (field.getFigure(new Point(i,0)) == field.getFigure(new Point(i,1))
                        && field.getFigure(new Point(i,0)) == field.getFigure(new Point(i,2))
                        && field.getFigure(new Point(i,0)) != null)
                    return field.getFigure(new Point(i, 0));
            }

            if (field.getFigure(new Point(0,0)) == field.getFigure(new Point(1,1))
                    && field.getFigure(new Point(0,0)) == field.getFigure(new Point(2,2))
                    && field.getFigure(new Point(0,0)) != null)
                return field.getFigure(new Point(0, 0));

            if (field.getFigure(new Point(0,2)) == field.getFigure(new Point(1,1))
                    && field.getFigure(new Point(0,2)) == field.getFigure(new Point(2,0))
                    && field.getFigure(new Point(0,2)) != null)
                return field.getFigure(new Point(0, 2));

        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }
}
