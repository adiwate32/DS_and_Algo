package module3.tree_problems_addnl;

/**
 Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 Problem Constraints
 1 <= number of nodes <= 105

 Input Format
 First and only argument is the root node of the binary tree.

 Output Format
 Return 0 / 1 ( 0 for false, 1 for true ).

 Example Input
 Input 1:
 1
 / \
 2   2
 / \ / \
 3  4 4  3
 Input 2:
 1
 / \
 2   2
 \   \
 3    3

 Example Output
 Output 1:
 1
 Output 2:
 0

 Example Explanation
 Explanation 1:
 The above binary tree is symmetric.
 Explanation 2:
 The above binary tree is not symmetric.
 */
public class Symmetric_Binary_Tree {
    public int isSymmetric(TreeNode A) {
        if(checkSymmetric(A, A))
        {
            return 1;
        }
        return 0;
    }

    public boolean checkSymmetric(TreeNode A, TreeNode B)
    {
        if(A == null && B == null)
        {
            return true;
        }
        else if(A == null || B == null)
        {
            return false; // not symmetric
        }

        return A.val == B.val && checkSymmetric(A.left, B.right) && checkSymmetric(A.right, B.left);
    }
}
