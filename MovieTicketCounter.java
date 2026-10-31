import java.util.Scanner;

public class MovieTicketCounter {

    // Abstract base class: a plain "ticket" with no seat type can never be created,
    // since Ticket itself is abstract.
    static abstract class Ticket {
        private static final double CONVENIENCE_FEE = 20;

        abstract double getPricePerTicket();

        // Shared for every seat type - written once, here.
        double calculateAmount(int count) {
            return (getPricePerTicket() + CONVENIENCE_FEE) * count;
        }
    }

    static class RegularTicket extends Ticket {
        double getPricePerTicket() {
            return 150;
        }
    }

    static class PremiumTicket extends Ticket {
        double getPricePerTicket() {
            return 250;
        }
    }

    static class ReclinerTicket extends Ticket {
        double getPricePerTicket() {
            return 400;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String seat = parts[0];
            int count = Integer.parseInt(parts[1]);

            Ticket ticket;
            switch (seat) {
                case "REGULAR":
                    ticket = new RegularTicket();
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket();
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket();
                    break;
                default:
                    System.out.println("Unknown seat type: " + seat);
                    continue;
            }

            double amount = ticket.calculateAmount(count);
            total += amount;

            System.out.printf("%s: %.2f%n", seat, amount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
