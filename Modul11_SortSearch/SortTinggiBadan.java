package Modul11_SortSearch;

import java.util.ArrayList;
import java.util.Collections;

public class SortTinggiBadan {
    public static void main(String[] args) {
        ArrayList<Integer> timA = new ArrayList<>();
        Collections.addAll(timA, 168, 170, 165, 168, 172, 170, 169, 165, 171, 166);

        ArrayList<Integer> timB = new ArrayList<>();
        Collections.addAll(timB, 170, 167, 165, 166, 168, 175, 172, 171, 168, 169);

        Collections.sort(timA);
        Collections.sort(timB);

        System.out.println("=== TINGGI BADAN SECARA ASCENDING ===");
        System.out.println("Tim A:");
        for (int i = 0; i < timA.size(); i++) {
            System.out.println("  Pemain " + (i + 1) + " : " + timA.get(i) + " cm");
        }
        System.out.println("Tim B:");
        for (int i = 0; i < timB.size(); i++) {
            System.out.println("  Pemain " + (i + 1) + " : " + timB.get(i) + " cm");
        }

        Collections.sort(timA, Collections.reverseOrder());
        Collections.sort(timB, Collections.reverseOrder());

        System.out.println("\n=== TINGGI BADAN SECARA DESCENDING ===");
        System.out.println("Tim A:");
        for (int i = 0; i < timA.size(); i++) {
            System.out.println("  Pemain " + (i + 1) + " : " + timA.get(i) + " cm");
        }
        System.out.println("Tim B:");
        for (int i = 0; i < timB.size(); i++) {
            System.out.println("  Pemain " + (i + 1) + " : " + timB.get(i) + " cm");
        }
    }
}