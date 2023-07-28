package module3.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 Given an array A of both positive and negative integers.
 Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
 NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.

 Problem Constraints
 1 <= size of array A <= 105
 -109 <= A[i] <= 109
 1 <= B <= size of array

 Input Format
 The first argument denotes the integer array A.
 The second argument denotes the value B

 Output Format
 Return an integer that denotes the required value.

 Example Input
 Input 1:
 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4
 Input 2:
 A = [2, -1, 3]
 B = 2

 Example Output
 Output 1:
 18
 Output 2:
 3

 Example Explanation
 Explanation 1:
 Subarrays of size 4 are :
 [2, 5, -1, 7],   min + max = -1 + 7 = 6
 [5, -1, 7, -3],  min + max = -3 + 7 = 4
 [-1, 7, -3, -1], min + max = -3 + 7 = 4
 [7, -3, -1, -2], min + max = -3 + 7 = 4
 Sum of all min & max = 6 + 4 + 4 + 4 = 18
 Explanation 2:
 Subarrays of size 2 are :
 [2, -1],   min + max = -1 + 2 = 1
 [-1, 3],   min + max = -1 + 3 = 2
 Sum of all min & max = 1 + 2 = 3
 */
public class Sum_of_min_and_max {
    public int solve(ArrayList<Integer> A, int B) {
        List<Integer> slidingedMaximum = slidingMaximum(A, B);
        List<Integer> slidingMinimum = slidingMinimum(A, B);
        int mod = 1000000007;

        long sum = 0;

        for(int i=0; i<slidingedMaximum.size(); i++)
        {
            sum = (sum + (slidingedMaximum.get(i) + slidingMinimum.get(i) + mod) % mod) % mod;
        }
        return (int)sum;
    }

    public List<Integer> slidingMinimum(final List<Integer> A, int B) {

        Deque<Integer> dq = new LinkedList<>();

        ArrayList<Integer> ans = new ArrayList<>();

        if(A.size() <= B)
        {
            ans.add(Collections.max(A));
            return ans;
        }

        for(int i=0; i<B; i++)
        {
            int x = A.get(i);
            while(!dq.isEmpty() && dq.getLast() > x)
            {
                dq.removeLast();
            }
            dq.addLast(x);
        }
        ans.add(dq.getFirst());
        int s = 1;
        int e = B;

        while(e < A.size())
        {
            int l = A.get(s-1);
            if(l == dq.getFirst())
            {
                dq.removeFirst();
            }

            int r = A.get(e);
            while(!dq.isEmpty() && dq.getLast() > r)
            {
                dq.removeLast();
            }
            dq.addLast(r);
            ans.add(dq.getFirst());
            s += 1;
            e += 1;
        }

        return ans;
    }

    public List<Integer> slidingMaximum(final List<Integer> A, int B) {

        Deque<Integer> dq = new LinkedList<>();

        ArrayList<Integer> ans = new ArrayList<>();

        if(A.size() <= B)
        {
            ans.add(Collections.max(A));
            return ans;
        }

        for(int i=0; i<B; i++)
        {
            int x = A.get(i);
            while(!dq.isEmpty() && dq.getLast() < x)
            {
                dq.removeLast();
            }
            dq.addLast(x);
        }
        ans.add(dq.getFirst());
        int s = 1;
        int e = B;

        while(e < A.size())
        {
            int l = A.get(s-1);
            if(l == dq.getFirst())
            {
                dq.removeFirst();
            }

            int r = A.get(e);
            while(!dq.isEmpty() && dq.getLast() < r)
            {
                dq.removeLast();
            }
            dq.addLast(r);
            ans.add(dq.getFirst());
            s += 1;
            e += 1;
        }

        return ans;
    }
}
