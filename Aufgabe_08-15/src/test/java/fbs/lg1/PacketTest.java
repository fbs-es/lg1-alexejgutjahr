package fbs.lg1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

import fbs.lg1.Packetstation.Packet;
import fbs.lg1.util.packetutils;

public class PacketTest {

    Packet p1 = new Packet();
    packetutils u1 = new packetutils();

    @Test
    void T1_Schadstoffe() {
        assertEquals("ABBRUCH", u1.packetCombined(true, 34.00, 140, 30, 70, true));
        assertNotEquals("ABBRUCH", u1.packetCombined(false, 22.00, 240, 56, 34, false));
    }

    @Test
    void T2_Speergut() {
        assertEquals("SPEERGUT", u1.packetCombined(false, 35.00, 25, 75, 12, true));
        assertNotEquals("SPEERGUT", u1.packetCombined(true, 32.00, 45, 98, 20, true));
    }

    @Test
    void T3_Angenommen_Vermerk() {
        assertEquals("ANGENOMMEN & VERMERK *VORSICHT*", u1.packetCombined(false, 24.00, 240, 125, 65, true));
        assertNotEquals("ANGENOMMEN & VERMERK *VORSICHT*", u1.packetCombined(false, 70, 200, 100, 45, false));
    }

    @Test
    void T4_Angenommen() {
        assertEquals("ANGENOMMEN", u1.packetCombined(false, 24.00, 195, 56, 20, false));
        assertNotEquals("ANGENOMMEN", u1.packetCombined(true, 2, 120, 70, 67, true));
    }

    @Test
    void T5_SpeergutV2() {
        assertEquals("SPEERGUT", u1.packetCombined(false, 17, 300, 80, 20, true));
        assertNotEquals("SPEERGUT", u1.packetCombined(true, 45, 45, 110, 75, true));
    }

    @Test
    void T1_Preis15() {
        assertEquals(15, u1.price(320));
        assertNotEquals(15, u1.price(50));
    }

    @Test
    void T2_Preis10() {
        assertEquals(10, u1.price(110));
        assertNotEquals(10, u1.price(20));
    }

    @Test
    void T3_Preis05() {
        assertEquals(5, u1.price(40));
        assertNotEquals(10, u1.price(200));
    }

    @Test
    void T1_Zuschlag25() {
        assertEquals(25, u1.extraCharge(true, true));
        assertNotEquals(25, u1.extraCharge(false, true));
    }

    @Test
    void T2_Zuschlag10() {
        assertEquals(10, u1.extraCharge(true, false));
        assertNotEquals(10, u1.extraCharge(false, false));
    }

    @Test
    void T3_Zuschlag10() {
        assertEquals(10, u1.extraCharge(false, true));
        assertNotEquals(10, u1.extraCharge(true, true));
    }

    @Test
    void T4_Zuschlag0() {
        assertEquals(0, u1.extraCharge(false, false));
        assertNotEquals(0, u1.extraCharge(false, true));
    }

    @Test
    void T1_Mengenrabatt0() {
        assertEquals(0, u1.berechneMengenrabatt(1));
        assertNotEquals(0, u1.berechneMengenrabatt(20));
    }

    @Test
    void T2_Mengenrabatt11() {
        assertEquals(1.5, u1.berechneMengenrabatt(12));
        assertNotEquals(1.5, u1.berechneMengenrabatt(35));
    }

    @Test
    void T3_Mengenrabatt51() {
        assertEquals(12.75, u1.berechneMengenrabatt(51));
        assertNotEquals(12.75, u1.berechneMengenrabatt(75));
    }

    @Test
    void T34Mengenrabatt101() {
        assertEquals(50.5, u1.berechneMengenrabatt(101));
        assertNotEquals(50.5, u1.berechneMengenrabatt(140));
    }

}