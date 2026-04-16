package fbs.lg1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import fbs.lg1.Kinoverwaltung.Kinosaal;
import fbs.lg1.util.kinoutils;

public class KinosaalTestKlasse {

    Kinosaal k1 = new Kinosaal(5, 5);
    kinoutils u1 = new kinoutils();
    public char[][] saal = new char[k1.reihen][k1.sitze];

    @Test
    void T1_zaehleR() {

        saal[0][0] = 'R';
        saal[0][1] = 'R';

        assertEquals(2, u1.zaehleR(saal, k1.reihen, k1.sitze));
        assertNotEquals(1, u1.zaehleR(saal, k1.reihen, k1.sitze));
    }

    @Test
    void T2_zaehleF() {

        saal[2][4] = 'F';
        saal[4][3] = 'F';
        saal[1][0] = 'F';

        assertEquals(3, u1.zaehleF(saal, k1.reihen, k1.sitze));
        assertNotEquals(2, u1.zaehleF(saal, k1.reihen, k1.sitze));
    }

    @Test
    void T3_zaehleV() {

        saal[4][4] = 'V';

        assertEquals(1, u1.zaehleV(saal, k1.reihen, k1.sitze));
        assertNotEquals(0, u1.zaehleV(saal, k1.reihen, k1.sitze));
    }

    @Test
    void T1_beendeProgramm() {

        saal[4][4] = 'V';

        assertEquals(1, u1.beendeProgramm(4));
        assertNotEquals(0, u1.beendeProgramm(4));
    }
}
