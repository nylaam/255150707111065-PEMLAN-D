package UAP2_2026;

public class Motor extends Kendaraan {
    private String jenisTransmisi;

    public Motor(String kode, String nama, double harga, String jenisTransmisi) {
        super(kode, nama, harga);
        this.jenisTransmisi = jenisTransmisi;
    }

    public String getJenisTransmisi() { return jenisTransmisi; }
    public void setJenisTransmisi(String jenis) { this.jenisTransmisi = jenis; }

    @Override
    public void tampilInfo() {
        String status = isTersedia() ? "[ TERSEDIA ]" : "[ DISEWA   ]";
        System.out.printf("%-8s  %-6s  %-22s  %-13s  Rp %,9.0f/hari  %s%n",
                "[MOTOR]",
                getKodeKendaraan(),
                getNamaKendaraan(),
                jenisTransmisi,
                getHargaSewaPerHari(),
                status);
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {
        double total = lamaSewa * getHargaSewaPerHari();
        if (jenisTransmisi.equalsIgnoreCase("Matik")) total += 10_000 * lamaSewa;
        return total;
    }
}