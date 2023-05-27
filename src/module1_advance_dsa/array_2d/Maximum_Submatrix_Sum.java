package module1_advance_dsa.array_2d;

/**
 Given a row-wise and column-wise sorted matrix A of size N * M.
 Return the maximum non-empty sub-matrix sum of this matrix.

 Problem Constraints
 1 <= N, M <= 1000
 -109 <= A[i][j] <= 109

 Input Format
 The first argument is a 2D integer array A.

 Output Format
 Return a single integer that is the maximum non-empty sub-matrix sum of this matrix.

 Example Input
 Input 1:-
     -5 -4 -3
 A = -1  2  3
      2  2  4
 Input 2:-
     1 2 3
 A = 4 5 6
     7 8 9


 Example Output
 1:-
 12
 Output 2:-
 45

 Example Explanation
 Expanation 1:-
 The submatrix with max sum is
 -1 2 3
 2 2 4
 Sum is 12.
 Explanation 2:-
 The largest submatrix with max sum is
 1 2 3
 4 5 6
 7 8 9
 The sum is 45.
 */

/**
 prefix sum approach when row and column is sorted then definitely last ele needs to be present
 TC: O(n2)
 SC: O(n2)
 */
public class Maximum_Submatrix_Sum {
    public long solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        long [][] psum = new long[n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(j==0)
                {
                    psum[i][j] = A[i][j];
                }
                else
                {
                    psum[i][j] = psum[i][j-1] + A[i][j];
                }
            }
        }

        for(int i=1; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                psum[i][j] += psum[i-1][j];
            }
        }

        long ans = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                long sum = psum[n-1][m-1];
                if(i > 0)
                {
                    sum -= psum[i-1][m-1];
                }
                if(j>0)
                {
                    sum -= psum[n-1][j-1];
                }
                if (i>0 && j >0)
                {
                    sum += psum[i-1][j-1];
                }
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
