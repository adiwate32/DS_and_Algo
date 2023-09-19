package module4.graph2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 There are a total of A courses you have to take, labeled from 1 to A.
 Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
 So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.

 Problem Constraints
 1 <= A <= 6*104
 1 <= length(B) = length(C) <= 105
 1 <= B[i], C[i] <= A

 Input Format
 The first argument of input contains an integer A, representing the number of courses.
 The second argument of input contains an integer array, B.
 The third argument of input contains an integer array, C.

 Output Format
 Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.

 Example Input
 Input 1:
 A = 3
 B = [1, 2]
 C = [2, 3]
 Input 2:
 A = 2
 B = [1, 2]
 C = [2, 1]

 Example Output
 Output 1:
 1
 Output 2:
 0
 */
public class Possibility_of_Finishing {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<=A; i++)
        {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[A+1];

        for(int i=0; i<B.size(); i++)
        {
            int u = B.get(i);
            int v = C.get(i);

            graph.get(u).add(v);

            indegree[v] ++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;

        for(int i=1; i<=A; i++)
        {
            if(indegree[i] == 0)
            {
                pq.add(i);
            }
        }

        while(!pq.isEmpty())
        {
            int src = pq.poll();
            cnt ++;
            for(int nei: graph.get(src))
            {
                indegree[nei] -= 1;
                if(indegree[nei] == 0) pq.add(nei);
            }
        }

        return cnt == A ? 1 : 0;
    }
}
