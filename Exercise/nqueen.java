import java.util.ArrayList;
import java.util.Scanner;

class nqueen {

    // Modified to return boolean to stop after finding the first solution
    static boolean solveFirst(int i, int[] cols, int[] leftDiagonal,
                            int[] rightDiagonal, ArrayList<Integer> cur) {
        int n = cols.length;

        if (i == n) {
            printBoard(cur, n);
            return true; // Found a solution, stop searching
        }

        for (int j = 0; j < n; j++) {
            if (cols[j] == 1 || rightDiagonal[i + j] == 1 ||
                leftDiagonal[i - j + n - 1] == 1)
                continue;

            cols[j] = 1;
            rightDiagonal[i + j] = 1;
            leftDiagonal[i - j + n - 1] = 1;
            cur.add(j + 1);

            // If a solution was found in the recursive call, return true immediately
            if (solveFirst(i + 1, cols, leftDiagonal, rightDiagonal, cur)) return true;

            // Backtrack
            cur.remove(cur.size() - 1);
            cols[j] = 0;
            rightDiagonal[i + j] = 0;
            leftDiagonal[i - j + n - 1] = 0;
        }
        return false;
    }

    // Helper to print the board as a square box
    static void printBoard(ArrayList<Integer> solution, int n) {
        System.out.println("One valid solution for N = " + n + ":");
        for (int row = 0; row < n; row++) {
            int queenCol = solution.get(row);
            for (int col = 1; col <= n; col++) {
                if (col == queenCol) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println(); // Move to next row
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();

        int[] cols = new int[n];
        int[] leftDiagonal = new int[n * 2];
        int[] rightDiagonal = new int[n * 2];
        ArrayList<Integer> cur = new ArrayList<>();

        if (!solveFirst(0, cols, leftDiagonal, rightDiagonal, cur)) {
            System.out.println("No solution exists.");
        }
        sc.close();
    }
}
