package module3.heap2;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 N people having different priorities are standing in a queue.
 The queue follows the property that each person is standing at most B places away from its position in the sorted queue.
 Your task is to sort the queue in the increasing order of priorities.
 NOTE:
 No two persons can have the same priority.
 Use the property of the queue to sort the queue with complexity O(NlogB).

 Problem Constraints
 1 <= N <= 100000
 0 <= B <= N

 Input Format
 The first argument is an integer array A representing the priorities and initial order of N persons.
 The second argument is an integer B.

 Output Format
 Return an integer array representing the sorted queue.

 Example Input
 Input 1:
 A = [1, 40, 2, 3]
 B = 2
 Input 2:
 A = [2, 1, 17, 10, 21, 95]
 B = 1

 Example Output
 Output 1:
 [1, 2, 3, 40]
 Output 2:
 [1, 2, 10, 17, 21, 95]

 Example Explanation
 Explanation 1:
 Given array A = [1, 40, 2, 3]
 After sorting, A = [1, 2, 3, 40].
 We can see that difference between initial position of elements amd the final position <= 2.
 Explanation 2:
 After sorting, the array becomes [1, 2, 10, 17, 21, 95].
 */
public class K_Places_Apart {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();

        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<B+1; i++)
        {
            pq.add(A.get(i));
        }

        for(int i=B+1; i<n; i++)
        {
            ans.add(pq.remove());
            pq.add(A.get(i));
        }

        while(!pq.isEmpty())
        {
            ans.add(pq.remove());
        }

        return ans;
    }
}
