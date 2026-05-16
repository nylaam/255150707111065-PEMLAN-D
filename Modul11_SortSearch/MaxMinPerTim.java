package Modul11_SortSearch;

import java.util.ArrayList;
import java.util.Collections;

public class MaxMinPerTim {
    public static void main(String[] args) {
        ArrayList<Integer> tinggiBadanA = new ArrayList<>();
        Collections.addAll(tinggiBadanA, 168, 170, 165, 168, 172, 170, 169, 165, 171, 166);

        ArrayList<Integer> beratBadanA = new ArrayList<>();
        Collections.addAll(beratBadanA, 50, 60, 56, 55, 60, 70, 66, 56, 72, 56);

        ArrayList<Integer> tinggiBadanB = new ArrayList<>();
        Collections.addAll(tinggiBadanB, 170, 167, 165, 166, 168, 175, 172, 171, 168, 169);

        ArrayList<Integer> beratBadanB = new ArrayList<>();
        Collections.addAll(beratBadanB, 66, 60, 59, 58, 58, 71, 68, 68, 65, 60);

        int maxTinggiA = Collections.max(tinggiBadanA);
        int minTinggiA = Collections.min(tinggiBadanA);
        int maxBeratA  = Collections.max(beratBadanA);
        int minBeratA  = Collections.min(beratBadanA);

        int maxTinggiB = Collections.max(tinggiBadanB);
        int minTinggiB = Collections.min(tinggiBadanB);
        int maxBeratB  = Collections.max(beratBadanB);
        int minBeratB  = Collections.min(beratBadanB);

        System.out.println("=== HASIL TIM A ===");
        System.out.println("Tinggi Badan MAX : " + maxTinggiA + " cm");
        System.out.println("Tinggi Badan MIN : " + minTinggiA + " cm");
        System.out.println("Berat  Badan MAX : " + maxBeratA  + " kg");
        System.out.println("Berat  Badan MIN : " + minBeratA  + " kg");

        System.out.println("\n=== HASIL TIM B ===");
        System.out.println("Tinggi Badan MAX : " + maxTinggiB + " cm");
        System.out.println("Tinggi Badan MIN : " + minTinggiB + " cm");
        System.out.println("Berat  Badan MAX : " + maxBeratB  + " kg");
        System.out.println("Berat  Badan MIN : " + minBeratB  + " kg");
    }
}