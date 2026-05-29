package UAP2_2026;

import java.util.ArrayList;

public class GoDriveRentalSystem {
    private ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
        System.out.println("[INFO] Kendaraan berhasil ditambahkan: " + k.getNamaKendaraan() + " (" + k.getKodeKendaraan() + ")");
    }

    public void tampilkanDaftarKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("[INFO] Belum ada kendaraan terdaftar.");
            return;
        }
        System.out.println("\n=== DAFTAR ARMADA GODRIVE ===");
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarKendaraan.get(i).tampilInfo();
        }
    }

public void sewaKendaraan(String kode, int lamaSewa, boolean isVIP)
            throws KendaraanTidakTersediaException {
 
        Kendaraan target = cariKendaraan(kode);
 
        if (target == null || !target.isTersedia()) {
            throw new KendaraanTidakTersediaException(
                "Kendaraan [" + kode + "] tidak tersedia atau tidak ditemukan."
            );
        }
 
        double biayaDasar  = target.hitungBiayaDasar(lamaSewa);
        double diskonVIP   = isVIP        ? biayaDasar * 0.10 : 0;
        double diskon7Hari = lamaSewa > 7 ? biayaDasar * 0.15 : 0;
        double totalBiaya  = biayaDasar - diskonVIP - diskon7Hari;
 
        target.setTersedia(false);
 
        System.out.println();
        System.out.println("        TRANSAKSI SEWA  GO DRIVE");
        System.out.printf("  %-26s : %s (%s)%n", "Unit", target.getNamaKendaraan(), target.getKodeKendaraan());
        System.out.printf("  %-26s : %d hari%n",  "Lama Sewa", lamaSewa);
        System.out.printf("  %-26s : %s%n",        "Member VIP", isVIP ? "Ya" : "Tidak");
 
        double tarifDasar = lamaSewa * target.getHargaSewaPerHari();
        System.out.printf("  %-26s : Rp %,14.0f%n", "Tarif Dasar", tarifDasar);
 
        if (target instanceof Mobil) {
            Mobil m = (Mobil) target;
            if (m.getJumlahKursi() > 5) {
                System.out.printf("  %-26s : Rp %,14.0f%n", "+ Biaya Perawatan (>5 kursi)", 50_000.0);
            }
        } else if (target instanceof Motor) {
            Motor mo = (Motor) target;
            if (mo.getJenisTransmisi().equalsIgnoreCase("Matik")) {
                System.out.printf("  %-26s : Rp %,14.0f%n", "+ Asuransi Matik", 10_000.0 * lamaSewa);
            }
        }
 
        System.out.printf("  %-26s : Rp %,14.0f%n", "Subtotal", biayaDasar);
 
        if (diskonVIP > 0 || diskon7Hari > 0) {
            if (diskonVIP > 0)
                System.out.printf("  %-26s : Rp %,14.0f%n", "- Diskon Member VIP (10%)", diskonVIP);
            if (diskon7Hari > 0)
                System.out.printf("  %-26s : Rp %,14.0f%n", "- Diskon Sewa >7 Hari (15%)", diskon7Hari);
        }
 
        System.out.printf("  %-26s : Rp %,14.0f%n", "TOTAL BIAYA", totalBiaya);
    }

    public void kembalikanKendaraan(String kode) {
        Kendaraan target = cariKendaraan(kode);

        if (target == null) {
            System.out.println("[ERROR] Kendaraan dengan kode " + kode + " tidak ditemukan!");
            return;
        }
        if (target.isTersedia()) {
            System.out.println("[ERROR] Kendaraan " + target.getNamaKendaraan() + " tidak sedang disewa.");
            return;
        }

        target.setTersedia(true);
        System.out.println("[INFO] Kendaraan " + target.getNamaKendaraan() +
                " (" + kode + ") berhasil dikembalikan. Status: Tersedia.");
    }

    private Kendaraan cariKendaraan(String kode) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }
}