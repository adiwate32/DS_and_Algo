package module4.dp6;

/**
 Given a string A consisting of lowercase English alphabets. Your task is to find how many substrings of A are palindrome.
 The substrings with different start indexes or end indexes are counted as different substrings even if they consist of same characters.
 Return the count of palindromic substrings.
 Note: A string is palindrome if it reads the same from backward and forward.

 Input Format
 The only argument given is string A.
 Output Format
 Return the count of palindromic substrings.
 Constraints
 1 <= length of the array <= 1000
 For Example
 Input 1:
 A = "abab"
 Output 1:
 6
 Explanation 1:
 6 palindromic substrings are:
 "a", "aba", "b", "bab", "a" and "b".

 Input 2:
 A = "ababa"
 Output 2:
 9
 Explanation 9:
 9 palindromic substrings are:
 "a", "a", "a", "b", "b" , "aba" ,"bab", "aba" and "ababa".
 */
public class Palindromic_Substrings_Count {
    public int solve(String A) {
        int n = A.length();
        int[][] dp = new int[n][n];
        int cnt = 0;

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

                if(dp[r][c] == 1) cnt ++;

                r++;
                c++;
            }
        }

        return cnt;
    }
}
