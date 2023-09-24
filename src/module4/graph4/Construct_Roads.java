package module4.graph4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 A country consist of N cities connected by N - 1 roads. King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.
 Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way, that for each road (u, v) that belongs to the country, u and v belong to different sets. Also, there should be no multiple roads between two cities and no self loops.
 Return the maximum number of roads king can construct. Since the answer could be large return answer % 109 + 7.
 NOTE: All cities can be visited from any city.

 Problem Constraints
 1 <= A <= 105
 1 <= B[i][0], B[i][1] <= N

 Input Format
 First argument is an integer A denoting the number of cities, N.
 Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e. there is a road between cities B[i][0] and B[1][1] .

 Output Format
 Return an integer denoting the maximum number of roads king can construct.

 Example Input
 Input 1:
 A = 3
 B = [
 [1, 2]
 [1, 3]
 ]
 Input 2:
 A = 5
 B = [
 [1, 3]
 [1, 4]
 [3, 2]
 [3, 5]
 ]

 Example Output
 Output 1:
 0
 Output 2:
 2

 Example Explanation
 Explanation 1:
 We can't construct any new roads such that the country remains bipartite.
 Explanation 2:
 We can add two roads between cities (4, 2) and (4, 5).
 */
public class Construct_Roads {
    int mod = 1000000007;
    public int solve(int A, int[][] B) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<=A; i++) graph.add(new ArrayList<>());

        for(int i=0; i<B.length; i++)
        {
            int u = B[i][0];
            int v = B[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] clr = new int[A+1];
        Arrays.fill(clr, -1);

        clr[1] = 0;
        long clr_0 = 0;
        long clr_1 = 0;

        if(dfs(graph, clr, 1))
        {
            for(int i=1; i<=A; i++)
            {
                if(clr[i] == 0) clr_0++;
                else clr_1++;
            }

            return (int)((clr_1 % mod * clr_0 % mod) % mod - A + 1);
        }

        return 0;
    }

    public boolean dfs(List<List<Integer>> graph, int[] clr, int src)
    {
        for(int nei: graph.get(src))
        {
            if(clr[src] == clr[nei]) return false;
            if(clr[nei] == -1)
            {
                clr[nei] = 1-clr[src];
                if(!dfs(graph, clr, nei)) return false;
            }
        }

        return true;
    }
}
