package fbs.lg1.Ratespiel;

import java.util.Random;
import java.util.Scanner;

import fbs.lg1.util.Spielutil;

public class Mensch_Spiel {

    Spielutil util = new Spielutil();

    public void spielStarten() {

        Scanner sc = new Scanner(System.in);
        int input = 0;
        int versuche = 0;
        int decision = 0;

        int lower = 0;
        int upper = 0;

        System.out.println("----------------------------");
        System.out.println(" MENSCH vs. KI: ZAHLENRATEN ");
        System.out.println("----------------------------");

        System.out.println("Intervallsspanne festlegen: ");

        lower = sc.nextInt();
        upper = sc.nextInt();

        while (util.inIntervallsspanne(lower, upper) == -1 || util.inIntervallsspanne(lower, upper) == 0) {
            System.out.println("\n🔢  NUR POSITIVE ZAHLEN 🔢");
            System.out.println("Intervallsspanne festlegen: ");

            lower = sc.nextInt();
            upper = sc.nextInt();
        }

        if (upper < lower) {
            int temp = lower;
            lower = upper;
            upper = temp;
        }

        int rndnumber = util.randomZahl(lower, upper);

        System.out.println("\nIntervallsspanne: " + lower + "-" + upper);

        System.out.println("\n----------------------------");
        System.out.println("       SPIEL BEGONNEN       ");
        System.out.println("----------------------------");

        while (true) {

            System.out.println("Zahl eingeben: ");
            input = sc.nextInt();

            while (!(util.inZielbereich(input, lower, upper) == 1)) {
                System.out.println("\n⚠️  NICHT IM GÜLTIGEN BEREICH ⚠️");
                System.out.println("Geben Sie Zahl erneut ein:");
                input = sc.nextInt();
            }

            int distanz = Math.abs(rndnumber - input);
            versuche++;

            if (util.decisionGame(rndnumber, input) == 0) {
                System.out.println("\n🎉  MENSCH HAT DIE ZAHL ERRRATEN! 🎉");
                System.out.println("🔄: " + versuche);
                break;
            }

            else if (util.decisionGame(rndnumber, input) == 1) {
                System.out.println("Zahl kleiner!");
            }

            else {
                System.out.println("Zahl größer!");
            }

            if (util.ColdWarmGame(distanz) == 1) {
                System.out.println("🔥  Warm");
            }

            else {
                System.out.println("❄️  Kalt");
            }
        }
    }
}