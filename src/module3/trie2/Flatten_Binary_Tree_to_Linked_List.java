package module3.trie2;

/**
 Given a binary tree A, flatten it to a linked list in-place.

 The left child of all nodes should be NULL.
 */


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Flatten_Binary_Tree_to_Linked_List {
    public TreeNode flatten(TreeNode a) {
        flattenLL(a);

        return a;
    }

    public void flattenLL(TreeNode A)
    {
        if(A == null)
        {
            return;
        }

        flattenLL(A.left);
        flattenLL(A.right);

        TreeNode temp = A.right; // storing right side so that we can attach later

        if(A.left != null)
        {
            A.right = A.left;
            A.left = null; //breaking the left connection
            while(A.right != null)
            {
                A = A.right;
            }
            A.right = temp; // attaching right side
        }
    }
}
