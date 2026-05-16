package Modul11_SortSearch;

import java.util.ArrayList;
import java.util.Collections;

public class CariTinggiBadan {
    public static void main(String[] args) {
        ArrayList<Integer> tinggiBadanB = new ArrayList<>();
        Collections.addAll(tinggiBadanB, 170, 167, 165, 166, 168, 175, 172, 171, 168, 169);

        System.out.println("TINGGI BADAN TIM B");
        System.out.println("Data Tim B : " + tinggiBadanB);

        ArrayList<Integer> urutkan = new ArrayList<>(tinggiBadanB);
        Collections.sort(urutkan);
        System.out.println("Setelah disort : " + urutkan);
        System.out.println();

        cariJumlah(urutkan, 168);

        cariJumlah(urutkan, 160);
    }

    static void cariJumlah(ArrayList<Integer> urutkan, int cari) {
        int indeks = Collections.binarySearch(urutkan, cari);

        if (indeks < 0) {
            System.out.println("Tinggi Badan " + cari + " cm Tidak ditemukan (jumlah: 0 pemain)");
        } else {
            int jumlah = 1;
            int kiri = indeks - 1;
            while (kiri >= 0 && urutkan.get(kiri) == cari) {
                jumlah++;
                kiri--;
            }
            int kanan = indeks + 1;
            while (kanan < urutkan.size() && urutkan.get(kanan) == cari) {
                jumlah++;
                kanan++;
            }
            System.out.println("Tinggi Badan " + cari + " cm Berhasil Ditemukan! Jumlah: " + jumlah + " pemain");
        }
    }
}
