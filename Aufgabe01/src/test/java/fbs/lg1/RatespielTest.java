package fbs.lg1;

import org.junit.jupiter.api.Test;

import fbs.lg1.Ratespiel.ZahlenRaten;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RatespielTest {

    @Test
    void testDecisionGameTrue() {
        ZahlenRaten z1 = new ZahlenRaten();

        assertEquals(0, z1.decisionGame(50, 50));
        assertEquals(1, z1.decisionGame(30, 50));
        assertEquals(-1, z1.decisionGame(80, 30));
    }

    @Test
    void testDecisionGameFalse() {
        ZahlenRaten z1 = new ZahlenRaten();

        assertNotEquals(1, z1.decisionGame(50, 50));
        assertNotEquals(0, z1.decisionGame(30, 50));
        assertNotEquals(1, z1.decisionGame(80, 30));
    }

    @Test
    void testRandomZahlTrue() {
        ZahlenRaten z1 = new ZahlenRaten();

        int ergebnis = z1.randomZahl();
        assertTrue(ergebnis >= 0 && ergebnis < 100);
    }

    @Test
    void testRandomZahlFalse() {
        ZahlenRaten z1 = new ZahlenRaten();

        assertNotEquals(125, z1.randomZahl());
    }

    @Test
    void testColdWarmGameTrue() {
        ZahlenRaten z1 = new ZahlenRaten();

        assertEquals(1, z1.ColdWarmGame(4));
        assertEquals(0, z1.ColdWarmGame(35));
    }

    @Test
    void testColdWarmGameFalse() {
        ZahlenRaten z1 = new ZahlenRaten();

        assertNotEquals(0, z1.ColdWarmGame(4));
        assertNotEquals(1, z1.ColdWarmGame(35));
    }
}