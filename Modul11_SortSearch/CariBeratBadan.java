package Modul11_SortSearch;

import java.util.ArrayList;
import java.util.Collections;

public class CariBeratBadan {
    public static void main(String[] args) {
        ArrayList<Integer> beratBadanA = new ArrayList<>();
        Collections.addAll(beratBadanA, 50, 60, 56, 55, 60, 70, 66, 56, 72, 56);

        System.out.println("BERAT BADAN TIM A");
        System.out.println("Data Tim A : " + beratBadanA);

        ArrayList<Integer> urutkan = new ArrayList<>(beratBadanA);
        Collections.sort(urutkan);
        System.out.println("Setelah disort : " + urutkan);
        System.out.println();

        cariJumlah(urutkan, 56);

        cariJumlah(urutkan, 53);
    }

    static void cariJumlah(ArrayList<Integer> urutkan, int cari) {
        int indeks = Collections.binarySearch(urutkan, cari);

        if (indeks < 0) {
            System.out.println("Berat Badan " + cari + " kg Tidak ditemukan (jumlah: 0 pemain)");
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
            System.out.println("Berat Badan " + cari + " kg Berhasil Ditemukan! Jumlah: " + jumlah + " pemain");
        }
    }
}