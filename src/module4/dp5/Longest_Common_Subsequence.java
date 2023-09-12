package module4.dp5;

import java.util.Arrays;

/**
 Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
 You need to return the length of such longest common subsequence.

 Problem Constraints
 1 <= Length of A, B <= 1005

 Input Format
 First argument is a string A.
 Second argument is a string B.

 Output Format
 Return an integer denoting the length of the longest common subsequence.

 Example Input
 Input 1:
 A = "abbcdgf"
 B = "bbadcgf"
 Input 2:
 A = "aaaaaa"
 B = "ababab"

 Example Output
 Output 1:
 5
 Output 2:
 3

 Example Explanation
 Explanation 1:
 The longest common subsequence is "bbcgf", which has a length of 5.
 Explanation 2:
 The longest common subsequence is "aaa", which has a length of 3.
 */
public class Longest_Common_Subsequence {
    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n][m];
        for(int i[]: dp) Arrays.fill(i, -1);

        return lcs(A, B, n-1, m-1, dp);
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
