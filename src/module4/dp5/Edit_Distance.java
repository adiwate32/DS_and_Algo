package module4.dp5;

import java.util.Arrays;

/**
 Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
 You have the following 3 operations permitted on a word:

 Insert a character
 Delete a character
 Replace a character

 Problem Constraints
 1 <= length(A), length(B) <= 450

 Input Format
 The first argument of input contains a string, A.
 The second argument of input contains a string, B.

 Output Format
 Return an integer, representing the minimum number of steps required.

 Example Input
 Input 1:
 A = "abad"
 B = "abac"
 Input 2:
 A = "Anshuman"
 B = "Antihuman

 Example Output
 Output 1:
 1
 Output 2:
 2

 Example Explanation
 Exlanation 1:
 A = "abad" and B = "abac"
 After applying operation: Replace d with c. We get A = B.
 Explanation 2:
 A = "Anshuman" and B = "Antihuman"
 After applying operations: Replace s with t and insert i before h. We get A = B.
 */
public class Edit_Distance {
    public int minDistance(String A, String B) {
        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n][m];
        for(int i[]: dp) Arrays.fill(i, -1);

        return editDistance(A, B, n-1, m-1, dp);
    }

    public int editDistance(String A, String B, int i, int j, int[][] dp)
    {
        if(i < 0 && j < 0) return 0;
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        char c1 = A.charAt(i);
        char c2 = B.charAt(j);

        int ans = 0;

        if(c1 == c2)
        {
            ans = editDistance(A, B, i-1, j-1, dp);
        }
        else
        {
            int a = editDistance(A, B, i-1, j, dp); // delete a character from A
            int b = editDistance(A, B, i, j-1, dp); // inserting a char from B to A
            int c = editDistance(A, B, i-1, j-1, dp); // replacing a char from B to A

            ans = 1 + Math.min(a, Math.min(b, c));
        }

        return dp[i][j] = ans;

    }
}
