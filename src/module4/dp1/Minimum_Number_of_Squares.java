package module4.dp1;

/**
 Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.

 Problem Constraints
 1 <= A <= 105

 Input Format
 First and only argument is an integer A.

 Output Format
 Return an integer denoting the minimum count.

 Example Input
 Input 1:
 A = 6
 Input 2:
 A = 5

 Example Output
 Output 1:
 3
 Output 2:
 2

 Example Explanation
 Explanation 1:
 Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 Minimum count of numbers, sum of whose squares is 6 is 3.
 Explanation 2:
 We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
 */
public class Minimum_Number_of_Squares {
    public int countMinSquares(int A) {

        int[] dp = new int[A+1];

        dp[0] = 0;

        for(int i=1; i<=A; i++)
        {
            int ans = Integer.MAX_VALUE;
            for(int x = 1; x * x <= i; x++)
            {
                ans = Math.min(ans, dp[i-(x * x)]);
            }
            dp[i] = ans + 1;
        }

        return dp[A];
    }
}
