package module1_advance_dsa.array_techniques;

import java.util.ArrayList;

/**
 * Given an array A of length N. Also given are integers B and C.
 * <p>
 * Return 1 if there exists a subarray with length B having sum C and 0 otherwise
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * <p>
 * 1 <= A[i] <= 104
 * <p>
 * 1 <= B <= N
 * <p>
 * 1 <= C <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument A is an array of integers.
 * <p>
 * The remaining arguments B and C are integers
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if such a subarray exist and 0 otherwise
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [4, 3, 2, 6, 1]
 * B = 3
 * C = 11
 * Input 2:
 * <p>
 * A = [4, 2, 2, 5, 1]
 * B = 4
 * C = 6
 * <p>
 * <p>
 * Example Output  1:
 * 1
 * Output 2:
 * 0
 * <p>
 * <p>
 * Example Explanation  1:
 * The subarray [3, 2, 6] is of length 3 and sum 11.
 * Explanation 2:
 * There are no such subarray.
 */
public class slidingWindow {
    public int solve(ArrayList<Integer> A, int B, int C) {

        int sum = 0;
        int n = A.size();

        for (int i = 0; i < B; i++) {
            sum += A.get(i);
        }

        if (sum == C) {
            return 1;
        }

        if (n > 1) {
            int l = 1;
            int r = B;

            while (r < n) {
                sum = sum + A.get(r) - A.get(l - 1);
                if (sum == C) {
                    return 1;
                }
                l++;
                r++;
            }
        }
        return 0;
    }
}
