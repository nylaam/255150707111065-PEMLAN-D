package Modul9_GUI.Bab8AWT;

public class Probstat {
    private double tugas, kuis, uts, uas;

    public Probstat(double tugas, double kuis, double uts, double uas) {
        this.tugas = tugas;
        this.kuis  = kuis;
        this.uts   = uts;
        this.uas   = uas;
    }

    // Rumus: 20% Tugas + 20% Kuis + 20% UTS + 40% UAS
    public double hitungNilaiAkhir() {
        return (tugas * 0.20) + (kuis * 0.20) + (uts * 0.20) + (uas * 0.40);
    }
}