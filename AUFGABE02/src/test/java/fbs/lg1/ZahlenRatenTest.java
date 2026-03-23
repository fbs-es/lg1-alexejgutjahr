package fbs.lg1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ZahlenRatenTest {
    @Test
    void testSagHallo() {
        ZahlenRaten aufgabe = new ZahlenRaten();
        assertThat(aufgabe.sagHallo()).contains("Hallo");
    }
}
