package module4.dp5;

import java.util.Arrays;

/**
 Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
 ' . ' : Matches any single character.
 ' * ' : Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).

 Problem Constraints
 1 <= length(A), length(B) <= 104

 Input Format
 The first argument of input contains a string A.
 The second argument of input contains a string B denoting the pattern.

 Output Format
 Return 1 if the patterns match else return 0.

 Example Input
 Input 1:
 A = "aab"
 B = "c*a*b"
 Input 2:
 A = "acz"
 B = "a.a"

 Example Output
 Output 1:
 1
 Output 2:
 0

 Example Explanation
 Explanation 1:
 'c' can be repeated 0 times, 'a' can be repeated 1 time. Therefore, it matches "aab".
 So, return 1.
 Explanation 2:
 '.' matches any single character. First two character in string A will be match.
 But the last character i.e 'z' != 'a'. Return 0.
 */
public class Regular_Expression_2 {
    public int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n][m];
        for(int i[]: dp) Arrays.fill(i, -1);

        return ismatch(A, B, n-1, m-1, dp);
    }

    public int ismatch(String A, String B, int i, int j, int[][] dp)
    {
        if(i<0 && j<0)
        {
            return 1;
        }

        if(i < 0)
        {
            char ch = B.charAt(j);
            if(ch == '*')
            {
                for(int k=j; k>=0; k-=2)
                {
                    ch = B.charAt(k);
                    if(ch != '*') return 0;
                }
            }
            return 1;
        }

        if(j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        char c1 = A.charAt(i);
        char c2 = B.charAt(j);

        int ans = 0;

        if(c1 == c2 || c2 == '.')
        {
            ans = ismatch(A, B, i-1, j-1, dp);
        }
        else if(c2 == '*')
        {
            if(j>=1 && (c1 == B.charAt(j-1) || B.charAt(j-1) == '.'))
            {
                ans = ismatch(A, B, i-1, j, dp) | ismatch(A, B, i, j-2, dp);
            }
            else if(j >= 1 && c1 != B.charAt(j-1))
            {
                ans = ismatch(A, B, i, j-2, dp);
            }
        }

        return dp[i][j] = ans;
    }
}
