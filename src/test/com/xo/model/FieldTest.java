package com.xo.model;

import com.xo.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {

    @Test
    public void testGetSize() {
        Field field = new Field(3);
        assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        Field field = new Field(3);
        Point inputPoint = new Point(0, 0);
        Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        Field field = new Field(3);
        Point inputPoint = new Point(0, 0);

        Figure actualFigure = field.getFigure(inputPoint);
        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThenZero() {
        Field field = new Field(3);
        Point inputPoint = new Point(-1, 0);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsLessThenZero() {
        Field field = new Field(3);
        Point inputPoint = new Point(0, -1);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() {
        Field field = new Field(3);
        Point inputPoint = new Point(field.getSize() + 1, 0);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() {
        Field field = new Field(3);
        Point inputPoint = new Point(0, field.getSize() + 1);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

}