import java.util.Scanner;

public class TypingSpeedTestAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        int total = original.length();
        int matched = 0;
        int firstMismatchPosition = -1;

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1; // report as 1-indexed position
            }
        }

        double accuracy = (matched * 100.0) / total;

        String result = "Matched: " + matched + "/" + total +
                " | Accuracy: " + String.format("%.2f", accuracy) + "%";

        if (firstMismatchPosition == -1) {
            result += " | No Mismatches";
        } else {
            char originalChar = original.charAt(firstMismatchPosition - 1);
            char typedChar = typed.charAt(firstMismatchPosition - 1);
            result += " | First Mismatch at position " + firstMismatchPosition +
                    " ('" + originalChar + "' vs '" + typedChar + "')";
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);

        sc.close();
    }
}
