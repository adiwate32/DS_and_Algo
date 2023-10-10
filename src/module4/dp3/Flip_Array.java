package module4.dp3;

import java.util.Arrays;

/**
 Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).
 Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.

 Problem Constraints
 1 <= length of(A) <= 100
 Sum of all the elements will not exceed 10,000.

 Input Format
 First and only argument is an integer array A.

 Output Format
 Return an integer denoting the minimum number of elements whose sign needs to be flipped.

 Example Input
 Input 1:
 A = [15, 10, 6]
 Input 2:
 A = [14, 10, 4]

 Example Output
 Output 1:
 1
 Output 2:
 1

 Example Explanation
 Explanation 1:
 Here, we will flip the sign of 15 and the resultant sum will be 1.
 Explanation 2:
 Here, we will flip the sign of 14 and the resultant sum will be 0.
 Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there sign are not minimum.
 */
public class Flip_Array {
    public int solve(final int[] A) {
        int n = A.length;
        int sum = 0;

        for(int i=0; i<n; i++)
        {
            sum += A[i];
        }

        int[][] dp = new int[n][sum/2+1];
        for(int i[]: dp) Arrays.fill(i, -1);

        return knapsack(A, sum/2, n-1, dp);
    }

    public int knapsack(int[] A, int sum, int i, int[][] dp)
    {
        if(sum == 0) return 0;

        if(i < 0) return 100000000;

        if(dp[i][sum] != -1) return dp[i][sum];

        int rej = knapsack(A, sum , i-1, dp);

        int sel = 100000000;

        if(sum >= A[i])
        {
            sel = 1 + knapsack(A, sum-A[i], i-1, dp);
        }

        int ans = Math.min(rej, sel);
        return dp[i][sum] = ans;
    }
}
