import java.util.Scanner;

public class Problem05BusiestBusRow {
    // Returns {rowIndex, rowTotal}. Ties are resolved in favor of the smaller index.
    public static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }
            // Strictly greater preserves the earlier row when totals tie.
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }
        return new int[] { bestRow, bestTotal };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] grid = new int[rows][cols];
        System.out.println("Enter the student counts for each seat:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) grid[i][j] = sc.nextInt();
        }

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
        System.out.println("Time Complexity: O(r * c)");
        System.out.println("Additional Space Complexity: O(1)");
        sc.close();
    }
}
