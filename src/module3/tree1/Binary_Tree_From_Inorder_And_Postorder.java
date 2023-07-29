package module3.tree1;

import java.util.HashMap;

/**
 Given the inorder and postorder traversal of a tree, construct the binary tree.
 NOTE: You may assume that duplicates do not exist in the tree.

 Problem Constraints
 1 <= number of nodes <= 105

 Input Format
 First argument is an integer array A denoting the inorder traversal of the tree.
 Second argument is an integer array B denoting the postorder traversal of the tree.

 Output Format
 Return the root node of the binary tree.

 Example Input
 Input 1:
 A = [2, 1, 3]
 B = [2, 3, 1]
 Input 2:
 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]

 Example Output
 Output 1:
 1
 / \
 2   3
 Output 2:
 1
 / \
 6   2
 /
 3

 Example Explanation
 Explanation 1:
 Create the binary tree and return the root node of the tree.
 */
public class Binary_Tree_From_Inorder_And_Postorder {
    public TreeNode buildTree(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = A.length;
        int m = B.length;

        for(int i=0; i<n; i++)
        {
            map.put(A[i], i);
        }
        return createTree(B, 0, m-1, A, 0, n-1, map);

    }

    public TreeNode createTree(int[] pos, int ps, int pe, int[] in, int is, int ie, HashMap<Integer, Integer> map)
    {
        if(ps>pe || is>ie)
        {
            return null;
        }

        int val = pos[pe];
        TreeNode root = new TreeNode(val);
        int root_idx = map.get(val);
        int lst_size = root_idx - is;

        root.left = createTree(pos, ps, lst_size+ps-1, in, is, root_idx-1, map);
        root.right = createTree(pos,lst_size+ps, pe-1, in, root_idx+1, ie, map);

        return root;
    }
}
