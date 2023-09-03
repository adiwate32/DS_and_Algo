package module4.back_tracking1;

/**
 Given a matrix of integers A of size N x M . There are 4 types of squares in it:
 1. 1 represents the starting square.  There is exactly one starting square.
 2. 2 represents the ending square.  There is exactly one ending square.
 3. 0 represents empty squares we can walk over.
 4. -1 represents obstacles that we cannot walk over.
 Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 Note: Rows are numbered from top to bottom and columns are numbered from left to right.

 Problem Constraints
 2 <= N * M <= 20
 -1 <= A[i] <= 2

 Input Format
 The first argument given is the integer matrix A.

 Output Format
 Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 Example Input
 Input 1:
 A = [   [1, 0, 0, 0]
 [0, 0, 0, 0]
 [0, 0, 2, -1]   ]
 Input 2:
 A = [   [0, 1]
 [2, 0]    ]

 Example Output
 Output 1:
 2
 Output 2:
 0

 Example Explanation
 Explanation 1:
 We have the following two paths:
 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 Explanation 1:
 There are no such paths.
 */
public class Unique_Paths_III {
    int ans = 0;
    public int solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int s = -1;
        int e = -1;
        int zeroCnt = 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(A[i][j] == 1)
                {
                    s = i;
                    e = j;
                }

                if(A[i][j] == 0)
                {
                    zeroCnt ++;
                }
            }
        }

        backTrack(A, s, e, n, m, 0, zeroCnt);
        return ans;
    }

    public void backTrack(int[][] A, int r, int c, int rows, int cols, int pathLen, int zeroCnt)
    {

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        if(r < 0 || r >= rows || c < 0 || c >= cols || A[r][c] == -1)
        {
            return;
        }

        if(A[r][c] == 2)
        {
            if(pathLen == zeroCnt+1)
            {
                ans++;
            }
            return;
        }

        int temp = A[r][c];
        A[r][c] = -1;
        for(int i=0; i<4; i++)
        {
            backTrack(A, r + dx[i], c + dy[i], rows, cols, pathLen+1, zeroCnt);
        }
        A[r][c] = temp;
    }
}
