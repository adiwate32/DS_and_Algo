package module1_advance_dsa.array_techniques;

import java.util.ArrayList;

/**
 * You are given an integer array A of size N.
 * <p>
 * You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of
 * the array A.
 * <p>
 * Find and return the maximum possible sum of the elements that were removed after B operations.
 * <p>
 * NOTE: Suppose B = 4, and array A contains 10 elements, then
 * <p>
 * You can remove the first four elements or can remove the last four elements, or can remove 1 from front and 3 from
 * the back, etc. You need to return the maximum possible sum of elements you can remove.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * <p>
 * 1 <= B <= N
 * <p>
 * -103 <= A[i] <= 103
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A.
 * <p>
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the maximum possible sum of elements you removed.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [5, -2, 3 , 1, 2]
 * B = 3
 * Input 2:
 * <p>
 * A = [ 2, 3, -1, 4, 2, 1 ]
 * B = 4
 * <p>
 * <p>
 * Example Output  1:
 * <p>
 * 8
 * Output 2:
 * <p>
 * 9
 * <p>
 * <p>
 * Example Explanation  1:
 * <p>
 * Remove element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
 * Explanation 2:
 * <p>
 * Remove the first element and the last 3 elements. So we get 2 + 4 + 2 + 1 = 9
 */


public class maxPosSum {
    /**
     * Brute Force
     */
    public int solve1(ArrayList<Integer> A, int B) {
        int n = A.size();

        int l = -1;

        int r = n - B;
        int maxSum = Integer.MIN_VALUE;

        while (l < B) {
            int sum = 0;
            if (l != -1) {
                for (int i = 0; i <= l; i++) {
                    sum += A.get(i);
                }
            }
            if (r != n) {
                for (int i = r; i <= n - 1; i++) {
                    sum += A.get(i);
                }
            }
            maxSum = Math.max(maxSum, sum);
            l++;
            r++;
        }
        return maxSum;
    }

    /**
     * Optimised solution
     */
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();

        if (n == 1) {
            return A.get(0);
        }

        int maxSum = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = n - B; i < n; i++) {
            sum += A.get(i);
        }
        maxSum = Math.max(maxSum, sum);

        int l = 0;
        int r = n - B + 1;

        while (l < B) {
            sum = sum + A.get(l) - A.get(r - 1);
            maxSum = Math.max(maxSum, sum);
            l++;
            r++;
        }
        return maxSum;
    }
}
