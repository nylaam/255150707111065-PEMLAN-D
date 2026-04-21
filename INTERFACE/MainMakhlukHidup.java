package INTERFACE;

import java.util.Scanner;

public class MainMakhlukHidup {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();

        System.out.print("Masukkan umur: ");
        int umur = input.nextInt();

        Manusia manusia = new Manusia(nama, umur);

        System.out.println("\n=== Data Manusia ===");
        manusia.tampilkanNama();
        manusia.tampilkanUmur();
        manusia.makan();
        manusia.berjalan();
        manusia.bersuara();

        Manusia manusia2 = new Manusia(); 
        manusia2.setNama("Nadhine Jubille");
        manusia2.setUmur(20);

        System.out.println("\n=== Data Manusia 2 ===");
        manusia2.tampilkanNama();
        manusia2.tampilkanUmur();
        manusia2.makan();

        System.out.println("\n=== Data Hewan ===");
        Hewan hewan = new Hewan();
        hewan.makan();
        hewan.berjalan();
        hewan.bersuara();

    }
}