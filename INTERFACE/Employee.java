package INTERFACE;

public class Employee implements Payable {
    private String name;
    private int salaryPerMonth;
    private Invoice[] invoices;

    public Employee(String name, int salaryPerMonth, Invoice[] invoices) {
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    @Override
    public int getPayableAmount() {
        int total = 0;
        for (Invoice invoice : invoices) {
            total += invoice.getPayableAmount();
        }
        return total;
    }

    public int getNetSalary() {
        return salaryPerMonth - getPayableAmount();
    }

    public void displayInfo() {
        System.out.println("========================================");
        System.out.println("Nama            : " + name);
        System.out.println("Gaji            : Rp" + salaryPerMonth);
        System.out.println("========================================");
        System.out.println("Detail Belanja Koperasi:");
        System.out.println("----------------------------------------");

        for (Invoice invoice : invoices) {
            System.out.println("- " + invoice.getProductName()
                    + " : " + invoice.getQuantity()
                    + " x Rp" + invoice.getPricePerItem()
                    + " = Rp" + invoice.getPayableAmount());
        }

        System.out.println("----------------------------------------");
        System.out.println("Total Hutang        : Rp" + getPayableAmount());
        System.out.println("Gaji Yang Diterima  : Rp" + getNetSalary());
        System.out.println("========================================");
    }
}