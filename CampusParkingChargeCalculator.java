import java.util.Scanner;

public class CampusParkingChargeCalculator {

    // Common operation (calculateCharge) with distinct per-vehicle pricing rules.
    static abstract class Vehicle {
        abstract double calculateCharge(int hours);
    }

    static class Bike extends Vehicle {
        double calculateCharge(int hours) {
            return 10 * hours;
        }
    }

    static class Car extends Vehicle {
        double calculateCharge(int hours) {
            if (hours <= 1) {
                return 30;
            }
            return 30 + 20 * (hours - 1);
        }
    }

    static class Truck extends Vehicle {
        double calculateCharge(int hours) {
            return Math.max(50 * hours, 100);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);

            Vehicle vehicle;
            switch (type) {
                case "BIKE":
                    vehicle = new Bike();
                    break;
                case "CAR":
                    vehicle = new Car();
                    break;
                case "TRUCK":
                    vehicle = new Truck();
                    break;
                default:
                    System.out.println("Unknown vehicle type: " + type);
                    continue;
            }

            double charge = vehicle.calculateCharge(hours);
            grandTotal += charge;

            System.out.printf("%s: %.2f%n", type, charge);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}
