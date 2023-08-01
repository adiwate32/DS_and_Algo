package module3.tree2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).

 Problem Constraints
 1 <= number of nodes <= 105

 Input Format
 First and only argument is root node of the binary tree, A.

 Output Format
 Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.

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
 [20, 9],
 [15, 7]
 ]
 Output 2:
 [
 [1]
 [2, 6]
 [3]
 ]

 Example Explanation
 Explanation 1:
 Return the 2D array. Each row denotes the zigzag traversal of each level.
 */
public class ZigZag_Level_Order_Traversal_BT {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        Deque<TreeNode> q = new LinkedList<>();
        int flag = 0;

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

            if(flag == 1)
            {
                Collections.reverse(lvlAns);
                flag = 0;
            }
            else
            {
                flag = 1;
            }
            ans.add(lvlAns);
        }

        return ans;
    }
}
