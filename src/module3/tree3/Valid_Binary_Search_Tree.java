package module3.tree3;

/**
 You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.
 Assume a BST is defined as follows:
 1) The left subtree of a node contains only nodes with keys less than the node's key.
 2) The right subtree of a node contains only nodes with keys greater than the node's key.
 3) Both the left and right subtrees must also be binary search trees.

 Problem Constraints
 1 <= Number of nodes in binary tree <= 105
 0 <= node values <= 232-1

 Input Format
 First and only argument is head of the binary tree A.

 Output Format
 Return 0 if false and 1 if true.

 Example Input
 Input 1:
 1
 /  \
 2    3
 Input 2:
 2
 / \
 1   3

 Example Output
 Output 1:
 0
 Output 2:
 1

 Example Explanation
 Explanation 1:
 2 is not less than 1 but is in left subtree of 1.
 Explanation 2:
 Satisfies all conditions.
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

public class Valid_Binary_Search_Tree {
    public class Solution {
        public int isValidBST(TreeNode A) {
            if(validBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE))
            {
                return 1;
            }
            return 0;
        }

        public boolean validBST(TreeNode root, int s, int e)
        {
            if(root == null)
            {
                return true;
            }

            if(s <= root.val && root.val <= e)
            {
                boolean left = validBST(root.left, s, root.val-1);
                if(!left)
                {
                    return false;
                }
                return validBST(root.right, root.val+1, e);
            }
            else
            {
                return false;
            }
        }
    }

}
