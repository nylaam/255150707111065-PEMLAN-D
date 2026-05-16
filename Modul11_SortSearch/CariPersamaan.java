package Modul11_SortSearch;

import java.util.ArrayList;
import java.util.Collections;

public class CariPersamaan {
    public static void main(String[] args) {
        ArrayList<Integer> tinggiBadanA = new ArrayList<>();
        Collections.addAll(tinggiBadanA, 168, 170, 165, 168, 172, 170, 169, 165, 171, 166);

        ArrayList<Integer> beratBadanA = new ArrayList<>();
        Collections.addAll(beratBadanA, 50, 60, 56, 55, 60, 70, 66, 56, 72, 56);

        ArrayList<Integer> tinggiBadanB = new ArrayList<>();
        Collections.addAll(tinggiBadanB, 170, 167, 165, 166, 168, 175, 172, 171, 168, 169);

        ArrayList<Integer> beratBadanB = new ArrayList<>();
        Collections.addAll(beratBadanB, 66, 60, 59, 58, 58, 71, 68, 68, 65, 60);

        System.out.println("CARI PERSAMAAN TIM A DAN TIM B");

        System.out.println("\nTinggi Badan Tim A : " + tinggiBadanA);
        System.out.println("Tinggi Badan Tim B : " + tinggiBadanB);
        cariPersamaan(tinggiBadanA, tinggiBadanB, "Tinggi Badan", "cm");

        System.out.println("\nBerat Badan Tim A  : " + beratBadanA);
        System.out.println("Berat Badan Tim B  : " + beratBadanB);
        cariPersamaan(beratBadanA, beratBadanB, "Berat Badan", "kg");
    }

    static void cariPersamaan(ArrayList<Integer> dataA, ArrayList<Integer> dataB, String kategori, String satuan) {
        ArrayList<Integer> urutanB = new ArrayList<>(dataB);
        Collections.sort(urutanB);

        ArrayList<Integer> nilaiSama = new ArrayList<>();
        for (int nilai : dataA) {
            int indeks = Collections.binarySearch(urutanB, nilai);
            if (indeks >= 0 && !nilaiSama.contains(nilai)) {
                nilaiSama.add(nilai);
            }
        }

        if (nilaiSama.isEmpty()) {
            System.out.println("Hasil " + kategori + " Tidak ditemukan nilai yang sama");
        } else {
            Collections.sort(nilaiSama);
            System.out.println("Hasil " + kategori + " yang sama : " + nilaiSama + " " + satuan);
        }
    }
}