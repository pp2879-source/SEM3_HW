import java.util.Scanner;

public class CityCabFareMeter {

    // Only cab types that implement this can offer night service.
    // A new cab type simply opts in (or not) by implementing this interface.
    interface NightServiceCapable {
        default double applyNightSurcharge(double fare) {
            return fare * 1.2;
        }
    }

    static abstract class Cab {
        protected double ratePerKm;

        Cab(double ratePerKm) {
            this.ratePerKm = ratePerKm;
        }

        // Shared rule for every cab: no trip costs less than 100.
        double calculateFare(double km) {
            double fare = km * ratePerKm;
            return Math.max(fare, 100);
        }
    }

    static class MiniCab extends Cab {
        MiniCab() {
            super(10);
        }
    }

    static class SedanCab extends Cab implements NightServiceCapable {
        SedanCab() {
            super(14);
        }
    }

    static class SuvCab extends Cab implements NightServiceCapable {
        SuvCab() {
            super(18);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String cabType = parts[0];
            double km = Double.parseDouble(parts[1]);
            String time = parts[2];

            Cab cab;
            switch (cabType) {
                case "MINI":
                    cab = new MiniCab();
                    break;
                case "SEDAN":
                    cab = new SedanCab();
                    break;
                case "SUV":
                    cab = new SuvCab();
                    break;
                default:
                    System.out.println("Unknown cab type: " + cabType);
                    continue;
            }

            double fare = cab.calculateFare(km);

            if (time.equals("NIGHT")) {
                if (cab instanceof NightServiceCapable) {
                    fare = ((NightServiceCapable) cab).applyNightSurcharge(fare);
                } else {
                    System.out.println(cabType + ": night service not available");
                    continue;
                }
            }

            total += fare;
            System.out.printf("%s: %.2f%n", cabType, fare);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
