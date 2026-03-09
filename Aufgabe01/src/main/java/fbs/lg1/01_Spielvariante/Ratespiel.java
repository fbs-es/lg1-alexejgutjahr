package fbs.lg1._01_Spielvariante;

import java.util.Random;
import java.util.Scanner;

public class Ratespiel {

    public void zahlenRateSpiel() {

        Scanner sc = new Scanner(System.in);
        int input = 0;
        int versuche = 0;
        int decision = 0;
        int r = randomZahl(0, 100);

        System.out.println("=======RATESPIEL=======");
        System.out.println("❤-lich Willkommen!");

        while (decision != 1 && decision != 2) {
            System.out.println("1. Mensch VS KI");
            System.out.println("2. KI VS Mensch");
            decision = sc.nextInt();
        }

        if (decision == 1) {
            System.out.println("Geben Sie eine Zahl zwischen 0 und 100 ein, die die KI erraten soll:");
            int zahl = sc.nextInt();

            while (!(zahl >= 0 && zahl <= 100)) {
                System.out.println("Außerhalb der Grenze!\nGeben Sie eine gültige Zahl ein:");
                zahl = sc.nextInt();
            }

            int bot = randomZahl(0, 100);
            System.out.println("Die geratete Zahl ist: " + bot);
            System.out.println("(1)Richtig, (2)Kleiner, (3)Größer?");

            int clue = sc.nextInt();
        }

        else if (decision == 2) {

            while (true) {

                System.out.println("Geben Sie eine Zahl zwischen 0-100 ein: ");
                input = sc.nextInt();

                int distanz = Math.abs(r - input);
                versuche++;

                if (decisionGame(r, input) == 0) {
                    System.out.println("Juhu Sie haben die Zuffalszahl erraten!");
                    System.out.println("Sie haben so viele Versuche benötigt: " + versuche);
                    break;
                }

                else if (decisionGame(r, input) == 1) {
                    System.out.println("Die Zahl ist kleiner als die angebebene Zahl!");
                }

                else {
                    System.out.println("Die Zahl ist größer als die angebebene Zahl!");
                }

                if (ColdWarmGame(distanz) == 1) {
                    System.out.println("Warm");
                }

                else {
                    System.out.println("Kalt");
                }
            }
            sc.close();
        } else {
            System.out.println("Keine gültige Eingabe! Geben Sie nur Zahlen ein. (1,2)");
        }

    }

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
}
