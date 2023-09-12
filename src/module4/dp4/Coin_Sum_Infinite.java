package module4.dp4;

import java.util.Arrays;

/**
 You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.
 NOTE:
 Coins in set A will be unique. Expected space complexity of this problem is O(B).
 The answer can overflow. So, return the answer % (106 + 7).

 Problem Constraints
 1 <= A <= 500
 1 <= A[i] <= 1000
 1 <= B <= 50000

 Input Format
 First argument is an integer array A representing the set.
 Second argument is an integer B.

 Output Format
 Return an integer denoting the number of ways.

 Example Input
 Input 1:
 A = [1, 2, 3]
 B = 4
 Input 2:
 A = [10]
 B = 10

 Example Output
 Output 1:
 4
 Output 2:
 1

 Example Explanation
 Explanation 1:
 The 4 possible ways are:
 {1, 1, 1, 1}
 {1, 1, 2}
 {2, 2}
 {1, 3}
 Explanation 2:
 There is only 1 way to make sum 10.
 */
public class Coin_Sum_Infinite {
    int mod = 1000007;
    public int coinchange2(int[] A, int B) {
        int n = A.length;
        int[][] dp = new int[n+1][B + 1];

        for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1);
        return knapsack(A, n, B, dp);
    }

    private int knapsack(int[] A, int n, int sum, int[][] dp)
    {
        if(sum == 0)
        {
            return 1;
        }

        if(n == 0)
        {
            return 0;
        }

        if(dp[n][sum] != -1) return dp[n][sum];

        int rej = knapsack(A, n-1, sum, dp);
        int sel = 0;
        if(A[n-1] <= sum)
        {
            sel = knapsack(A, n, sum - A[n-1], dp);
        }

        dp[n][sum] = (rej  + sel) % mod;

        return dp[n][sum];
    }
}
