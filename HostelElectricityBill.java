import java.util.Scanner;

public class HostelElectricityBill {

    // Common operation (calculateBill); a shared room simply stores one extra
    // value (occupants) internally - the main loop still treats every room the same way.
    static abstract class Room {
        protected double units;

        Room(double units) {
            this.units = units;
        }

        abstract double calculateBill();
    }

    static class SingleRoom extends Room {
        SingleRoom(double units) {
            super(units);
        }

        double calculateBill() {
            return units * 8;
        }
    }

    static class SharedRoom extends Room {
        private int occupants;

        SharedRoom(double units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        double calculateBill() {
            return (units * 6) / occupants;
        }
    }

    static class AcRoom extends Room {
        AcRoom(double units) {
            super(units);
        }

        double calculateBill() {
            return units * 10 + 200;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double units = Double.parseDouble(parts[1]);

            Room room;
            switch (type) {
                case "SINGLE":
                    room = new SingleRoom(units);
                    break;
                case "SHARED":
                    int occupants = Integer.parseInt(parts[2]);
                    room = new SharedRoom(units, occupants);
                    break;
                case "AC":
                    room = new AcRoom(units);
                    break;
                default:
                    System.out.println("Unknown room type: " + type);
                    continue;
            }

            double bill = room.calculateBill();
            grandTotal += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}
