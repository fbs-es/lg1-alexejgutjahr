package fbs.lg1.Ratespiel;

import java.util.Random;
import java.util.Scanner;

public class ZahlenRaten {

    public void zahlenRateSpiel() {

        Scanner sc = new Scanner(System.in);

        int input = 0;
        int versuche = 0;
        int r = randomZahl();

        System.out.println("=======RATESPIEL=======");
        System.out.println("❤-lich Willkommen!");

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
    }

    public int randomZahl() {
        Random rnd = new Random();
        int z = rnd.nextInt(0, 100);

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