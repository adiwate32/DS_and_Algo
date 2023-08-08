package module3.tree_problems_addnl;

import java.util.Deque;
import java.util.LinkedList;

/**
 Given a binary tree,
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 Initially, all next pointers are set to NULL.
 Assume perfect binary tree.

 Problem Constraints
 1 <= Number of nodes in binary tree <= 100000
 0 <= node values <= 10^9

 Input Format
 First and only argument is head of the binary tree A.

 Output Format
 Return the head of the binary tree after the changes are made.

 Example Input
 Input 1:
 1
 /  \
 2    3
 Input 2:
 1
 /  \
 2    5
 / \  / \
 3  4  6  7

 Example Output
 Output 1:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 Output 2:
 1 -> NULL
 /  \
 2 -> 5 -> NULL
 / \  / \
 3->4->6->7 -> NULL

 Example Explanation
 Explanation 1:
 Next pointers are set as given in the output.
 Explanation 2:
 Next pointers are set as given in the output.
 */
class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
public class Next_Pointer_Binary_Tree {
    public void connect(TreeLinkNode root) {
        Deque<TreeLinkNode> q = new LinkedList<>();

        if(root == null)
        {
            return;
        }

        q.addLast(root);

        while(!q.isEmpty())
        {
            int sz = q.size();

            for(int i=1; i<=sz; i++)
            {
                TreeLinkNode node = q.removeFirst();
                if(i == sz)
                {
                    node.next = null;
                }
                else
                {
                    node.next = q.getFirst();
                }
                if(node.left != null)
                {
                    q.addLast(node.left);
                }

                if(node.right != null)
                {
                    q.addLast(node.right);
                }
            }
        }
    }
}
