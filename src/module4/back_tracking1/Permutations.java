package module4.back_tracking1;

import java.util.ArrayList;

/**
 Given an integer array A of size N denoting collection of numbers , return all possible permutations.
 NOTE:
 No two entries in the permutation sequence should be the same.
 For the purpose of this problem, assume that all the numbers in the collection are unique.
 Return the answer in any order
 WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 Example : next_permutations in C++ / itertools.permutations in python.
 If you do, we will disqualify your submission retroactively and give you penalty points.

 Problem Constraints
 1 <= N <= 9

 Input Format
 Only argument is an integer array A of size N.

 Output Format
 Return a 2-D array denoting all possible permutation of the array.

 Example Input
 A = [1, 2, 3]

 Example Output
 [ [1, 2, 3]
 [1, 3, 2]
 [2, 1, 3]
 [2, 3, 1]
 [3, 1, 2]
 [3, 2, 1] ]

 Example Explanation
 All the possible permutation of array [1, 2, 3].
 */
public class Permutations {
    boolean[] vis;
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        int n = A.size();
        vis = new boolean[n];
        ArrayList<Integer> res = new ArrayList<>();
        permutation(res, A, 0, n);
        return ans;
    }
    public void permutation(ArrayList<Integer> res, ArrayList<Integer> A, int idx, int n)
    {
        if(idx == n)
        {
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i=0; i<n; i++)
        {
            if(!vis[i])
            {
                vis[i] = true;
                res.add(A.get(i));
                permutation(res, A, idx+1, n);
                res.remove(res.size()-1);
                vis[i] = false;
            }
        }
    }
}
