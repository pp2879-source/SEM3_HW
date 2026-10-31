import java.util.Scanner;

public class Problem04ClassAttendanceTracker {
    public static int[] attendanceSummary(int[] days) {
        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++;
                if (currentStreak > longestStreak) longestStreak = currentStreak;
            } else {
                currentStreak = 0;
            }
        }
        return new int[] { present, longestStreak };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int[] days = new int[n];
        System.out.println("Enter attendance values (1 = present, 0 = absent):");
        for (int i = 0; i < n; i++) days[i] = sc.nextInt();

        int[] result = attendanceSummary(days);
        System.out.println("Present: " + result[0] + ", Longest streak: " + result[1]);
        System.out.println("Time Complexity: O(n)");
        System.out.println("Space Complexity: O(1) auxiliary space");
        System.out.println("Both results are calculated in one pass.");
        sc.close();
    }
}
