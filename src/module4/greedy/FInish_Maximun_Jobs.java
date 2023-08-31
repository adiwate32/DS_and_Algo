package module4.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 There are N jobs to be done, but you can do only one job at a time.
 Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
 Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
 Return the maximum number of jobs you can finish.

 Problem Constraints
 1 <= N <= 105
 1 <= A[i] < B[i] <= 109

 Input Format
 The first argument is an integer array A of size N, denoting the start time of the jobs.
 The second argument is an integer array B of size N, denoting the finish time of the jobs.

 Output Format
 Return an integer denoting the maximum number of jobs you can finish.

 Example Input
 Input 1:
 A = [1, 5, 7, 1]
 B = [7, 8, 8, 8]
 Input 2:
 A = [3, 2, 6]
 B = [9, 8, 9]

 Example Output
 Output 1:
 2
 Output 2:
 1

 Example Explanation
 Explanation 1:
 We can finish the job in the period of time: (1, 7) and (7, 8).
 Explanation 2:
 Since all three jobs collide with each other. We can do only 1 job.
 */
public class FInish_Maximun_Jobs {
    private static class Pair
    {
        int s;
        int e;

        Pair(int s, int e)
        {
            this.s = s;
            this.e = e;
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        ArrayList<Pair> lp = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            lp.add(new Pair(A.get(i), B.get(i)));
        }

        lp.sort(new customComparator());

        int ans = 0;
        int prev_e = -1;

        for(int i=0; i<n; i++)
        {
            Pair p = lp.get(i);

            if(p.s >= prev_e)
            {
                ans ++;
                prev_e = p.e;
            }
        }

        return ans;
    }

    private static class customComparator implements Comparator<Pair>
    {
        public int compare(Pair a, Pair b)
        {
            return a.e - b.e;
        }
    }
}
