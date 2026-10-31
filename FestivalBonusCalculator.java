import java.util.Scanner;

public class FestivalBonusCalculator {

    // Common details (name, salary) and a common operation (calculateBonus),
    // each employee type following its own bonus rule.
    static abstract class Employee {
        protected String name;
        protected double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        abstract double calculateBonus();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        double calculateBonus() {
            return monthlySalary * 0.10;
        }
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        double calculateBonus() {
            return monthlySalary * 0.05;
        }
    }

    static class Intern extends Employee {
        Intern(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        double calculateBonus() {
            return 2000;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double totalBonus = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);

            Employee employee;
            switch (type) {
                case "FULLTIME":
                    employee = new FullTimeEmployee(name, salary);
                    break;
                case "PARTTIME":
                    employee = new PartTimeEmployee(name, salary);
                    break;
                case "INTERN":
                    employee = new Intern(name, salary);
                    break;
                default:
                    System.out.println("Unknown employee type: " + type);
                    continue;
            }

            double bonus = employee.calculateBonus();
            totalBonus += bonus;

            System.out.printf("%s: %.2f%n", name, bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);
        sc.close();
    }
}
