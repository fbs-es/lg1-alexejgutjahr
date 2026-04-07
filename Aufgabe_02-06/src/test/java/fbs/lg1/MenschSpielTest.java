package fbs.lg1;

import org.junit.jupiter.api.Test;
import fbs.lg1.util.Spielutil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MenschSpielTest {

    @Test
    void testDecisionGameTrue() {
        Spielutil u1 = new Spielutil();

        assertEquals(0, u1.decisionGame(50, 50));
        assertEquals(1, u1.decisionGame(30, 50));
        assertEquals(-1, u1.decisionGame(80, 30));
    }

    @Test
    void testDecisionGameFalse() {
        Spielutil u1 = new Spielutil();

        assertNotEquals(1, u1.decisionGame(50, 50));
        assertNotEquals(0, u1.decisionGame(30, 50));
        assertNotEquals(1, u1.decisionGame(80, 30));
    }

    @Test
    void testRandomZahlFalse() {
        Spielutil u1 = new Spielutil();

        assertNotEquals(125, u1.randomZahlDeprecated());
    }

    @Test
    void testColdWarmGameTrue() {
        Spielutil u1 = new Spielutil();

        assertEquals(1, u1.ColdWarmGame(4));
        assertEquals(0, u1.ColdWarmGame(35));
    }

    @Test
    void testColdWarmGameFalse() {
        Spielutil u1 = new Spielutil();

        assertNotEquals(0, u1.ColdWarmGame(4));
        assertNotEquals(1, u1.ColdWarmGame(35));
    }

}