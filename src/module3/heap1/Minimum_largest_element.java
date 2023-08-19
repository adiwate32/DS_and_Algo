package module3.heap1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add the original value(value stored at the index before we did any operations) to its current value. You can choose any of the N elements in each operation.
 Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
 Find the minimum possible largest element after B operations.

 Problem Constraints
 1 <= N <= 106
 0 <= B <= 105
 -105 <= A[i] <= 105

 Input Format
 The first argument is an integer array A.
 The second argument is an integer B.

 Output Format
 Return an integer denoting the minimum possible largest element after B operations.

 Example Input
 Input 1:
 A = [1, 2, 3, 4]
 B = 3
 Input 2:
 A = [5, 1, 4, 2]
 B = 5

 Example Output
 Output 1:
 4
 Output 2:
 5

 Example Explanation
 Explanation 1:
 Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
 Minimum possible largest element after 3 operations is 4.
 Explanation 2:
 Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
 Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
 Minimum possible largest element after 5 operations is 5.
 */
class Pair
{
    int org;
    int mod;
    Pair(int org, int mod)
    {
        this.mod = mod;
        this.org = org;
    }

}

public class Minimum_largest_element {
    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (a.org + a.mod)));

        for(int a: A)
        {
            pq.add(new Pair(a, a));
        }

        for(int i=0; i<B; i++)
        {
            Pair p = pq.poll();
            pq.add(new Pair(p.org, p.org+p.mod));
        }

        int max = Integer.MIN_VALUE;
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            max = Math.max(max, p.mod);
        }

        return max;
    }
}
