package fbs.lg1._02_Testklasse;

import org.junit.jupiter.api.Test;

import fbs.lg1.util.Spielutil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RatespielTest {
    Spielutil utils = new Spielutil();

    @Test
    void testRandomZahlFalse() {
        assertNotEquals(125, utils.randomZahl(1, 100));
    }

    @Test
    void testStandardintervall() {

        for (int i = 0; i < 10000; i++) {
            int ergebnis = utils.randomZahl(1, 100);
            assertTrue(ergebnis >= 1 && ergebnis <= 100);
        }
    }

    @Test
    void testVerschobeneIntervall() {

        for (int i = 0; i < 10000; i++) {
            int ergebnis = utils.randomZahl(50, 100);
            assertTrue(ergebnis >= 50 && ergebnis <= 100);
        }
    }

    @Test
    void testIdentischeGrenzen() {

        for (int i = 0; i < 10000; i++) {
            int ergebnis = utils.randomZahl(50, 50);
            assertEquals(50, ergebnis);
        }
    }

    @Test
    void testInIntervallsspanne() {

        assertEquals(1, utils.inIntervallsspanne(64, 256));
        assertEquals(0, utils.inIntervallsspanne(-50, 100));
        assertEquals(-1, utils.inIntervallsspanne(-100, -50));
    }

    @Test
    void testInZielbereich() {
        assertEquals(1, utils.inZielbereich(34, 0, 100));
        assertEquals(0, utils.inZielbereich(125, 50, 100));
    }

    @Test
    void testInEntscheidung() {
        assertEquals(2, utils.inEntscheidung(1));
        assertEquals(1, utils.inEntscheidung(2));
        assertEquals(0, utils.inEntscheidung(3));
        assertEquals(-1, utils.inEntscheidung(25));
    }

    @Test
    void testbinarySearch() {
        assertEquals(50, utils.binarySearch(0, 100));
    }
}