package INTERFACE;

public class Main {
    public static void main(String[] args) {
        Invoice[] invoices = {
            new Invoice("Air Minum Kemasan", 10, 25000),
            new Invoice("Beras", 10, 75000),
            new Invoice("Telur", 7, 27500)
        };

        Employee emp = new Employee(
                "Nayla Nur Amalia",
                2500000,
                invoices
        );

        emp.displayInfo();
    }
}