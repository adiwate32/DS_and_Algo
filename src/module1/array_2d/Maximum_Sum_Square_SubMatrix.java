package module1.array_2d;

/**
 Given a 2D integer matrix A of size N x N, find a B x B sub-matrix where B<= N and B>= 1, such that the sum of all the elements in the submatrix is maximum.

 Problem Constraints
 1 <= N <= 103.
 1 <= B <= N
 -102 <= A[i][j] <= 102.

 Input Format
 First argument is an 2D integer matrix A.
 Second argument is an integer B.

 Output Format
 Return a single integer denoting the maximum sum of sub-matrix of size B x B.

 Example Input
 Input 1:
 A = [[1, 1, 1, 1, 1]
 [2, 2, 2, 2, 2]
 [3, 8, 6, 7, 3]
 [4, 4, 4, 4, 4]
 [5, 5, 5, 5, 5]]
 B = 3
 Input 2:
 A = [[2, 2]
 [2, 2]]
 B = 2

 Example Output  1:
 48
 Output 2:
 8

 Example Explanation  1:
 Maximum sum 3 x 3 matrix is
 8 6 7
 4 4 4
 5 5 5
 Sum = 48
 Explanation 2:
 Maximum sum 2 x 2 matrix is
 2 2
 2 2
 Sum = 8
 */
public class Maximum_Sum_Square_SubMatrix {
    public int solve(int[][] A, int B) {
        int n = A.length;

        int [][] psum = new int[n][n];

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
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
            for(int j=0; j<n; j++)
            {
                psum[i][j] += psum[i-1][j];
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i=0; i<n-B+1; i++)
        {
            for(int j=0; j<n-B+1; j++)
            {
                int bl = i+B-1;
                int br = j+B-1;

                int sum = psum[bl][br];

                if(j>0)
                {
                    sum -= psum[bl][j-1];
                }

                if(i>0)
                {
                    sum -= psum[i-1][br];
                }

                if(i>0 && j>0)
                {
                    sum += psum[i-1][j-1];
                }
                ans = Math.max(ans, sum);

            }
        }
        return ans;
    }
}
