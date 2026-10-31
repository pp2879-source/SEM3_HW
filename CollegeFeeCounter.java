import java.util.Scanner;

public class CollegeFeeCounter {

    // Marker-style interface: the fee counter checks "does this student use the bus?"
    // via an instanceof check instead of comparing against the student's type name.
    interface BusUser {
        double TRANSPORT_FEE = 12000; // interface fields are implicitly public static final
    }

    static abstract class Student {
        protected String name;

        Student(String name) {
            this.name = name;
        }

        abstract double getTuitionFee();

        double calculateTotalFee() {
            double total = getTuitionFee();
            if (this instanceof BusUser) {
                total += BusUser.TRANSPORT_FEE;
            }
            return total;
        }
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) {
            super(name);
        }

        double getTuitionFee() {
            return 40000;
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }

        double getTuitionFee() {
            return 40000 + 60000;
        }
    }

    static class ScholarshipStudent extends Student implements BusUser {
        ScholarshipStudent(String name) {
            super(name);
        }

        double getTuitionFee() {
            return 20000;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];

            Student student;
            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
                default:
                    System.out.println("Unknown student type: " + type);
                    continue;
            }

            double fee = student.calculateTotalFee();
            totalCollected += fee;

            System.out.printf("%s: %.2f%n", name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
