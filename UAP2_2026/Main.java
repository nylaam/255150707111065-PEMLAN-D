package UAP2_2026;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GoDriveRentalSystem system = new GoDriveRentalSystem();

        system.tambahKendaraan(new Mobil("MBL01", "Toyota Avanza", 350000, 7));
        system.tambahKendaraan(new Mobil("MBL02", "Daihatsu Sigra", 300000, 7));
        system.tambahKendaraan(new Mobil("MBL03", "Honda Brio", 280000, 5));
        system.tambahKendaraan(new Motor("MTR01", "Honda Vario", 80000, "Matik"));
        system.tambahKendaraan(new Motor("MTR02", "Yamaha NMAX", 100000, "Matik"));
        system.tambahKendaraan(new Motor("MTR03", "Kawasaki KLX", 90000, "Manual"));

        int pilihan = 0;

        do {
            System.out.println("\n====== MENU GO DRIVE RENTAL SYSTEM ======");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tampilkan Daftar Armada");
            System.out.println("3. Sewa Kendaraan");
            System.out.println("4. Kembalikan Kendaraan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input menu tidak valid, masukkan angka 1-5.");
                continue;
            }

            switch (pilihan) {
                case 1:
                    menuTambahKendaraan(sc, system);
                    break;
                case 2:
                    system.tampilkanDaftarKendaraan();
                    break;
                case 3:
                    menuSewaKendaraan(sc, system);
                    break;
                case 4:
                    menuKembalikanKendaraan(sc, system);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan GoDrive. Sampai jumpa!");
                    break;
                default:
                    System.out.println("[ERROR] Pilihan tidak tersedia. Masukkan angka 1-5.");
            }

        } while (pilihan != 5);

        sc.close();
    }

    static void menuTambahKendaraan(Scanner sc, GoDriveRentalSystem system) {
        System.out.print("Masukkan jenis kendaraan (mobil/motor): ");
        String jenis = sc.nextLine().trim().toLowerCase();

        System.out.print("Masukkan kode kendaraan: ");
        String kode = sc.nextLine().trim().toUpperCase();

        System.out.print("Masukkan nama kendaraan: ");
        String nama = sc.nextLine().trim();

        double harga = 0;
        try {
            System.out.print("Masukkan harga sewa per hari: ");
            harga = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Harga tidak valid!");
            return;
        }

        if (jenis.equals("mobil")) {
            int kursi = 0;
            try {
                System.out.print("Masukkan jumlah kursi: ");
                kursi = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Jumlah kursi tidak valid!");
                return;
            }
            system.tambahKendaraan(new Mobil(kode, nama, harga, kursi));

        } else if (jenis.equals("motor")) {
            System.out.print("Masukkan jenis transmisi (Matik/Manual): ");
            String transmisi = sc.nextLine().trim();
            system.tambahKendaraan(new Motor(kode, nama, harga, transmisi));

        } else {
            System.out.println("[ERROR] Jenis kendaraan tidak dikenali. Gunakan 'mobil' atau 'motor'.");
        }
    }

    static void menuSewaKendaraan(Scanner sc, GoDriveRentalSystem system) {
        System.out.print("Masukkan kode kendaraan yang ingin disewa: ");
        String kode = sc.nextLine().trim().toUpperCase();

        int lama = 0;
        try {
            System.out.print("Masukkan durasi sewa (dalam hari): ");
            lama = Integer.parseInt(sc.nextLine().trim());
            if (lama <= 0) {
                System.out.println("[ERROR] Durasi sewa minimal harus 1 hari!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Durasi tidak valid!");
            return;
        }

        System.out.print("Apakah Anda Member VIP? (y/n): ");
        boolean vip = sc.nextLine().trim().equalsIgnoreCase("y");

        try {
            system.sewaKendaraan(kode, lama, vip);
        } catch (KendaraanTidakTersediaException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    static void menuKembalikanKendaraan(Scanner sc, GoDriveRentalSystem system) {
        System.out.print("Masukkan kode kendaraan yang ingin dikembalikan: ");
        String kode = sc.nextLine().trim().toUpperCase();
        system.kembalikanKendaraan(kode);
    }
}