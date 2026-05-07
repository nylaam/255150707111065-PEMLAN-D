package Modul10_OperatingFile;

import java.io.File;

public class DaftarFile {
    public static void main(String[] args) {
        File direktori = new File("E:\\COLLEGE\\Operating-File");

        if (direktori.exists() && direktori.isDirectory()) {
            File[] daftarFile = direktori.listFiles();

            System.out.println("Isi direktori: " + direktori.getPath());
            System.out.println("================================");
            for (File f : daftarFile) {
                String tipe = f.isDirectory() ? "[FOLDER]" : "[FILE]  ";
                System.out.println(tipe + " " + f.getName());
            }
            System.out.println("================================");
            System.out.println("Total: " + daftarFile.length + " item");
        } else {
            System.out.println("Direktori tidak ditemukan!");
        }
    }
}