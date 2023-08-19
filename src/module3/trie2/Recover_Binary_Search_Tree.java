package module3.trie2;

import java.util.ArrayList;
import java.util.Collections;

/**
 Two elements of a Binary Search Tree (BST), represented by root A are swapped by mistake. Tell us the 2 values, when swapped, will restore the Binary Search Tree (BST).
 A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
 Note: The 2 values must be returned in ascending order

 Problem Constraints
 1 <= size of tree <= 100000

 Input Format
 First and only argument is the head of the tree,A

 Output Format
 Return the 2 elements which need to be swapped.

 Example Input
 Input 1:
 1
 / \
 2   3
 Input 2:
 2
 / \
 3   1

 Example Output
 Output 1:
 [2, 1]
 Output 2:
 [3, 1]

 Example Explanation
 Explanation 1:
 Swapping 1 and 2 will change the BST to be
 2
 / \
 1   3
 which is a valid BST
 Explanation 2:
 Swapping 1 and 3 will change the BST to be
 2
 / \
 1   3
 which is a valid BST
 */

public class Recover_Binary_Search_Tree {
    TreeNode prev = null;
    int first = -1;
    int second = -1;

    public ArrayList<Integer> recoverTree(TreeNode A) {

        restoreTree(A);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(first);
        ans.add(second);
        Collections.sort(ans);

        return ans;
    }

    public void restoreTree(TreeNode root)
    {
        if(root == null) return;

        restoreTree(root.left);

        if(prev != null && prev.val > root.val)
        {
            if(first == -1)
            {
                first = prev.val;
                second = root.val;
            }
            else
            {
                second = root.val;
            }
        }
        prev = root;
        restoreTree(root.right);
    }
}
