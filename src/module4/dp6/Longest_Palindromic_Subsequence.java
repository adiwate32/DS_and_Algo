package module4.dp6;

import java.util.Arrays;

/**
 Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).
 You need to return the length of longest palindromic subsequence.

 Problem Constraints
 1 <= length of(A) <= 103

 Input Format
 First and only integer is a string A.

 Output Format
 Return an integer denoting the length of longest palindromic subsequence.

 Example Input
 Input 1:
 A = "bebeeed"
 Input 2:
 A = "aedsead"

 Example Output
 Output 1:
 4
 Output 2:
 5

 Example Explanation
 Explanation 1:
 The longest palindromic subsequence is "eeee", which has a length of 4.
 Explanation 2:
 The longest palindromic subsequence is "aedea", which has a length of 5.
 */
public class Longest_Palindromic_Subsequence {
    public int solve(String A) {
        int n = A.length();
        int[][] dp = new int[n][n];
        for(int i[]: dp) Arrays.fill(i, -1);
        StringBuilder temp = new StringBuilder(A).reverse();
        String B = temp.toString();

        return lcs(A, B, n-1, n-1, dp);
    }

    public int lcs(String A, String B, int i, int j, int[][] dp)
    {
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = 0;

        char c1 = A.charAt(i);
        char c2 = B.charAt(j);

        if(c1 == c2)
        {
            ans = 1 + lcs(A, B, i-1, j-1, dp);
        }
        else
        {
            int a = lcs(A, B, i-1, j, dp);
            int b = lcs(A, B, i, j-1, dp);

            ans = Math.max(a, b);
        }

        return dp[i][j] = ans;

    }
}
