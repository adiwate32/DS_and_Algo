package module4.dp1;

/**
 You are climbing a staircase and it takes A steps to reach the top.
 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 Return the number of distinct ways modulo 1000000007

 Problem Constraints
 1 <= A <= 105

 Input Format
 The first and the only argument contains an integer A, the number of steps.

 Output Format
 Return an integer, representing the number of ways to reach the top.

 Example Input
 Input 1:
 A = 2
 Input 2:
 A = 3

 Example Output
 Output 1:
 2
 Output 2:
 3

 Example Explanation
 Explanation 1:
 Distinct ways to reach top: [1, 1], [2].
 Explanation 2:
 Distinct ways to reach top: [1 1 1], [1 2], [2 1].
 */
public class Stairs {
    public int climbStairs(int A) {

        int mod = 1000000007;

        long[] dp = new long[A+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=A; i++)
        {
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }

        return (int)dp[A];
    }
}
