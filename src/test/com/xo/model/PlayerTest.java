package com.xo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testGetName() {
        String inputValue = "Vlad";
        Player player = new Player(inputValue, null);
        String actualValue = player.getName();
        assertEquals(inputValue, actualValue);
    }

    @Test
    public void testGetFigure() {
        Figure inputValue = Figure.X;
        Player player = new Player(null, inputValue);
        Figure actualValue = player.getFigure();
        assertEquals(inputValue, actualValue);
    }
}