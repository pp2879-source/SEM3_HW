import java.time.LocalDate;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {

    // Common operation (getRenewalDate); each plan only needs to know its own validity period.
    static abstract class Plan {
        abstract int getValidityDays();

        LocalDate getRenewalDate(LocalDate startDate) {
            return startDate.plusDays(getValidityDays());
        }
    }

    static class BasicPlan extends Plan {
        int getValidityDays() {
            return 30;
        }
    }

    static class StandardPlan extends Plan {
        int getValidityDays() {
            return 90;
        }
    }

    static class PremiumPlan extends Plan {
        int getValidityDays() {
            return 365;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2]);

            Plan plan;
            switch (type) {
                case "BASIC":
                    plan = new BasicPlan();
                    break;
                case "STANDARD":
                    plan = new StandardPlan();
                    break;
                case "PREMIUM":
                    plan = new PremiumPlan();
                    break;
                default:
                    System.out.println("Unknown plan type: " + type);
                    continue;
            }

            LocalDate renewalDate = plan.getRenewalDate(startDate);
            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}
