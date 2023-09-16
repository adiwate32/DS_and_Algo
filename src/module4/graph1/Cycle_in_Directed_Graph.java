package module4.graph1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

 NOTE:
 The cycle must contain atleast two nodes.
 There are no self-loops in the graph.
 There are no multiple edges between two nodes.
 The graph may or may not be connected.
 Nodes are numbered from 1 to A.
 Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

 Problem Constraints
 2 <= A <= 105
 1 <= M <= min(200000,A*(A-1))
 1 <= B[i][0], B[i][1] <= A

 Input Format
 The first argument given is an integer A representing the number of nodes in the graph.
 The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

 Output Format
 Return 1 if cycle is present else return 0.

 Example Input
 Input 1:
 A = 5
 B = [  [1, 2]
 [4, 1]
 [2, 4]
 [3, 4]
 [5, 2]
 [1, 3] ]
 Input 2:
 A = 5
 B = [  [1, 2]
 [2, 3]
 [3, 4]
 [4, 5] ]

 Example Output
 Output 1:
 1
 Output 2:
 0

 Example Explanation
 Explanation 1:
 The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
 Explanation 2:
 The given graph doesn't contain any cycle.
 */
public class Cycle_in_Directed_Graph {
    public int solve(int A, int[][] B) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<=A; i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<B.length; i++)
        {
            int u = B[i][0];
            int v = B[i][1];

            graph.get(u).add(v);
        }

        boolean[] vis = new boolean[A+1];
        boolean[] path = new boolean[A+1];

        for(int i=1; i<=A; i++)
        {
            if(!vis[i])
            {
                if(dfs(graph, i, vis, path))
                {
                    return 1;
                }
            }
        }

        return 0;

    }

    private boolean dfs(List<List<Integer>> graph, int src, boolean[] vis, boolean[] path)
    {
        vis[src] = true;
        path[src] = true;

        for(int nei: graph.get(src))
        {
            if(path[nei])
            {
                return true;
            }
            else
            {
                if(!vis[nei] && dfs(graph, nei, vis, path))
                {
                    return true;
                }
            }
        }
        path[src] = false;

        return false;
    }

    private boolean bfs(List<List<Integer>> graph, int src, boolean[] vis, boolean[] path)
    {
        Deque<Integer> queue = new LinkedList<>();

        vis[src] = true;
        path[src] = true;
        queue.offer(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int nei : graph.get(node)) {
                if (path[nei]) {
                    return true;
                }

                if (!vis[nei]) {
                    vis[nei] = true;
                    path[nei] = true;
                    queue.offer(nei);
                }
            }

            path[node] = false;
        }

        return false;
    }
}
