package UAP2_2026;

public class Mobil extends Kendaraan {
    private int jumlahKursi;

    public Mobil(String kode, String nama, double harga, int jumlahKursi) {
        super(kode, nama, harga);
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi() { return jumlahKursi; }
    public void setJumlahKursi(int jumlah) { this.jumlahKursi = jumlah; }

    @Override
    public void tampilInfo() {
        String status = isTersedia() ? "[ TERSEDIA ]" : "[ DISEWA   ]";
        System.out.printf("%-8s  %-6s  %-22s  Kursi : %-4d  Rp %,9.0f/hari  %s%n",
                "[MOBIL]",
                getKodeKendaraan(),
                getNamaKendaraan(),
                jumlahKursi,
                getHargaSewaPerHari(),
                status);
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {
        double total = lamaSewa * getHargaSewaPerHari();
        if (jumlahKursi > 5) total += 50_000;
        return total;
    }
}