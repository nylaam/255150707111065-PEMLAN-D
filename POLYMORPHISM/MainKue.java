public class MainKue {
    public static void main(String[] args) {

        Kue[] daftarKue = new Kue[20];

        daftarKue[0]  = new KuePesanan("Kue Lapis",        5000, 500);
        daftarKue[1]  = new KuePesanan("Bolu Kukus",        4000, 300);
        daftarKue[2]  = new KuePesanan("Kue Marmer",        6000, 400);
        daftarKue[3]  = new KuePesanan("Kue Nastar",        8000, 250);
        daftarKue[4]  = new KuePesanan("Kue Putri Salju",   7500, 200);
        daftarKue[5]  = new KuePesanan("Kue Brownies",      9000, 350);
        daftarKue[6]  = new KuePesanan("Kue Pelangi",       5500, 600);
        daftarKue[7]  = new KuePesanan("Kue Pisang",        3500, 450);
        daftarKue[8]  = new KuePesanan("Kue Klepon",        4500, 300);
        daftarKue[9]  = new KuePesanan("Kue Dadar Gulung",  3000, 200);

        daftarKue[10] = new KueJadi("Donat Coklat",     8000,  5.0);
        daftarKue[11] = new KueJadi("Croissant",        12000,  3.0);
        daftarKue[12] = new KueJadi("Muffin Blueberry", 10000,  4.0);
        daftarKue[13] = new KueJadi("Eclair",            9000,  6.0);
        daftarKue[14] = new KueJadi("Cupcake Vanila",    7000,  8.0);
        daftarKue[15] = new KueJadi("Kue Sus",           5000, 10.0);
        daftarKue[16] = new KueJadi("Kue Lidah Kucing",  6000,  7.0);
        daftarKue[17] = new KueJadi("Kue Semprong",      4000, 12.0);
        daftarKue[18] = new KueJadi("Kue Pukis",         3500,  9.0);
        daftarKue[19] = new KueJadi("Kue Lumpur",        4500,  6.0);

        // 3a. Daftar Kue Jenis Pesanan
        System.out.println("=== Daftar Kue Pesanan ===");
        System.out.println("No  Nama Kue           Harga/gram  Berat    Harga Akhir");
        System.out.println("--  -----------------  ----------  -------  -----------");
        int no = 1;
        for (Kue k : daftarKue) {
            if (k instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) k;
                System.out.printf("%-3d %-17s  Rp%-8s  %-7s  Rp%s%n",
                    no++,
                    kp.getNama(),
                    String.format("%,.0f", kp.harga),
                    (int) kp.getBerat() + " gr",
                    String.format("%,.0f", kp.hitungHarga()));
            }
        }

        // 3a. Daftar Kue JenisJadi
        System.out.println("\n=== Daftar Kue Jadi ===");
        System.out.println("No  Nama Kue           Harga/pcs   Jumlah   Harga Akhir");
        System.out.println("--  -----------------  ----------  -------  -----------");
        no = 1;
        for (Kue k : daftarKue) {
            if (k instanceof KueJadi) {
                KueJadi kj = (KueJadi) k;
                System.out.printf("%-3d %-17s  Rp%-8s  %-7s  Rp%s%n",
                    no++,
                    kj.getNama(),
                    String.format("%,.0f", kj.harga),
                    (int)kj.getJumlah() + " pcs",
                    String.format("%,.0f", kj.hitungHarga()));
            }
        }

        // 3b. Total harga semua kue
        double totalHargaSemua = 0;
        for (Kue k : daftarKue) totalHargaSemua += k.hitungHarga();
        System.out.println("\n=== Total Harga Semua Kue ===");
        System.out.println("Total Harga : Rp" + String.format("%,.0f", totalHargaSemua));

        // 3c. Rekap KuePesanan
        double totalHargaPesanan = 0, totalBeratPesanan = 0;
        for (Kue k : daftarKue) {
            if (k instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) k;
                totalHargaPesanan += kp.hitungHarga();
                totalBeratPesanan += kp.getBerat();
            }
        }
        System.out.println("\n=== Rekap Kue Pesanan ===");
        System.out.println("Total Berat : " + (int) totalBeratPesanan + " gram");
        System.out.println("Total Harga : Rp" + String.format("%,.0f", totalHargaPesanan));

        // 3d. Rekap KueJadi
        double totalHargaJadi = 0;
        double totalJumlahJadi = 0;
        for (Kue k : daftarKue) {
            if (k instanceof KueJadi) {
                KueJadi kj = (KueJadi) k;
                totalHargaJadi  += kj.hitungHarga();
                totalJumlahJadi += kj.getJumlah();
            }
        }
        System.out.println("\n=== Rekap Kue Jadi ===");
        System.out.println("Total Jumlah : " + (int)totalJumlahJadi + " pcs");
        System.out.println("Total Harga  : Rp" + String.format("%,.0f", totalHargaJadi));

        // 3e. Kue harga termahal
        Kue kueTermahal = daftarKue[0];
        for (Kue k : daftarKue) {
            if (k.hitungHarga() > kueTermahal.hitungHarga()) kueTermahal = k;
        }
        String jenis = (kueTermahal instanceof KuePesanan) ? "KuePesanan" : "KueJadi";
        System.out.println("\n=== Kue Harga Akhir Termahal ===");
        System.out.println("Jenis       : " + jenis);
        System.out.println("Nama        : " + kueTermahal.getNama());
        System.out.println("Harga Akhir : Rp" + String.format("%,.0f", kueTermahal.hitungHarga()));
    }
}