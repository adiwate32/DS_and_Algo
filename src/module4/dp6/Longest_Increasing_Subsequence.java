package module4.dp6;

import java.util.Arrays;

/**
 Find the longest increasing subsequence of a given array of integers, A.
 In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.
 In this case, return the length of the longest increasing subsequence.

 Problem Constraints
 1 <= length(A) <= 2500
 0 <= A[i] <= 2500

 Input Format
 The first and the only argument is an integer array A.

 Output Format
 Return an integer representing the length of the longest increasing subsequence.

 Example Input
 Input 1:
 A = [1, 2, 1, 5]
 Input 2:
 A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]

 Example Output
 Output 1:
 3
 Output 2:
 6

 Example Explanation
 Explanation 1:
 The longest increasing subsequence: [1, 2, 5]
 Explanation 2:
 The possible longest increasing subsequences: [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 */
public class Longest_Increasing_Subsequence {
    public int lis(final int[] A) {
        int n = A.length;
        int ans = 0;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for(int i=0; i<n; i++)
        {
            ans = Math.max(ans, recursion(A, i, dp));
        }
        return ans;
    }

    public int recursion(int[] A, int i, int[] dp)
    {
        if(dp[i] != -1) return dp[i];
        int max = 0;

        for(int j=0; j<i; j++)
        {
            if(A[i] > A[j])
            {
                max = Math.max(max, recursion(A, j, dp));
            }
        }
        return dp[i] = max + 1;
    }
}
