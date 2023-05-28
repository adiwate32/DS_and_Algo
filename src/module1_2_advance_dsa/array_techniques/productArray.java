package module1_2_advance_dsa.array_techniques;

import java.util.ArrayList;

/**
 * Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.
 *
 * Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 * Output Format
 *
 * Return the product array.
 * Constraints
 *
 * 2 <= length of the array <= 1000
 * 1 <= A[i] <= 10
 * For Example
 *
 * Input 1:
 *     A = [1, 2, 3, 4, 5]
 * Output 1:
 *     [120, 60, 40, 30, 24]
 *
 * Input 2:
 *     A = [5, 1, 10, 1]
 * Output 2:
 *     [10, 50, 5, 50]
 */

public class productArray {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        int n = A.size();
        ArrayList<Integer> pSum = new ArrayList<>(n);
        ArrayList<Integer> sSum = new ArrayList<>(n);

        int mul1 = 1;
        int mul2 = 1;
        pSum.add(1);
        sSum.add(1);
        for(int i=1; i < n; i++)
        {
            mul1 *= A.get(i-1);
            mul2 *= A.get(n-i);

            pSum.add(mul1);
            sSum.add(mul2);
        }
        ArrayList<Integer> ans = new ArrayList<>(n);

        for(int i=0; i<n; i++)
        {
            ans.add(pSum.get(i)*sSum.get(n-i-1));
        }

        return ans;
    }
}
