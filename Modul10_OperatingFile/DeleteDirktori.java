package Modul10_OperatingFile;

import java.io.File;

public class DeleteDirktori {
    public static void main(String[] args) {
        File direktori = new File("E:\\COLLEGE\\Operating-File\\DeleteFile");

        if (direktori.exists() && direktori.isDirectory()) {
            File[] daftarFile = direktori.listFiles();

            for (File f : daftarFile) {
                f.delete();
                System.out.println("File dihapus: " + f.getName());
            }

            boolean berhasil = direktori.delete();

            if (berhasil) {
                System.out.println("================================");
                System.out.println("Direktori berhasil dihapus!");
            } else {
                System.out.println("Direktori gagal dihapus!");
            }
        } else {
            System.out.println("Direktori tidak ditemukan!");
        }
    }
}
