import java.util.Arrays;
import java.util.Scanner;

public class Problem03DutyRosterRotation {
    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] names = new String[n];
        System.out.println("Enter the names:");
        for (int i = 0; i < n; i++) names[i] = sc.nextLine();
        System.out.print("Enter right-rotation count k: ");
        long k = sc.nextLong();

        System.out.println("Rotated roster: " + Arrays.toString(rotateRoster(names, k)));
        System.out.println("Time Complexity: O(n)");
        System.out.println("Space Complexity: O(n) for the returned array");
        System.out.println("Using k % n avoids performing k separate rotations.");
        sc.close();
    }
}
