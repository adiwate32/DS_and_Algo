package module4.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.
 B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.
 Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.
 NOTE:
 You can start buying from time = 0.
 Return your answer modulo 109 + 7.

 Problem Constraints
 1 <= N <= 105
 1 <= A[i] <= 109
 0 <= B[i] <= 109

 Input Format
 The first argument is an integer array A represents the deadline for buying the cars.
 The second argument is an integer array B represents the profit obtained after buying the cars.

 Output Format
 Return an integer denoting the maximum profit you can earn.

 Example Input
 Input 1:
 A = [1, 3, 2, 3, 3]
 B = [5, 6, 1, 3, 9]
 Input 2:
 A = [3, 8, 7, 5]
 B = [3, 1, 7, 19]

 Example Output
 Output 1:
 20
 Output 2:
 30

 Example Explanation
 Explanation 1:
 At time 0, buy car with profit 5.
 At time 1, buy car with profit 6.
 At time 2, buy car with profit 9.
 At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
 So, total profit that one can earn is 20.
 Explanation 2:
 At time 0, buy car with profit 3.
 At time 1, buy car with profit 1.
 At time 2, buy car with profit 7.
 At time 3, buy car with profit 19.
 We are able to buy all cars within their deadline. So, total profit that one can earn is 30.
 */
public class Free_Cars {
    private static class Pair
    {
        int t;
        int p;

        Pair(int t, int p)
        {
            this.t = t;
            this.p = p;
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int t = 0;
        long ans = 0;
        int mod = 1000000007;
        ArrayList<Pair> lp = new ArrayList<>();
        int n = A.size();

        for(int i=0; i<n; i++)
        {
            lp.add(new Pair(A.get(i), B.get(i)));
        }

        lp.sort(new customComparator());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++)
        {
            Pair p = lp.get(i);
            if(t < p.t)
            {
                pq.add(p.p);
                t += 1;
            }
            else
            {
                if(p.p > pq.peek())
                {
                    pq.poll();
                    pq.add(p.p);
                }
            }
        }

        while(!pq.isEmpty())
        {
            ans = (ans + pq.poll()) % mod;
        }
        return (int)ans;
    }

    private static class customComparator implements Comparator<Pair>
    {
        public int compare(Pair a, Pair b)
        {
            return a.t - b.t;
        }
    }
}
