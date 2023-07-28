package module3.stack2;

import java.util.Stack;

/**
 Given an array of integers A.
 A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
 Find the area of the largest rectangle formed by the histogram.

 Problem Constraints
 1 <= |A| <= 100000
 1 <= A[i] <= 10000

 Input Format
 The only argument given is the integer array A.

 Output Format
 Return the area of the largest rectangle in the histogram.

 Example Input
 Input 1:
 A = [2, 1, 5, 6, 2, 3]
 Input 2:
 A = [2]

 Example Output
 Output 1:
 10
 Output 2:
 2

 Example Explanation
 Explanation 1:
 The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
 Explanation 2:
 Largest rectangle has area 2.
 */
public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] A) {

        int n = A.length;
        int[] left = nearest_left(A, n);
        int[] right = nearest_right(A, n);

        int maxAns = 0;
        for(int i=0; i<n; i++)
        {
            maxAns = Math.max(maxAns, A[i] * (right[i] - left[i] - 1));
        }

        return maxAns;
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
