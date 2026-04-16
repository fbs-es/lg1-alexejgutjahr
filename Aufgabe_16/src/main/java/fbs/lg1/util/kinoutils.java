package fbs.lg1.util;

import fbs.lg1.Kinoverwaltung.Kinosaal;

public class kinoutils {

    public void initSaal(char saal[][], int reihen, int sitze) {
        for (int i = 0; i < reihen; i++) {
            for (int j = 0; j < sitze; j++) {
                saal[i][j] = 'F';
                saal[reihen - 1][j] = 'R';
            }
        }
    }

    public int zaehleR(char saal[][], int reihen, int sitze) {
        int sum = 0;
        for (int i = 0; i < reihen; i++) {
            for (int j = 0; j < sitze; j++) {

                if (saal[i][j] == 'R') {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public int zaehleF(char saal[][], int reihen, int sitze) {
        int sum = 0;
        for (int i = 0; i < reihen; i++) {
            for (int j = 0; j < sitze; j++) {

                if (saal[i][j] == 'F') {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public int zaehleV(char saal[][], int reihen, int sitze) {
        int sum = 0;
        for (int i = 0; i < reihen; i++) {
            for (int j = 0; j < sitze; j++) {

                if (saal[i][j] == 'V') {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public void nutzerAuswahl(int auswahl, Kinosaal k1) {
        if (auswahl == 1) {
            k1.kinosaalAusgeben();

        } else if (auswahl == 2) {
            k1.sitzplatzReservieren();

        } else if (auswahl == 3) {
            k1.ausgebenStatistik();
        }

        else if (auswahl == 4) {
            beendeProgramm(auswahl);
        }
    }

    public int beendeProgramm(int auswahl) {
        if (auswahl == 4) {
            return 1;
        } else {
            return 0;
        }
    }
}
