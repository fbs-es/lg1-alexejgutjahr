package fbs.lg1.util;

import fbs.lg1.Packetstation.Packet.Groesse;

public class packetutils {
    public int isDanger(boolean danger) {
        if (danger == true) {
            return 1;
        } else {
            return 0;
        }
    }

    public int measureWeight(double weight) {
        if (weight > 31.5) {
            return 1;
        } else {
            return 0;
        }
    }

    public int inRangeMass(int length, int height, int width, boolean fragile) {
        if ((length < 250 && height < 140 && width < 70) && (isFragile(fragile) == 1)) {
            return 0;
        }

        else if (length < 250 && height < 140 && width < 70) {
            return 1;
        }

        else {
            return -1;
        }
    }

    public int isFragile(boolean fragile) {
        if (fragile == true) {
            return 1;
        } else {
            return 0;
        }
    }

    public String maxSize(int sum) {
        if (sum <= Groesse.S.getMaxsize()) {
            return "S";
        }

        else if (sum <= Groesse.M.getMaxsize()) {
            return "M";
        }

        else {
            return "L";
        }
    }

    public int price(int sum) {
        if (maxSize(sum) == "L") {
            return 15;
        }

        else if (maxSize(sum) == "M") {
            return 10;
        }

        else {
            return 5;
        }
    }

    public int extraCharge(boolean abroad, boolean express) {
        if (abroad == true && express == true) {
            return 25;
        }

        else if (abroad == true || express == true) {
            return 10;
        }

        else {
            return 0;
        }
    }

    public double berechneMengenrabatt(int pakete) {
        double gebuehrProPaket = 2.50;
        double summeGebuehren = pakete * gebuehrProPaket;
        double rabattSatz = 0.0;

        if (pakete >= 101) {
            rabattSatz = 0.20;
        } else if (pakete >= 51) {
            rabattSatz = 0.10;
        } else if (pakete >= 11) {
            rabattSatz = 0.05;
        }

        return summeGebuehren * rabattSatz;
    }

    public String packetCombined(boolean danger, double weight, int length, int height, int width, boolean fragile) {
        if (isDanger(danger) == 1) {
            return "ABBRUCH";
        } else if (measureWeight(weight) == 1) {
            return "SPEERGUT";
        } else if (inRangeMass(length, height, width, fragile) == 0) {
            return "ANGENOMMEN & VERMERK *VORSICHT*";
        } else if (inRangeMass(length, height, width, fragile) == 1) {
            return "ANGENOMMEN";
        } else {
            return "SPEERGUT";
        }
    }
}
