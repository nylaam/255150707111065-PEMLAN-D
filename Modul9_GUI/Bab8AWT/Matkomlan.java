package Modul9_GUI.Bab8AWT;

public class Matkomlan {
    private double tugas, kuis, uts, uas;

    public Matkomlan(double tugas, double kuis, double uts, double uas) {
        this.tugas = tugas;
        this.kuis  = kuis;
        this.uts   = uts;
        this.uas   = uas;
    }

    // Rumus: 25% Tugas + 15% Kuis + 20% UTS + 40% UAS
    public double hitungNilaiAkhir() {
        return (tugas * 0.25) + (kuis * 0.15) + (uts * 0.20) + (uas * 0.40);
    }
}