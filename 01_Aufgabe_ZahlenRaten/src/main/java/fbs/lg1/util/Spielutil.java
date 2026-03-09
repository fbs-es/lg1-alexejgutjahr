package fbs.lg1.util;

import java.util.Random;
import java.util.Scanner;

import fbs.lg1._01_Spielvariante.Mensch_Spiel;
import fbs.lg1._02_Spielvariante.KI_Spiel;

public class Spielutil {

    @Deprecated
    public int randomZahlDeprecated() {
        Random rnd = new Random();
        int z = rnd.nextInt(0, 100);
        return z;
    }

    public int randomZahl(int lower, int upper) {
        Random rnd = new Random();
        int z = rnd.nextInt((upper - lower) + 1) + lower;
        return z;
    }

    public int ColdWarmGame(int distance) {
        if (distance <= 4) {
            return 1;
        }

        else {
            return 0;
        }
    }

    public int decisionGame(int r, int input) {
        if (r == input) {
            return 0;
        }

        else if (input > r) {
            return 1;
        }

        else {
            return -1;
        }
    }

    public int inIntervallsspanne(int lower, int upper) {
        if (lower >= 0 && upper >= 0) {
            return 1;
        }

        else if (lower < 0 && upper > 0) {
            return 0;
        }

        else {
            return -1;
        }
    }

    public int inZielbereich(int finalnumber, int lower, int upper) {
        if (finalnumber >= lower && finalnumber <= upper) {
            return 1;
        } else {
            return 0;
        }
    }

    public int inEntscheidung(int decision) {
        if (decision == 1) {
            return 2;
        }

        else if (decision == 2) {
            return 1;
        }

        else if (decision == 3) {
            return 0;
        }

        else {
            return -1;
        }
    }

    public static void spielAbfrage() {
        Scanner sc = new Scanner(System.in);

        Mensch_Spiel ms1 = new Mensch_Spiel();
        KI_Spiel ks1 = new KI_Spiel();

        System.out.println("1. 👤 VS 🤖");
        System.out.println("2. 🤖 VS 👤");

        int descision = sc.nextInt();

        if (descision == 1) {
            ms1.spielStarten();
        }

        else {
            ks1.spielStarten();
        }
    }
}
