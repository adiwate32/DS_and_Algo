package module3.stack2;

import java.util.Stack;

/**
 Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
 Find the largest rectangle containing only 1's and return its area.
 Note: Rows are numbered from top to bottom and columns are numbered from left to right.

 Input Format
 The only argument given is the integer matrix A.

 Output Format
 Return the area of the largest rectangle containing only 1's.

 Constraints
 1 <= N, M <= 1000
 0 <= A[i] <= 1

 For Example
 Input 1:
 A = [   [0, 0, 1]
 [0, 1, 1]
 [1, 1, 1]   ]
 Output 1:
 4

 Input 2:
 A = [   [0, 1, 0, 1]
 [1, 0, 1, 0]    ]
 Output 2:
 1
 */
public class Maximum_Rectangle {
    public int solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        int[] hist = new int[m];

        int ans = 0;

        for (int[] ints : A) {
            for (int j = 0; j < m; j++) {
                if (ints[j] == 1) {
                    hist[j] += ints[j];
                } else {
                    hist[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea(hist));
        }

        return ans;
    }

    public int largestRectangleArea(int[] A) {

        int n = A.length;
        int[] left = nearest_left(A, n);
        int[] right = nearest_right(A, n);

        int max_ans = 0;
        for(int i=0; i<n; i++)
        {
            max_ans = Math.max(max_ans, A[i] * (right[i] - left[i] - 1));
        }

        return max_ans;
    }

    public int[] nearest_left(int[] A, int n)
    {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++)
        {
            while(!st.isEmpty() && A[st.peek()] >= A[i])
            {
                st.pop();
            }

            if(!st.isEmpty())
            {
                ans[i] = st.peek();
            }
            else
            {
                ans[i] = -1;
            }
            st.push(i);
        }

        return ans;
    }

    public int[] nearest_right(int[] A, int n)
    {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--)
        {
            while(!st.isEmpty() && A[st.peek()] >= A[i])
            {
                st.pop();
            }

            if(!st.isEmpty())
            {
                ans[i] = st.peek();
            }
            else
            {
                ans[i] = n;
            }
            st.push(i);
        }

        return ans;
    }
}
