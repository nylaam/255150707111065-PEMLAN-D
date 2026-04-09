package INHERITENCE;

public class Manager extends Pekerja {
    private String departemen;

    public Manager(String nama, String nik, boolean jenisKelamin, boolean menikah, double gaji, int tahun, int bulan,
            int hari, int jumlahAnak, String departemen) {
        super(nama, nik, jenisKelamin, menikah, gaji, tahun, bulan, hari, jumlahAnak);
        this.departemen = departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public String getDepartemen() {
        return departemen;
    }

    @Override
    public double getTunjangan() {
        // Return tunjangan perhitungan tunjangan dasar + tunjangan anak + 10% gaji
        // managernya
        return super.getTunjangan() + (0.10 * getGaji());
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Departemen    : " + departemen + "\n" +
                "Tj. Manager   : $" + (0.10 * getGaji());
    }
}
