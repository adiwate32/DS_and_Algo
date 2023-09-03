package module4.back_tracking1;

import java.util.ArrayList;
import java.util.Collections;

/**
 Given a set of distinct integers A, return all possible subsets.
 NOTE:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 Also, the subsets should be sorted in ascending ( lexicographic ) order.
 The initial list is not necessarily sorted.

 Problem Constraints
 1 <= |A| <= 16
 INTMIN <= A[i] <= INTMAX

 Input Format
 First and only argument of input contains a single integer array A.

 Output Format
 Return a vector of vectors denoting the answer.

 Example Input
 Input 1:
 A = [1]
 Input 2:
 A = [1, 2, 3]

 Example Output
 Output 1:
 [
 []
 [1]
 ]
 Output 2:
 [
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
 ]

 Example Explanation
 Explanation 1:
 You can see that these are all possible subsets.
 Explanation 2:
 You can see that these are all possible subsets.
 */
public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(A);
        permutation(new ArrayList<>(), A, 0, ans);
        ans.sort((x, y) ->
        {
            for(int i=0; i<Math.min(x.size(), y.size()); i++)
            {
                if(x.get(i) != y.get(i))
                {
                    return x.get(i) - y.get(i);
                }
            }
            return x.size() - y.size();
        });
        return ans;
    }

    private void permutation(ArrayList<Integer> res, ArrayList<Integer> A, int idx, ArrayList<ArrayList<Integer>> ans)
    {
        if(idx == A.size())
        {
            ans.add(new ArrayList<>(res));
            return;
        }

        permutation(res, A, idx+1, ans);
        res.add(A.get(idx));
        permutation(res, A, idx+1, ans);
        res.remove(res.size()-1);
    }
}
