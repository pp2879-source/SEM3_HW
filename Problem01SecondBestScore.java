import java.util.Scanner;

public class Problem01SecondBestScore {
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        int[] scores = new int[n];
        System.out.println("Enter the scores:");
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();

        System.out.println("Second-highest distinct score: " + secondHighest(scores));
        System.out.println("Time Complexity: O(n)");
        System.out.println("Space Complexity: O(1) auxiliary space");
        System.out.println("Sorting first would take O(n log n) time and may require extra space.");
        sc.close();
    }
}
