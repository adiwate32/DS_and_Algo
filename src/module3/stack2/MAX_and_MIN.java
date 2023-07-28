package module3.stack2;

import java.util.Stack;

/**
 Given an array of integers A.
 The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.
 Calculate and return the sum of values of all possible subarrays of A modulo 109+7.

 Problem Constraints
 1 <= |A| <= 100000
 1 <= A[i] <= 1000000

 Input Format
 The first and only argument given is the integer array A.

 Output Format
 Return the sum of values of all possible subarrays of A modulo 109+7.

 Example Input
 Input 1:
 A = [1]
 Input 2:
 A = [4, 7, 3, 8]

 Example Output
 Output 1
 0
 Output 2:
 26

 Example Explanation
 Explanation 1:
 Only 1 subarray exists. Its value is 0.
 Explanation 2:
 value ( [4] ) = 4 - 4 = 0
 value ( [7] ) = 7 - 7 = 0
 value ( [3] ) = 3 - 3 = 0
 value ( [8] ) = 8 - 8 = 0
 value ( [4, 7] ) = 7 - 4 = 3
 value ( [7, 3] ) = 7 - 3 = 4
 value ( [3, 8] ) = 8 - 3 = 5
 value ( [4, 7, 3] ) = 7 - 3 = 4
 value ( [7, 3, 8] ) = 8 - 3 = 5
 value ( [4, 7, 3, 8] ) = 8 - 3 = 5
 sum of values % 10^9+7 = 26
 */
public class MAX_and_MIN {
    public int solve(int[] A) {
        int n = A.length;
        int[] s_left = nearest_small_left(A, n);
        int[] s_right = nearest_small_right(A, n);

        int[] g_left = nearest_great_left(A, n);
        int[] g_right = nearest_great_right(A, n);
        int mod = 1000000007;

        long ans = 0;

        for(int i=0; i<n; i++)
        {
            long max = ((long) (s_right[i] - i) * (i - s_left[i]));
            long min = ((long) (g_right[i] - i) * (i - g_left[i]));
            ans = (ans + (A[i] * (min - max + mod)) % mod) % mod;
        }
        return (int)ans % mod;
    }

    public int[] nearest_small_left(int[] A, int n)
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

    public int[] nearest_small_right(int[] A, int n)
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

    public int[] nearest_great_left(int[] A, int n)
    {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++)
        {
            while(!st.isEmpty() && A[st.peek()] <= A[i])
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

    public int[] nearest_great_right(int[] A, int n)
    {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--)
        {
            while(!st.isEmpty() && A[st.peek()] <= A[i])
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
