package module4.graph3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
 You have to find an integer array D of size A such that:
 D[i]: Shortest distance from the C node to node i.
 If node i is not reachable from C then -1.
 Note:
 There are no self-loops in the graph.
 There are no multiple edges between two pairs of vertices.
 The graph may or may not be connected.
 Nodes are numbered from 0 to A-1.
 Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.

 Problem Constraints
 1 <= A <= 1e5
 0 <= B[i][0],B[i][1] < A
 0 <= B[i][2] <= 1e3
 0 <= C < A

 Input Format
 The first argument is an integer A, representing the number of nodes in the graph.
 The second argument is a matrix B of size M x 3, where each row represents an edge in the graph. The three columns of each row denote the source node B[i][0], the destination node B[i][1], and the weight of the edge B[i][2].
 The third argument is an integer C, representing the source node for which the shortest distance to all other nodes needs to be found.

 Output Format
 Return the integer array D.

 Example Input
 Input 1:
 A = 6
 B = [   [0, 4, 9]
 [3, 4, 6]
 [1, 2, 1]
 [2, 5, 1]
 [2, 4, 5]
 [0, 3, 7]
 [0, 1, 1]
 [4, 5, 7]
 [0, 5, 1] ]
 C = 4
 Input 2:
 A = 5
 B = [   [0, 3, 4]
 [2, 3, 3]
 [0, 1, 9]
 [3, 4, 10]
 [1, 3, 8]  ]
 C = 4

 Example Output
 Output 1:
 D = [7, 6, 5, 6, 0, 6]
 Output 2:
 D = [14, 18, 13, 10, 0]

 Example Explanation
 Explanation 1:
 All Paths can be considered from the node C to get shortest path
 Explanation 2:
 All Paths can be considered from the node C to get shortest path
 */
public class Dijsktra {
    private class Pair
    {
        int wt;
        int v;
        Pair(int v, int wt)
        {
            this.wt = wt;
            this.v = v;
        }
    }

    public int[] solve(int A, int[][] B, int C) {
        List<List<Pair>> graph = new ArrayList<>();

        for(int i=0; i<A; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<B.length; i++)
        {
            int src = B[i][0];
            int dest = B[i][1];
            int wt = B[i][2];

            graph.get(src).add(new Pair(dest, wt));
            graph.get(dest).add(new Pair(src, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.wt - b.wt));
        int[] dist = new int[A];
        Arrays.fill(dist, -1);

        dist[C] = 0;
        for(Pair rp: graph.get(C))
        {
            pq.add(rp);
        }

        while(!pq.isEmpty())
        {
            Pair rp = pq.poll();
            if(dist[rp.v] != -1) continue;
            else
            {
                dist[rp.v] = rp.wt;
                for(Pair nei: graph.get(rp.v))
                {
                    if(dist[rp.v] != -1) pq.add(new Pair(nei.v, nei.wt+rp.wt));
                }
            }
        }
        return dist;
    }
}
