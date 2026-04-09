package INHERITENCE;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        
        // MANUSIA
        System.out.println("=== 1. TEST CASE MANUSIA ===");
        // a. Laki-laki menikah, dapat tunjangan $25
        Manusia m1 = new Manusia("Daniar Yahya", "111", true, true);
        // b. Perempuan menikah, dapat tunjangan $20
        Manusia m2 = new Manusia("Giovanni Firja", "222", false, true);
        // c. Belum menikah, dapat tunjangan $15
        Manusia m3 = new Manusia("Nayla Amalia", "333", false, false);

        System.out.println(m1.toString() + "\n");
        System.out.println(m2.toString() + "\n");
        System.out.println(m3.toString() + "\n");


        // MAHASISWA
        System.out.println("=== 2. TEST CASE MAHASISWA FILKOM ===");
        // a. Ipk < 3 tidak dapat beasiswa
        MahasiswaFILKOM mhs1 = new MahasiswaFILKOM("Ella Edelweis", "2351504001", true, false, "255150701111001", 2.8);
        // b. Ipk 3 – 3.5, dapat beasiswa $50
        MahasiswaFILKOM mhs2 = new MahasiswaFILKOM("Lista Azzuhra", "2351504002", false, false, "225150401111002", 3.2);
        // c. Ipk 3.5 – 4, dapat beasiswa $75
        MahasiswaFILKOM mhs3 = new MahasiswaFILKOM("Farzan Hanif", "2351504003", true, false, "245150301111003", 3.9);

        System.out.println(mhs1.toString() + "\n");
        System.out.println(mhs2.toString() + "\n");
        System.out.println(mhs3.toString() + "\n");


        // PEKERJA
        System.out.println("=== 3. TEST CASE PEKERJA ===");
        int currentYear = LocalDate.now().getYear();
        
        // a. Bekerja 2 tahun dapat bonus 5%, anak 2 dapet tunjangan anak $40
        Pekerja p1 = new Pekerja("Tranisa Jubille", "261736619092", true, true, 1000, currentYear - 2, 1, 1, 2);
        // b. Bekerja 9 tahun dapat bonus 10%, anak 0
        Pekerja p2 = new Pekerja("Handip", "351628918201827", false, true, 1000, currentYear - 9, 1, 1, 0);
        // c. Bekerja 20 tahun dapat bonus 15%, anak 10 dapet tunjangan anak $200
        Pekerja p3 = new Pekerja("Wanda Merisa", "33561802199281", true, true, 1000, currentYear - 20, 1, 1, 10);

        System.out.println(p1.toString() + "\n");
        System.out.println(p2.toString() + "\n");
        System.out.println(p3.toString() + "\n");


        // MANAGER 
        System.out.println("=== 4. TEST CASE MANAGER ===");
        // Manager lama bekerja 15 tahun (Bonus 15%), Gaji $7500, Tunjangan Manager (10% Gaji = $750)
        Manager mgr = new Manager("Rafi Khoisyia", "444444444444", true, true, 7500, currentYear - 15, 1, 1, 0, "Supervisor");
        
        System.out.println(mgr.toString());
    }
}