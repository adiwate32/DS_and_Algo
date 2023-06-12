package module1.array_techniques;

import java.util.ArrayList;

/**
 * Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from
 * these indices makes the sum of even-indexed and odd-indexed array elements equal.
 * <p>
 * Problem Constraints
 * 1 <= n <= 105
 * -105 <= A[i] <= 105
 * <p>
 * <p>
 * Input Format
 * First argument contains an array A of integers of size N
 * <p>
 * <p>
 * Output Format
 * Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and
 * odd-indexed array elements equal.
 * <p>
 * Example Input
 * Input 1:
 * A=[2, 1, 6, 4]
 * Input 2:
 * A=[1, 1, 1]
 * <p>
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 3
 * <p>
 * Example Explanation  1:
 * Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
 * Therefore, the required output is 1.
 * Explanation 2:
 * <p>
 * Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
 * Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
 * Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
 * Therefore, the required output is 3.
 */
public class specialIndex {
    public int solve(ArrayList<Integer> A) {

        int n = A.size();

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 0;
        }

        ArrayList<Integer> pSum = new ArrayList<>(n);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sum += A.get(i);
            } else {
                sum -= A.get(i);
            }
            pSum.add(sum);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (pSum.get(n - 1) - pSum.get(0) == 0)
                    cnt++;
            } else {
                if ((pSum.get(i - 1) - pSum.get(n - 1) + pSum.get(i)) == 0) {
                    cnt++;
                }
            }
        }
        return cnt;

    }
}
