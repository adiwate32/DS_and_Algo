package module3.tree3;

/**
 Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.

 Problem Constraints
 1 <= number of nodes <= 100000

 Input Format
 First and only argument is an integer array denoting the preorder traversal of binary tree.

 Output Format
 Return a string "YES" if true else "NO".

 Example Input
 Input 1:
 A : [4, 10, 5, 8]
 Input 2:
 A : [1, 5, 6, 4]

 Example Output
 Output 1:
 "YES"
 Output 2:
 "NO"

 Example Explanation
 Explanation 1:
 The possible BST is:
 4
 \
 10
 /
 5
 \
 8
 Explanation 2:
 There is no possible BST which have the above preorder traversal.
 */
public class Check_for_BST_with_One_Child {
    public String solve(int[] A) {

        if(checkPreorder(A, Integer.MIN_VALUE, Integer.MAX_VALUE, 0))
        {
            return "YES";
        }
        return "NO";
    }

    public boolean checkPreorder(int[] A, int min, int max, int i)
    {
        if(i == A.length)
        {
            return true;
        }

        if(A[i] >= min && A[i] <= max)
        {
            return checkPreorder(A, min, A[i]-1, i+1) || checkPreorder(A, A[i]+1, max, i+1);
        }
        else
        {
            return false;
        }
    }
}
