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
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] left = nextSmallerLeft(heights, n);
        int[] right = nextSmallerRight(heights, n);

        int ans = 0;

        for(int i=0; i<n; i++)
        {
            int width = right[i] - left[i] - 1; // width of rectangle is between smaller nearest right and smaller nearest left
            ans = Math.max(ans, width * (heights[i]));
        }

        return ans;
    }

    public int[] nextSmallerLeft(int[] h, int n)
    {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++)
        {
            while(!st.isEmpty() && h[i] <= h[st.peek()])
            {
                st.pop(); //removing all the elements from st which are greater than curr on left end
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

    public int[] nextSmallerRight(int[] h, int n)
    {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--)
        {
            while(!st.isEmpty() && h[i] <= h[st.peek()])
            {
                st.pop(); //removing all the elements from st which are greater than curr on right end
            }

            if(!st.isEmpty())
            {
                ans[i] = st.peek();
            }
            else
            {
                ans[i] = n; //adding n to handle corner test case
            }

            st.push(i);
        }

        return ans;
    }
}
