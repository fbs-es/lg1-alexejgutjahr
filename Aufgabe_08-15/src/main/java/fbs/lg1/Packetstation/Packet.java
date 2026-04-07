package fbs.lg1.Packetstation;

import java.util.Scanner;

import fbs.lg1.util.packetutils;

public class Packet {

    packetutils p1 = new packetutils();

    public enum Groesse {
        S(50, 5),
        M(120, 10),
        L(460, 15);

        private int maxsize;
        private int price;

        Groesse(int maxsize, int price) {
            this.maxsize = maxsize;
            this.price = price;
        }

        public int getMaxsize() {
            return maxsize;
        }

        public int getPrice() {
            return price;
        }
    }

    public void packetstationstarten() {
        boolean danger = false;
        boolean fragile = false;
        double weight = 0;
        int laenge, width, height, pakete;
        int price = 0;
        String size = "";

        Scanner sc = new Scanner(System.in);

        System.out.println();

        System.out.println("Enthält ihr 📦 Schadstoffe? (true/false)");
        danger = sc.nextBoolean();

        if (p1.isDanger(danger) == 1) {
            System.out.println("⚠️  Abbruch!");
        }

        else {
            System.out.println("Wie schwer is Ihr 📦 ? (max. 31,5kg)");
            weight = sc.nextDouble();

            if (p1.measureWeight(weight) == 1) {
                System.out.println(
                        "📦  Sperrgut-Verweis! Bitte geben Sie das 📦 für eine manuelle Bearbeitung am Schalter ab!");
            }

            else {
                System.out.println("📦-länge in cm: (max. 250 cm)");
                laenge = sc.nextInt();

                System.out.println("📦-breite in cm: (max. 140 cm)");
                width = sc.nextInt();

                System.out.println("📦-höhe in cm: (max. 70 cm)");
                height = sc.nextInt();

                System.out.println("Ist Ihr 📦 Zerbrechlich? (true/false)");
                fragile = sc.nextBoolean();

                int sum = laenge + width + height;
                size = p1.maxSize(sum);

                System.out.println("Erfolgt Ihr 📦 Ausland? (true/false)");
                boolean abroad = sc.nextBoolean();

                System.out.println("Soll Ihr 📦 Express geliefert werden? (true/false)");
                boolean express = sc.nextBoolean();

                int rangeResult = p1.inRangeMass(laenge, width, height, fragile);

                price = p1.price(sum) + p1.extraCharge(abroad, express);

                System.out.println("Wie viele Pakete möchten Sie heute versenden?");
                pakete = sc.nextInt();

                if (rangeResult == 0 || rangeResult == 1) {
                    double gesamtBrutto = (double) price * pakete;
                    double rabatt = p1.berechneMengenrabatt(pakete);
                    double endbetrag = gesamtBrutto - rabatt;

                    System.out.println("\n========= ABRECHNUNG =========");
                    System.out.println("Einzelpreis: " + price + " € (inkl. 2,50 € Gebühr)");
                    System.out.println("Gesamt (" + pakete + " Pk.): " + gesamtBrutto + " €");
                    System.out.println("Mengenrabatt: -" + rabatt + " €");
                    System.out.println("Endbetrag: " + endbetrag + " €");
                    System.out.println("==============================");

                    if (rangeResult == 0) {
                        System.out.println("Der Vermerk Zerbrechlich!");
                    }

                    System.out.println("📦 wurde erfolgreich angenommen! ✅");
                }

                else {
                    System.out.println(
                            "📦  Sperrgut-Verweis! Bitte geben Sie das 📦 für eine manuelle Bearbeitung am Schalter ab!");
                }
            }
        }
    }
}
