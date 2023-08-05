package module3.trees_lca;

/**
 Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.

 Problem Constraints
 1 <= Number of nodes in binary tree <= 100000
 0 <= node values <= 10^9

 Input Format
 First and only argument is head of the binary tree A.

 Output Format
 Return an integer, representing the Bth element.

 Example Input
 Input 1:
 2
 /   \
 1    3
 B = 2
 Input 2:
 3
 /
 2
 /
 1
 B = 1

 Example Output
 Output 1:
 2
 Output 2:
 1

 Example Explanation
 Explanation 1:
 2nd element is 2.
 Explanation 2:
 1st element is 1.
 */
public class Kth_Smallest_Element_In_BST {
    int cnt = 0;
    int ans = 0;

    public int kthsmallest(TreeNode A, int B) {
        traversal(A, B);

        return ans;
    }

    public void traversal(TreeNode root, int k)
    {
        if(root == null)
        {
            return;
        }

        traversal(root.left, k);

        cnt ++;
        if(cnt == k)
        {
            ans = root.val;
        }

        traversal(root.right, k);
    }
}
