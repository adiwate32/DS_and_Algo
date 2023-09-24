package module4.graph3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Another_BFS {
    public int solve(int A, int[][] B, int C, int D) {
//update input
        ArrayList<ArrayList<Integer>> input= new ArrayList<>();
        int dummy = A;
        for(int i = 0; i<B.length; i++) {
            int[] row = B[i];
            if(row[2] == 2) {
                input.add(new ArrayList<>(Arrays.asList(row[0], dummy)));
                input.add(new ArrayList<>(Arrays.asList(dummy, row[1])));
                dummy++;
            }
            else
                input.add(new ArrayList<>(Arrays.asList(row[0], row[1])));
        }


        ArrayList<Integer>[] adj = new ArrayList[dummy+1];
        for(int i = 0; i<dummy+1; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i<input.size(); i++) {
            ArrayList<Integer> curr = input.get(i);
            adj[curr.get(0)].add(curr.get(1));
            adj[curr.get(1)].add(curr.get(0));
        }
        boolean[] visited = new boolean[adj.length];
        int[] distances = new int[adj.length];
        Queue<Integer> q = new LinkedList<>();
        for(int[] row : B) {
            if(row[0] == C) {
                q.add(row[0]);
                visited[row[0]] = true;
            }
            else if(row[1] == C) {
                q.add(row[1]);
                visited[row[1]] = true;
            }
        }
        int counter = 0;

        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i = 0; i<sz; i++) {
                int val = q.remove();
                if(val == D)
                    return distances[val];

                for(int nbr : adj[val]) {
                    if(!visited[nbr]) {
                        visited[nbr] = true;
                        distances[nbr] = distances[val] + 1;
                        counter++;
                        q.add(nbr);
                    }
                }
            }
        }
        return -1;
    }
}
