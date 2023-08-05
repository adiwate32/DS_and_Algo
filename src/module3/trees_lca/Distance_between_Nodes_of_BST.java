package module3.trees_lca;

/**
 Given a binary search tree.
 Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.
 NOTE: Distance between two nodes is number of edges between them.

 Problem Constraints
 1 <= Number of nodes in binary tree <= 1000000
 0 <= node values <= 109

 Input Format
 First argument is a root node of the binary tree, A.
 Second argument is an integer B.
 Third argument is an integer C.

 Output Format
 Return an integer denoting the distance between two nodes with given two keys B and C

 Example Input
 Input 1:
 5
 /   \
 2     8
 / \   / \
 1   4 6   11
 B = 2
 C = 11
 Input 2:
 6
 /   \
 2     9
 / \   / \
 1   4 7   10
 B = 2
 C = 6

 Example Output
 Output 1:
 3
 Output 2:
 1

 Example Explanation
 Explanation 1:
 Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.
 Explanation 2:
 Path between 2 and 6 is: 2 -> 6. Distance will be 1
 */
public class Distance_between_Nodes_of_BST {
    public int solve(TreeNode A, int B, int C) {

        if(A.val < B && A.val < C)
        {
            return solve(A.right, B, C); //checking for lca in RST
        }

        else if(A.val > B && A.val > C)
        {
            return solve(A.left, B, C); //checking for lca in LST
        }

        return distToNode(A, B) + distToNode(A, C); //found lca of B and C and cal dist b/w lca to node
    }

    public int distToNode(TreeNode A, int B)
    {
        if(A.val > B)
        {
            return distToNode(A.left, B) + 1; // going to left side
        }
        else if(A.val < B)
        {
            return distToNode(A.right, B) + 1; // going to right side
        }

        return 0;
    }
}
