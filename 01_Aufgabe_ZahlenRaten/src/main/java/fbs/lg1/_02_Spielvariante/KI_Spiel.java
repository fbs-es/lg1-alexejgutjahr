package fbs.lg1._02_Spielvariante;

import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

import fbs.lg1.util.Spielutil;

public class KI_Spiel {

    Spielutil util = new Spielutil();
    Scanner sc = new Scanner(System.in);

    public void spielStarten() {

        int rndnumber;

        int lower = 0;
        int upper = 0;
        int versuche = 0;

        System.out.println("----------------------------");
        System.out.println(" KI vs. MENSCH: ZAHLENRATEN ");
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

        System.out.println("\nIntervallsspanne: " + lower + "-" + upper);
        System.out.println("\nWelche Zahl soll die KI erraten?");

        int finalnumber = sc.nextInt();

        while (!(util.inZielbereich(finalnumber, lower, upper) == 1)) {
            System.out.println("\n⚠️  NICHT IM GÜLTIGEN BEREICH ⚠️");
            System.out.println("Geben Sie eine Zahl erneut ein: ");
            finalnumber = sc.nextInt();
        }

        System.out.println("\n----------------------------");
        System.out.println("       SPIEL BEGONNEN       ");
        System.out.println("----------------------------");

        while (true) {
            rndnumber = util.randomZahl(lower, upper);
            versuche++;

            System.out.println("🤖 Zahl: " + rndnumber + " 👤 Zahl: " + finalnumber);
            System.out.println("(1) Richtig | (2) Kleiner | (3) Größer");
            int decision = sc.nextInt();

            while (util.inEntscheidung(decision) == -1) {
                System.out.println("⚠️  NICHT IM GÜLTIGEN BEREICH ⚠️");
                System.out.println("🤖 Zahl: " + rndnumber + " 👤 Zahl: " + finalnumber);
                System.out.println("(1) Richtig | (2) Kleiner | (3) Größer");
                decision = sc.nextInt();
            }

            if (util.inEntscheidung(decision) == 2) {
                System.out.println("\n🎉  AI HAT DIE ZAHL ERRRATEN! 🎉");
                System.out.println("🔄: " + versuche);
                break;
            }

            else if (util.inEntscheidung(decision) == 1) {
                upper = upper - (upper - rndnumber + 1);
            }

            else if (util.inEntscheidung(decision) == 0) {
                lower = lower + Math.abs(lower - rndnumber - 1);
            }
            System.out.println("Spanne liegt bei:" + lower + "-" + upper);
        }
    }
}
