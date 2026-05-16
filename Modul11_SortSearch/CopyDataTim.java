package Modul11_SortSearch;

import java.util.ArrayList;
import java.util.Collections;

public class CopyDataTim {
    public static void main(String[] args) {
        ArrayList<Integer> tinggiBadanB = new ArrayList<>();
        Collections.addAll(tinggiBadanB, 170, 167, 165, 166, 168, 175, 172, 171, 168, 169);

        ArrayList<Integer> beratBadanB = new ArrayList<>();
        Collections.addAll(beratBadanB, 66, 60, 59, 58, 58, 71, 68, 68, 65, 60);

        ArrayList<Integer> tinggiBadanC = new ArrayList<>(Collections.nCopies(tinggiBadanB.size(), 0));
        ArrayList<Integer> beratBadanC  = new ArrayList<>(Collections.nCopies(beratBadanB.size(), 0));

        Collections.copy(tinggiBadanC, tinggiBadanB);
        Collections.copy(beratBadanC, beratBadanB);

        System.out.println("=== DATA TIM B ===");
        for (int i = 0; i < tinggiBadanB.size(); i++) {
            System.out.println("Pemain " + (i + 1) + " : " + tinggiBadanB.get(i) + " cm, " + beratBadanB.get(i) + " kg");
        }

        System.out.println("\n=== DATA TIM C (salinan Tim B) ===");
        for (int i = 0; i < tinggiBadanC.size(); i++) {
            System.out.println("Pemain " + (i + 1) + " : " + tinggiBadanC.get(i) + " cm, " + beratBadanC.get(i) + " kg");
        }
    }
}