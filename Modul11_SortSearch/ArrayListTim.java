package Modul11_SortSearch;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTim {
    public static void main(String[] args) {
        ArrayList<Integer> tinggiBadanA = new ArrayList<>();
        Collections.addAll(tinggiBadanA, 168, 170, 165, 168, 172, 170, 169, 165, 171, 166);

        ArrayList<Integer> beratBadanA = new ArrayList<>();
        Collections.addAll(beratBadanA, 50, 60, 56, 55, 60, 70, 66, 56, 72, 56);

        ArrayList<Integer> tinggiBadanB = new ArrayList<>();
        Collections.addAll(tinggiBadanB, 170, 167, 165, 166, 168, 175, 172, 171, 168, 169);

        ArrayList<Integer> beratBadanB = new ArrayList<>();
        Collections.addAll(beratBadanB, 66, 60, 59, 58, 58, 71, 68, 68, 65, 60);

        System.out.println("DATA TIM A");
        System.out.println("Tinggi Badan Pemain: " + tinggiBadanA + " cm");
        System.out.println("Berat Badan Pemain: " + beratBadanA  + " kg");

        System.out.println("\nDATA TIM B");
        System.out.println("Tinggi Badan Pemain: " + tinggiBadanB + " cm");
        System.out.println("Berat Badan Pemain: " + beratBadanB  + " kg");
    }
}