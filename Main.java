package com.nugge;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //deklarera variabler och skapa en input scanner //
        double totaltemp = 0;
        Scanner in = new Scanner(System.in);
        DecimalFormat dec = new DecimalFormat("#.00");
        System.out.println("TeMPeRaTuRAnAlYsAtOrN 9000");
        // frågar efter mängden värden användaren vill mata in och skapar arrayn med så många platser //
        System.out.print("Hur många temperatur värden vill du mata in? ");
        int values = in.nextInt();
        double[] temps = new double[values];
        double[] tempschart = new double[values];
        double[] tempstemp = new double[values];
        //läs in värden i arrayn temps[] //
        for (int i = 0; i < values; i++) {
            System.out.print("Ange temperaturvärde " + (i + 1) + ": ");
            double input = in.nextDouble();
            if (input < -51 || input > 60) {
                System.out.println("It Can not possibly be that hot/cold!");
                i--;
            } else {
                temps[i] = input;
                tempschart[i] = temps[i];
                tempstemp[i] = temps[i];
            }
        }
        // lägg till alla värden i totaltemp //
        for (double temp : temps) {
            totaltemp += temp;
        }
        //sortera arrayn //
        Arrays.sort(temps);
        // skriv ut medeltemperatur
        System.out.println("\nMedeltemperatur: " + dec.format(totaltemp / values));
        // if sats för att se ifall användaren har matat in en jämn eller ojämn mängd tal //
        if (values % 2 == 0) {
            double median = (temps[(values / 2) - 1] + temps[(values / 2)]) / 2;
            System.out.println("Mediantemperatur: " + median);
        } else {
            double median = temps[(values / 2)];
            System.out.println("Mediantemperatur: " + median);
        }
        // skapar skalan för grafen //
        int[] scale = new int[12];
        int max = (int) temps[values - 1];
        int min = (int) temps[0];

        for (int i = 0; i < 12; i++) {
            scale[i] = 60 - (i * 10);
        }
        // räknar ut inmatade värden till +-6 så de kan skrivas ut i grafen //
        for (int i = 0; temps[values - 1] >= 60 || temps[values - 1] <= -50; i++) {
            for (int j = 0; j < temps.length; j++) {
                temps[j] = temps[j] / 2;
                tempschart[j] = tempschart[j] / 2;
            }
        }
        /*for (double temp : temps) {
            System.out.println(Math.round(temp));
        }*/
        //debugging för vad de olika arrays ger ut //
       /* for (int i = 0; i < temps.length; i++) {
            System.out.println(temps[i]);
            System.out.println(scale[i]);
        }*/
        //utprinting av en chart //
        for (int i = 0; i < scale.length; i++) {

            if (i < 6) {
                System.out.print(" " + scale[i]);
            } else if (i == 6) {
                System.out.print("  " + scale[i]);
            } else {
                System.out.print(scale[i]);
            }
            // skriver ut en rad i taget med * då värden överskrids //

            for (int j = 0; j < tempschart.length; j++) {


                if (tempschart[j] >= scale[i]) {
                    System.out.print("  *");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("");
        }
        System.out.print("C/V");
        for (int i = 0; i < temps.length; i++) {
            if (i >= 10) {
                System.out.print(" " + (i + 1));
            } else {
                System.out.print("  " + (i + 1));
            }
        }
    }
}
