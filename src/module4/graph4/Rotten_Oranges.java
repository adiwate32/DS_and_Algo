package module4.graph4;

import java.util.Deque;
import java.util.LinkedList;

/**
 Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
 Each cell can have three values:
 The value 0 representing an empty cell.
 The value 1 representing a fresh orange.
 The value 2 representing a rotten orange.
 Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
 Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.

 Problem Constraints
 1 <= N, M <= 1000
 0 <= A[i][j] <= 2

 Input Format
 The first argument given is the integer matrix A.

 Output Format
 Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 If this is impossible, return -1 instead.

 Example Input
 Input 1:
 A = [   [2, 1, 1]
 [1, 1, 0]
 [0, 1, 1]   ]
 Input 2:
 A = [   [2, 1, 1]
 [0, 1, 1]
 [1, 0, 1]   ]

 Example Output
 Output 1:
 4
 Output 2:
 -1

 Example Explanation
 Explanation 1:
 Minute 0: [ [2, 1, 1]
 [1, 1, 0]
 [0, 1, 1] ]
 Minute 1: [ [2, 2, 1]
 [2, 1, 0]
 [0, 1, 1] ]
 Minute 2: [ [2, 2, 2]
 [2, 2, 0]
 [0, 1, 1] ]
 Minute 3: [ [2, 2, 2]
 [2, 2, 0]
 [0, 2, 1] ]
 Minute 4: [ [2, 2, 2]
 [2, 2, 0]
 [0, 2, 2] ]
 At Minute 4, all the oranges are rotten.
 Explanation 2:
 The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.
 */
public class Rotten_Oranges {
    private class Pair
    {
        int r;
        int c;
        Pair(int r, int c)
        {
            this.r = r;
            this.c = c;
        }
    }

    public int solve(int[][] A) {

        Deque<Pair> q = new LinkedList<>();
        int n = A.length;
        int m = A[0].length;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(A[i][j] == 2)
                {
                    q.addLast(new Pair(i, j));
                }
            }
        }

        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};

        int t=0;

        while(!q.isEmpty())
        {
            int sz = q.size();

            for(int i=1; i<=sz; i++)
            {
                Pair rp = q.removeFirst();
                int r = rp.r;
                int c = rp.c;

                for(int j=0; j<4; j++)
                {
                    int x = dx[j] + r;
                    int y = dy[j] + c;

                    if(x >= 0 && x < n && y >= 0 && y < m)
                    {
                        if(A[x][y] == 1)
                        {
                            A[x][y] = 2;
                            q.addLast(new Pair(x, y));
                        }
                    }
                }
            }

            t = t+1;
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(A[i][j] == 1)
                {
                    return -1;
                }
            }
        }

        return t-1;
    }
}
