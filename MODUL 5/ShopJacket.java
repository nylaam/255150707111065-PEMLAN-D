import java.util.Scanner;

public class ShopJacket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        garis('=', 40);
        System.out.println("   CV. LABKOMDAS - Penjualan Jaket");
        garis('=', 40);
        System.out.println();
        System.out.printf("  %-10s %15s%n", "Jenis", "Harga Normal");
        garis('-', 40);
        System.out.printf("  %-10s %15s%n", "Jaket A", "Rp  100.000/biji");
        System.out.printf("  %-10s %15s%n", "Jaket B", "Rp  125.000/biji");
        System.out.printf("  %-10s %15s%n", "Jaket C", "Rp  175.000/biji");
        garis('-', 40);
        System.out.println();
        System.out.println("  >> Diskon aktif jika beli > 100 biji:");
        System.out.printf("     %-10s -> %s%n", "Jaket A", "Rp  95.000/biji");
        System.out.printf("     %-10s -> %s%n", "Jaket B", "Rp 120.000/biji");
        System.out.printf("     %-10s -> %s%n", "Jaket C", "Rp 160.000/biji");
        System.out.println();
        garis('-', 40);

        System.out.print("  Jumlah Jaket A : ");
        int qA = sc.nextInt();
        System.out.print("  Jumlah Jaket B : ");
        int qB = sc.nextInt();
        System.out.print("  Jumlah Jaket C : ");
        int qC = sc.nextInt();

        Jaket j = new Jaket(qA, qB, qC);

        System.out.println();
        garis('=', 40);
        System.out.println("         STRUK PEMBELIAN");
        garis('=', 40);

        printBaris("Jaket A", j.getJumlahA(), j.getHargaSatuanA(),
                   j.hitungHargaA(), j.getJumlahA() > 100);
        printBaris("Jaket B", j.getJumlahB(), j.getHargaSatuanB(),
                   j.hitungHargaB(), j.getJumlahB() > 100);
        printBaris("Jaket C", j.getJumlahC(), j.getHargaSatuanC(),
                   j.hitungHargaC(), j.getJumlahC() > 100);

        garis('=', 40);
        System.out.printf("  %-20s %s%n", "GRAND TOTAL",
                          ": Rp " + fmt(j.hitungTotalHarga()));
        garis('=', 40);

        sc.close();
    }

    static void printBaris(String nama, int qty, double harga,
                           double total, boolean diskon) {
        garis('-', 40);
        System.out.printf("  %-10s : %d buah%n", nama, qty);
        if (diskon) {
            System.out.printf("  %-10s : Rp %s/biji  [DISKON]%n", "Harga", fmt(harga));
        } else {
            System.out.printf("  %-10s : Rp %s/biji%n", "Harga", fmt(harga));
        }
        System.out.printf("  %-10s : Rp %s%n", "Total", fmt(total));
    }

    static void garis(char c, int n) {
        for (int i = 0; i < n; i++) System.out.print(c);
        System.out.println();
    }

    static String fmt(double n) {
        long x = (long) n;
        String s = Long.toString(x);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (count > 0 && count % 3 == 0) sb.insert(0, ".");
            sb.insert(0, s.charAt(i));
            count++;
        }
        return sb.toString();
    }
}