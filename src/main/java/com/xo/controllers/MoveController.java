package com.xo.controllers;

import com.xo.model.Field;
import com.xo.model.Figure;
import com.xo.model.exceptions.AlreadyOccupiedException;
import com.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(Field field,
                            Point point,
                            Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
