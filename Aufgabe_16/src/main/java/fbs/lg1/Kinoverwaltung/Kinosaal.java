package fbs.lg1.Kinoverwaltung;

import java.util.Scanner;
import fbs.lg1.util.kinoutils;

public class Kinosaal {

    kinoutils u1 = new kinoutils();
    Scanner sc = new Scanner(System.in);
    public int reihen, sitze, msitze;
    public int frei, reserviert, vorgemerkt;
    public char[][] saal;
    int auswahl;

    int reiheTemp = -1;
    int sitzTemp = -1;
    boolean tempsuccess = false;

    public Kinosaal(int reihen, int sitze) {
        this.reihen = reihen;
        this.sitze = sitze;
        this.saal = new char[reihen][sitze];

        u1.initSaal(saal, reihen, sitze);
    }

    public void BenutzerOberfläche() {
        while (true) {
            System.out.println("\n============================");
            System.out.println("     TICKETS BESTELLEN      ");
            System.out.println("============================");
            System.out.println("1. Sitzplätze einsehen");
            System.out.println("2. Sitzplätze reservieren");
            System.out.println("3. Plätzestatistik");
            System.out.println("4. Beenden");
            System.out.print("\nAuswählen: ");

            auswahl = sc.nextInt();
            u1.nutzerAuswahl(auswahl, this);

            if (auswahl == 4) {
                break;
            }
        }

    }

    public void kinosaalAusgeben() {
        System.out.println("===== KINOSAAL =====");
        for (int i = 0; i < reihen; i++) {
            for (int j = 0; j < sitze; j++) {

                if (tempsuccess && i == reiheTemp && j == sitzTemp) {
                    if (msitze > 0) {
                        for (int k = 0; k < msitze; k++) {
                            System.out.print("V ");
                            j++;
                        }
                        j--;
                    } else {
                        System.out.print("X ");
                    }
                }

                else {
                    System.out.print(saal[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("F = frei, R = Reserviert, V = Vorgemerkt, X = Auswahl");
    }

    public void sitzplatzReservieren() {
        kinosaalAusgeben();

        System.out.println("\nReihe wählen:");
        reiheTemp = sc.nextInt() - 1;

        System.out.println("Sitz wählen:");
        sitzTemp = sc.nextInt() - 1;

        System.out.println("Wollen Sie mehrere Plätze reservieren (true/false)");
        boolean auswahl = sc.nextBoolean();

        if (auswahl) {
            sucheFreiePlätze(reiheTemp, sitzTemp);
        }

        else {
            if ((reiheTemp >= 0) && (reiheTemp < reihen) && (sitzTemp >= 0) && (sitzTemp < sitze)) {
                tempsuccess = true;
                kinosaalAusgeben();
                tempsuccess = false;

                System.out.println("Reservieren? (y/n)");
                sc.nextLine();
                String entscheidung = sc.nextLine();

                if (entscheidung.equalsIgnoreCase("y")) {
                    if (!(saal[reiheTemp][sitzTemp] == 'R') && !(saal[reiheTemp][sitzTemp] == 'V')) {
                        System.out.println("Erfolgreich reserviert!");
                        saal[reiheTemp][sitzTemp] = 'R';
                    } else {
                        System.out.println("Dieser Platz wurde schon reserviert!");
                    }
                }
            } else {
                System.out.println("Ungültige Sitznummer!");
            }
        }
    }

    public void ausgebenStatistik() {
        frei = u1.zaehleF(saal, reihen, sitze);
        reserviert = u1.zaehleR(saal, reihen, sitze);
        vorgemerkt = u1.zaehleV(saal, reihen, sitze);

        System.out.println("\n============================");
        System.out.println("         STATISTIK          ");
        System.out.println("============================");
        System.out.println("Freie Plätze: " + frei);
        System.out.println("Reservierte Plätze: " + reserviert);
        System.out.println("Vorgemerkte Plätze: " + vorgemerkt);
    }

    public void sucheFreiePlätze(int reiheTemp, int sitzTemp) {
        System.out.println("Wieviele Sitze? (max 2-3)");
        msitze = sc.nextInt();

        boolean alleFrei = true;
        for (int k = 0; k < msitze; k++) {
            int prüfSitz = sitzTemp + k;
            if (prüfSitz >= sitze || saal[reiheTemp][prüfSitz] == 'R' || saal[reiheTemp][prüfSitz] == 'V') {
                alleFrei = false;
                break;
            }
        }

        if (alleFrei == false) {
            System.out.println("Nicht alle Plätze frei! Bitte andere Sitze wählen.");
            return;
        }

        tempsuccess = true;
        kinosaalAusgeben();
        tempsuccess = false;

        System.out.println("Reservieren? (y/n)");
        sc.nextLine();
        String entscheidung = sc.nextLine();

        if (entscheidung.equalsIgnoreCase("y")) {
            for (int k = 0; k < msitze; k++) {
                saal[reiheTemp][sitzTemp + k] = 'R';
            }
            System.out.println("Erfolgreich reserviert!");
        }
    }
}