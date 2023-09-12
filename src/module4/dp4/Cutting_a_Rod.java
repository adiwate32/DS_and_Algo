package module4.dp4;

import java.util.Arrays;

/**
 Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.
 Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.

 Problem Constraints
 1 <= N <= 1000
 0 <= A[i] <= 106

 Input Format
 First and only argument is an integer array A of size N.

 Output Format
 Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.

 Example Input
 Input 1:
 A = [3, 4, 1, 6, 2]
 Input 2:
 A = [1, 5, 2, 5, 6]

 Example Output
 Output 1:
 15
 Output 2:
 11

 Example Explanation
 Explanation 1:
 Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.
 Explanation 2:
 Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.
 */
public class Cutting_a_Rod {

    //iterative method
    public int solve(int[] A) {

        int n = A.length;
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++)
        {
            int ans = 0;
            for(int j=1; j<=i; j++)
            {
                ans = Math.max(ans, A[j-1] + dp[i-j]);
            }
            dp[i] = ans;
        }

        return dp[n];
    }

    //recursive method
    public int solve1(int[] A) {
        int size = A.length;
        int [] dp = new int[size +1];
        Arrays.fill(dp , -1);
        return cutting(size , A , dp);
    }
    public  int cutting(int size , int [] A , int[] dp){
        if(size == 0) return 0;
        if(dp[size] != -1) return dp[size];
        int ans = 0 ;
        for(int i =1 ; i <= size ; i++){
            ans = Math.max(ans , A[i-1] + cutting(size -i , A , dp));
        }return dp[size] = ans;
    }
}
