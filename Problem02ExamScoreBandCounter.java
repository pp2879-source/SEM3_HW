import java.util.Scanner;

public class Problem02ExamScoreBandCounter {
    // Returns the first index whose value is >= target.
    private static int lowerBound(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // Returns the first index whose value is > target.
    private static int upperBound(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static int countInBand(int[] scores, int low, int high) {
        if (low > high) return 0;
        return upperBound(scores, high) - lowerBound(scores, low);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of scores: ");
        int n = sc.nextInt();
        int[] scores = new int[n];
        System.out.println("Enter scores in ascending order:");
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();
        System.out.print("Enter low and high: ");
        int low = sc.nextInt(), high = sc.nextInt();

        System.out.println("Number of scores in the band: " + countInBand(scores, low, high));
        System.out.println("Linear scan: O(n) time, O(1) auxiliary space");
        System.out.println("Binary-search solution: O(log n) time, O(1) auxiliary space");
        System.out.println("Lower bound includes duplicates equal to low; upper bound passes all duplicates equal to high.");
        sc.close();
    }
}
