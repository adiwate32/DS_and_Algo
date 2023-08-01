package module3.tree2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 Problem Constraints
 1 <= number of nodes <= 105

 Input Format
 First and only argument is root node of the binary tree, A.

 Output Format
 Return a 2D integer array denoting the level order traversal of the given binary tree.

 Example Input
 Input 1:
 3
 / \
 9  20
 /  \
 15   7
 Input 2:
 1
 / \
 6   2
 /
 3

 Example Output
 Output 1:
 [
 [3],
 [9, 20],
 [15, 7]
 ]
 Output 2:
 [
 [1]
 [6, 2]
 [3]
 ]

 Example Explanation
 Explanation 1:
 Return the 2D array. Each row denotes the traversal of each level.
 */
public class Level_Order {
    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {

        Deque<TreeNode> q = new LinkedList<>();

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        q.addLast(A);

        while(!q.isEmpty())
        {
            int sz = q.size();
            ArrayList<Integer> lvlAns = new ArrayList<>();
            for(int i=0; i<sz; i++)
            {
                TreeNode rt = q.removeFirst();
                lvlAns.add(rt.val);

                if(rt.left != null)
                {
                    q.addLast(rt.left);
                }

                if(rt.right != null)
                {
                    q.addLast(rt.right);
                }
            }
            ans.add(lvlAns);
        }

        return ans;
    }
}
