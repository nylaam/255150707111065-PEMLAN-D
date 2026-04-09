package INHERITENCE;

import java.time.LocalDate;
import java.time.Period;

public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(String nama, String nik, boolean jenisKelamin, boolean menikah, double gaji, int tahun, int bulan,
            int hari, int jumlahAnak) {
        super(nama, nik, jenisKelamin, menikah);
        this.gaji = gaji;
        this.tahunMasuk = LocalDate.of(tahun, bulan, hari);
        this.jumlahAnak = jumlahAnak;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public double getGaji() {
        return gaji;
    }

    public void setTahunMasuk(LocalDate tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    public LocalDate getTahunMasuk() {
        return tahunMasuk;
    }

    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public int getJumlahAnak() {
        return jumlahAnak;
    }

    public double getBonus() {
        int masaKerja = Period.between(tahunMasuk, LocalDate.now()).getYears();
        if (masaKerja >= 0 && masaKerja <= 5)
            return gaji * 0.05;
        if (masaKerja > 5 && masaKerja <= 10)
            return gaji * 0.10;
        return gaji * 0.15;
    }

    @Override
    public double getTunjangan() {
        return super.getTunjangan() + (jumlahAnak * 20.0);
    }

    @Override
    public double getPendapatan() {
        return gaji + getBonus() + getTunjangan();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Tahun Masuk   : " + tahunMasuk + "\n" +
                "Jumlah Anak   : " + jumlahAnak + "\n" +
                "Gaji Pokok    : $" + gaji + "\n" +
                "Bonus Kerja   : $" + getBonus() + "\n" +
                "Tunjangan Anak: $" + (jumlahAnak * 20.0);
    }
}
