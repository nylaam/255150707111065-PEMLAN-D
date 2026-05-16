package Modul11_SortSearch;

import java.util.ArrayList;
import java.util.Collections;

public class SortBeratBadan {
    public static void main(String[] args) {
        ArrayList<Integer> timA = new ArrayList<>();
        Collections.addAll(timA, 50, 60, 56, 55, 60, 70, 66, 56, 72, 56);

        ArrayList<Integer> timB = new ArrayList<>();
        Collections.addAll(timB, 66, 60, 59, 58, 58, 71, 68, 68, 65, 60);

        Collections.sort(timA);
        Collections.sort(timB);

        System.out.println("=== BERAT BADAN SECARA ASCENDING ===");
        System.out.println("Tim A:");
        for (int i = 0; i < timA.size(); i++) {
            System.out.println("  Pemain " + (i + 1) + " : " + timA.get(i) + " kg");
        }
        System.out.println("Tim B:");
        for (int i = 0; i < timB.size(); i++) {
            System.out.println("  Pemain " + (i + 1) + " : " + timB.get(i) + " kg");
        }

        Collections.sort(timA, Collections.reverseOrder());
        Collections.sort(timB, Collections.reverseOrder());

        System.out.println("\n=== BERAT BADAN SECARA DESCENDING ===");
        System.out.println("Tim A:");
        for (int i = 0; i < timA.size(); i++) {
            System.out.println("  Pemain " + (i + 1) + " : " + timA.get(i) + " kg");
        }
        System.out.println("Tim B:");
        for (int i = 0; i < timB.size(); i++) {
            System.out.println("  Pemain " + (i + 1) + " : " + timB.get(i) + " kg");
        }
    }
}