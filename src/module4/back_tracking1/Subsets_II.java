package module4.back_tracking1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.
 NOTE:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 The subsets must be sorted lexicographically.

 Problem Constraints
 0 <= N <= 16

 Input Format
 Only argument is an integer array A of size N.

 Output Format
 Return a 2-D vector denoting all the possible subsets.

 Example Input
 Input 1:
 A = [1, 2, 2]
 Input 2:
 A = [1, 1]

 Example Output
 Output 1:
 [
 [],
 [1],
 [1, 2],
 [1, 2, 2],
 [2],
 [2, 2]
 ]
 Output 2:
 [
 [],
 [1],
 [1, 1]
 ]

 Example Explanation
 Explanation 1:
 All the subsets of the array [1, 2, 2] in lexicographically sorted order.
 */
public class Subsets_II {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        subset(A, 0, new ArrayList<>());
        ans.sort((a, b) ->
        {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                if (!Objects.equals(a.get(i), b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return a.size() - b.size();
        });
        return ans;
    }

    public void subset(ArrayList<Integer> A, int i, ArrayList<Integer> res)
    {
        if(i == A.size())
        {
            ans.add(new ArrayList<>(res));
            return;
        }

        res.add(A.get(i));
        subset(A, i+1, res);
        res.remove(res.size()-1);

        while(i+1 < A.size() && Objects.equals(A.get(i), A.get(i + 1)))
        {
            i++;
        }

        subset(A, i+1, res);
    }
}
