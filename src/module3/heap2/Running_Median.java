package module3.heap2;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
 Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.

 Find and return the array C.
 NOTE:
 If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
 If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).

 Problem Constraints
 1 <= length of the array <= 100000
 1 <= A[i] <= 109

 Input Format
 The only argument given is the integer array A.

 Output Format
 Return an integer array C, C[i] denotes the median of the first i elements.

 Example Input
 Input 1:
 A = [1, 2, 5, 4, 3]
 Input 2:
 A = [5, 17, 100, 11]

 Example Output
 Output 1:
 [1, 1, 2, 2, 3]
 Output 2:
 [5, 5, 17, 11]

 Example Explanation
 Explanation 1:
 stream          median
 [1]             1
 [1, 2]          1
 [1, 2, 5]       2
 [1, 2, 5, 4]    2
 [1, 2, 5, 4, 3] 3
 Explanation 2:
 stream          median
 [5]              5
 [5, 17]          5
 [5, 17, 100]     17
 [5, 17, 100, 11] 11
 */
public class Running_Median {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> h2 = new PriorityQueue<>();
        PriorityQueue<Integer> h1 = new PriorityQueue<>((a, b) -> b-a);

        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();

        h1.add(A.get(0));
        ans.add(A.get(0));

        for(int i=1; i<n; i++)
        {
            int val = A.get(i);
            if(val > h1.peek())
            {
                h2.add(val);
            }
            else
            {
                h1.add(val);
            }

            int diff = Math.abs(h1.size() - h2.size());
            if(diff > 1)
            {
                balance(h1, h2);
            }

            if(h2.size() > h1.size())
            {
                ans.add(h2.peek());
            }
            else
            {
                ans.add(h1.peek());
            }
        }
        return ans;
    }

    public void balance(PriorityQueue<Integer> h1, PriorityQueue<Integer> h2)
    {
        if(h1.size() > h2.size())
        {
            h2.add(h1.remove());
        }
        else{
            h1.add(h2.remove());
        }
    }
}
