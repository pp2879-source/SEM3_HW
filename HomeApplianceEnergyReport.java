import java.util.Scanner;

public class HomeApplianceEnergyReport {

    // Only appliances that implement this support saver mode.
    interface SaverModeCapable {
        default double applySaverMode(double units) {
            return units * 0.75; // 25% reduction
        }
    }

    static abstract class Appliance {
        protected double powerWatts;
        protected double hours;

        Appliance(double powerWatts, double hours) {
            this.powerWatts = powerWatts;
            this.hours = hours;
        }

        // Shared for every appliance.
        double calculateUnits() {
            return powerWatts * hours / 1000;
        }

        double calculateCost(double units) {
            return units * 8;
        }
    }

    static class Fridge extends Appliance {
        Fridge(double hours) {
            super(150, hours);
        }
    }

    static class AirConditioner extends Appliance implements SaverModeCapable {
        AirConditioner(double hours) {
            super(1500, hours);
        }
    }

    static class Tv extends Appliance {
        Tv(double hours) {
            super(100, hours);
        }
    }

    static class WashingMachine extends Appliance implements SaverModeCapable {
        WashingMachine(double hours) {
            super(500, hours);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String applianceType = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = parts.length > 2 && parts[2].equals("SAVER");

            Appliance appliance;
            switch (applianceType) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AirConditioner(hours);
                    break;
                case "TV":
                    appliance = new Tv(hours);
                    break;
                case "WASHER":
                    appliance = new WashingMachine(hours);
                    break;
                default:
                    System.out.println("Unknown appliance type: " + applianceType);
                    continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested) {
                if (appliance instanceof SaverModeCapable) {
                    units = ((SaverModeCapable) appliance).applySaverMode(units);
                } else {
                    System.out.println(applianceType + ": saver mode not supported");
                    continue;
                }
            }

            double cost = appliance.calculateCost(units);
            totalCost += cost;

            System.out.printf("%s: Units=%.2f Cost=%.2f%n", applianceType, units, cost);
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
