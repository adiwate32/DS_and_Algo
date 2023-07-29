package module3.tree1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 Given preorder and inorder traversal of a tree, construct the binary tree.
 NOTE: You may assume that duplicates do not exist in the tree.

 Problem Constraints
 1 <= number of nodes <= 105

 Input Format
 First argument is an integer array A denoting the preorder traversal of the tree.
 Second argument is an integer array B denoting the inorder traversal of the tree.

 Output Format
 Return the root node of the binary tree.

 Example Input
 Input 1:
 A = [1, 2, 3]
 B = [2, 1, 3]
 Input 2:
 A = [1, 6, 2, 3]
 B = [6, 1, 3, 2]

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
public class Binary_Tree_From_Inorder_And_Preorder {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<B.size(); i++)
        {
            map.put(B.get(i), i);
        }

        return createTree(A, 0, A.size()-1, B, 0, B.size()-1, map);
    }

    public TreeNode createTree(ArrayList<Integer> pre, int ps, int pe, ArrayList<Integer> in, int is, int ie, HashMap<Integer, Integer> map)
    {
        if(ps>pe || is>ie)
        {
            return null;
        }

        int n = pre.size();
        int val = pre.get(ps);
        TreeNode root = new TreeNode(val);
        int root_idx = map.get(val);
        int lst_size = root_idx - is;

        root.left = createTree(pre, ps+1, lst_size+ps, in, is, root_idx-1, map);
        root.right = createTree(pre, lst_size+ps+1, pe, in, root_idx+1, ie, map);

        return root;
    }
}
