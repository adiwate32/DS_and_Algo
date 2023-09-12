package module4.dp3;

import java.util.Arrays;

/**
 As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune. Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).
 NOTE:
 Each dish is supposed to be eaten by only one person. Sharing is not allowed.
 Each friend can take any dish unlimited number of times.
 There always exists a dish with filling capacity 1 so that a solution always exists.

 Problem Constraints
 |A| <= 1000
 |B| <= 1000
 |C| <= 1000

 Input Format
 First Argument is vector A, denoting eating capacities
 Second Argument is vector B, denoting filling capacities
 Third Argument is vector C, denoting cost

 Output Format
 Return a single integer, the answer to the problem

 Example Input
 Input 1:
 A = [2, 4, 6]
 B = [2, 1, 3]
 C = [2, 5, 3]
 Input 2:
 A = [2]
 B = [1]
 C = [2]

 Example Output
 Output 1:
 12
 Output 2:
 4

 Example Explanation
 Explanation 1:
 First friend takes dish 1, Second friend takes dish 1 twice and third friend takes dish 3 twice.
 So 2 + 2*2 + 3*2 = 12.
 Explanation 2:
 Only way is to take 2 dishes of cost 2, hence 4.
 */
public class Tushar_Birthday_Party {
    public int solve(final int[] A, final int[] B, final int[] C) {

        int ans = 0;
        int n = B.length;

        int[][] dp = new int[n][1001];
        for(int a[]: dp) Arrays.fill(a, -1);

        for (int j : A) {

            ans += knapsack(0, j, B, C, dp);
        }
        return ans;
    }

    public int knapsack(int i, int val, int[] B, int[] C, int[][] dp)
    {
        if(val == 0)
        {
            return 0;
        }

        if(i == B.length)
        {
            return 100000000;
        }

        if(dp[i][val] != -1)
        {
            return dp[i][val];
        }

        int rej = knapsack(i+1, val, B, C, dp);
        int sel = 100000000;
        if(val >= B[i])
        {
            sel = C[i] + knapsack(i, val-B[i], B, C, dp);
        }
        dp[i][val] = Math.min(rej, sel);

        return dp[i][val];
    }
}
