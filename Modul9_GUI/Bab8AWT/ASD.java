package Modul9_GUI.Bab8AWT;

public class ASD {
    private double tugas, kuis, uts, uas;

    public ASD(double tugas, double kuis, double uts, double uas) {
        this.tugas = tugas;
        this.kuis  = kuis;
        this.uts   = uts;
        this.uas   = uas;
    }

    // Rumus: 15% Tugas + 25% Kuis + 30% UTS + 30% UAS
    public double hitungNilaiAkhir() {
        return (tugas * 0.15) + (kuis * 0.25) + (uts * 0.30) + (uas * 0.30);
    }
}