import java.util.Scanner;

public class ParcelShippingDesk {

    // Only parcel types that implement this can be insured.
    // Adding a new insurable parcel type later never touches the ones that aren't.
    interface Insurable {
        double calculateInsurance();
    }

    static abstract class Parcel {
        protected double weightKg;
        protected double declaredValue;

        Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        abstract double calculateCharge();
    }

    static class StandardParcel extends Parcel {
        StandardParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        double calculateCharge() {
            return 40 + 10 * weightKg;
        }
    }

    static class ExpressParcel extends Parcel implements Insurable {
        ExpressParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        double calculateCharge() {
            return 80 + 15 * weightKg;
        }

        public double calculateInsurance() {
            return 0.02 * declaredValue;
        }
    }

    static class FragileParcel extends Parcel implements Insurable {
        FragileParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        double calculateCharge() {
            return (40 + 10 * weightKg) + 50;
        }

        public double calculateInsurance() {
            return 0.02 * declaredValue;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double declaredValue = Double.parseDouble(parts[2]);

            Parcel parcel;
            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, declaredValue);
                    break;
                case "EXPRESS":
                    parcel = new ExpressParcel(weight, declaredValue);
                    break;
                case "FRAGILE":
                    parcel = new FragileParcel(weight, declaredValue);
                    break;
                default:
                    System.out.println("Unknown parcel type: " + type);
                    continue;
            }

            double charge = parcel.calculateCharge();
            double insurance = (parcel instanceof Insurable) ? ((Insurable) parcel).calculateInsurance() : 0;
            double total = charge + insurance;
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", type, charge, insurance, total);
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
