package module3.tree2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
 Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.

 Problem Constraints
 1 <= Number of nodes in binary tree <= 100000
 0 <= node values <= 10^9

 Input Format
 First and only argument is head of the binary tree A.

 Output Format
 Return an array, representing the right view of the binary tree.

 Example Input
 Input 1:
 1
 /   \
 2    3
 / \  / \
 4   5 6  7
 /
 8
 Input 2:
 1
 /  \
 2    3
 \
 4
 \
 5

 Example Output
 Output 1:
 [1, 3, 7, 8]
 Output 2:
 [1, 3, 4, 5]

 Example Explanation
 Explanation 1:
 Right view is described.
 Explanation 2:
 Right view is described.
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {
  val = x;
  left=null;
  right=null;
    }
 }

public class Right_View_of_Binary_Tree {
    public ArrayList<Integer> solve(TreeNode A) {

        Deque<TreeNode> q = new LinkedList<>();

        ArrayList<Integer> ans = new ArrayList<>();

        q.addLast(A);

        while(!q.isEmpty())
        {
            int sz = q.size();
            for(int i=0; i<sz; i++)
            {
                TreeNode rt = q.removeFirst();

                if(i == sz-1)
                {
                    ans.add(rt.val);
                }

                if(rt.left != null)
                {
                    q.addLast(rt.left);
                }

                if(rt.right != null)
                {
                    q.addLast(rt.right);
                }
            }
        }

        return ans;
    }
}
