package module4.dp6;

/**
 Given a string A, partition A such that every substring of the partition is a palindrome.
 Return the minimum cuts needed for a palindrome partitioning of A.

 Problem Constraints
 1 <= length(A) <= 501

 Input Format
 The first and the only argument contains the string A.

 Output Format
 Return an integer, representing the minimum cuts needed.

 Example Input
 Input 1:
 A = "aba"
 Input 2:
 A = "aab"

 Example Output
 Output 1:
 0
 Output 2:
 1

 Example Explanation
 Explanation 1:
 "aba" is already a palindrome, so no cuts are needed.
 Explanation 2:
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class Palindrome_Partitioning_II {
    public int minCut(String A) {
        int n = A.length();
        int[][] dp1 = new int[n][n];
        dp1 = iterative(A, n, dp1);

        int[] dp2 = new int[n];
        for(int i=0; i<n; i++)
        {
            if(checkPalindrome(dp1, 0, i)) dp2[i] = 0;
            else{
                int min = Integer.MAX_VALUE;
                for(int cut = i; cut >= 0; cut --)
                {
                    if(checkPalindrome(dp1, cut, i))
                    {
                        min = Math.min(min, dp2[cut-1]);
                    }
                }
                dp2[i] = min + 1;
            }
        }

        return dp2[n-1];
    }

    public boolean checkPalindrome(int[][] dp, int s, int e)
    {
        return dp[s][e] == 1;
    }

    public int[][] iterative(String A, int n, int[][] dp)
    {
        for(int d=0; d<n; d++)
        {
            int r = 0;
            int c = d;

            while(c < n)
            {
                if(d == 0) dp[r][c] = 1;
                else if(d == 1)
                {
                    char c1 = A.charAt(r);
                    char c2 = A.charAt(c);

                    if(c1 == c2) dp[r][c] = 1;
                }
                else
                {
                    char c1 = A.charAt(r);
                    char c2 = A.charAt(c);

                    if(c1 == c2) dp[r][c] = dp[r+1][c-1];
                }

                r++;
                c++;
            }
        }

        return dp;
    }
}
