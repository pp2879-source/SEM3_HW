import java.util.Scanner;

public class CanteenBillingCounter {

    // Common operation (calculateFinalAmount) that every customer type implements
    // in its own way - the billing loop never checks the type by name.
    static abstract class Customer {
        abstract double calculateFinalAmount(double billAmount);
    }

    static class StudentCustomer extends Customer {
        double calculateFinalAmount(double billAmount) {
            return billAmount * 0.90; // 10% discount
        }
    }

    static class StaffCustomer extends Customer {
        double calculateFinalAmount(double billAmount) {
            return billAmount * 0.95; // 5% discount
        }
    }

    static class GuestCustomer extends Customer {
        double calculateFinalAmount(double billAmount) {
            return billAmount + 10; // full amount + service charge
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            Customer customer;
            switch (type) {
                case "STUDENT":
                    customer = new StudentCustomer();
                    break;
                case "STAFF":
                    customer = new StaffCustomer();
                    break;
                case "GUEST":
                    customer = new GuestCustomer();
                    break;
                default:
                    System.out.println("Unknown customer type: " + type);
                    continue;
            }

            double finalAmount = customer.calculateFinalAmount(amount);
            grandTotal += finalAmount;

            System.out.printf("%s: %.2f%n", type, finalAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}
