public class Jaket {
    // Harga final tanpa diskon
    private final double hargaA = 100000;
    private final double hargaB = 125000;
    private final double hargaC = 175000;

    // Harga final dengan diskon
    private final double hargaDiskonA = 95000;
    private final double hargaDiskonB = 120000;
    private final double hargaDiskonC = 160000;

    private int jumlahA;
    private int jumlahB;
    private int jumlahC;

    public Jaket(int jumlahA, int jumlahB, int jumlahC) {
        this.jumlahA = jumlahA;
        this.jumlahB = jumlahB;
        this.jumlahC = jumlahC;
    }

    // Hitung harga jaket A
    public double hitungHargaA() {
        if (jumlahA > 100) {
            return jumlahA * hargaDiskonA;
        } else {
            return jumlahA * hargaA;
        }
    }

    // Hitung harga jaket B
    public double hitungHargaB() {
        if (jumlahB > 100) {
            return jumlahB * hargaDiskonB;
        } else {
            return jumlahB * hargaB;
        }
    }

    // Hitung harga jaket C
    public double hitungHargaC() {
        if (jumlahC > 100) {
            return jumlahC * hargaDiskonC;
        } else {
            return jumlahC * hargaC;
        }
    }

    public double hitungTotalHarga() {
        return hitungHargaA() + hitungHargaB() + hitungHargaC();
    }

    public int getJumlahA() { return jumlahA; }
    public int getJumlahB() { return jumlahB; }
    public int getJumlahC() { return jumlahC; }

    public double getHargaSatuanA() { return jumlahA > 100 ? hargaDiskonA : hargaA; }
    public double getHargaSatuanB() { return jumlahB > 100 ? hargaDiskonB : hargaB; }
    public double getHargaSatuanC() { return jumlahC > 100 ? hargaDiskonC : hargaC; }
}