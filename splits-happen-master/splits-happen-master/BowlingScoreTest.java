package com.akmisra;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingScoreTest {

    private BowlingScore g;

    void rollMany(int n, int pins, BowlingScore g) {
        for (int i = 0; i < n; i++) g.attempt(pins);
    }

    @Before
    public void setUp() {
        this.g = new BowlingScore();
    }

    @Test
    public void testZero() {
        rollMany(20, 0, g);
        assertEquals(0, g.score());
    }

    @Test
    public void testAllSpare() {
        rollMany(21, 5, g);
        assertEquals(150, g.score());
    }

    @Test
    public void testAllMisses() {
        g.attempt(9);
        g.attempt(9);
        g.attempt(9);
        g.attempt(9);
        g.attempt(9);
        g.attempt(9);
        g.attempt(9);
        g.attempt(9);
        g.attempt(9);
        g.attempt(9);
        rollMany(10, 0, g);
        assertEquals(90, g.score());
    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10, g);
        assertEquals(300, g.score());
    }
}