package module4.dp2;

/**
 Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
 At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
 Now consider if some obstacles are added to the grids.
 Return the total number unique paths from (1, 1) to (n, m).
 Note: An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.

 Problem Constraints
 1 <= n, m <= 100
 A[i][j] = 0 or 1

 Input Format
 Firts and only argument A is a 2D array of size n * m.

 Output Format
 Return an integer denoting the number of unique paths from (1, 1) to (n, m).

 Example Input
 Input 1:
 A = [
 [0, 0, 0]
 [0, 1, 0]
 [0, 0, 0]
 ]
 Input 2:
 A = [
 [0, 0, 0]
 [1, 1, 1]
 [0, 0, 0]
 ]

 Example Output
 Output 1:
 2
 Output 2:
 0

 Example Explanation
 Explanation 1:
 Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}
 So, the total number of unique paths is 2.
 Explanation 2:
 It is not possible to reach (n, m) from (1, 1). So, ans is 0.
 */
public class Unique_Paths_in_a_Grid {
    public int uniquePathsWithObstacles(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        int [][] dp = new int[n][m];

        if(A[0][0] == 1)
        {
            return 0;
        }

        for(int i=0; i<n; i++)
        {
            if(A[i][0] == 0)
            {
                dp[i][0] = 1;
            }
            else
            {
                break;
            }
        }

        for(int i=0; i<m; i++)
        {
            if(A[0][i] == 0)
            {
                dp[0][i] = 1;
            }
            else
            {
                break;
            }
        }

        for(int i=1; i<n; i++)
        {
            for(int j=1; j<m; j++)
            {
                if(A[i][j] != 1)
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];
    }
}