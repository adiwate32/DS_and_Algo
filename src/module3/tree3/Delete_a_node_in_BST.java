package module3.tree3;

/**
 Given a Binary Search Tree(BST) A. If there is a node with value B present in the tree delete it and return the tree.
 Note - If there are multiple options, always replace a node by its in-order predecessor

 Problem Constraints
 2 <= No. of nodes in BST <= 105
 1 <= value of nodes <= 109
 Each node has a unique value

 Input Format
 The first argument is the root node of a Binary Search Tree A.
 The second argument is the value B.

 Output Format
 Delete the given node if found and return the root of the BST.

 Example Input
 Input 1:
 15
 /    \
 12      20
 / \    /  \
 10  14  16  27
 /
 8
 B = 10
 Input 2:
 8
 / \
 6  21
 / \
 1   7
 B = 6

 Example Output
 Output 1:
 15
 /    \
 12      20
 / \    /  \
 8  14  16  27
 Output 2:
 8
 / \
 1  21
 \
 7

 Example Explanation
 Explanation 1:
 Node with value 10 is deleted
 Explanation 2:
 Node with value 6 is deleted
 */
public class Delete_a_node_in_BST {
    public TreeNode solve(TreeNode A, int B) {
        return deleteBST(A, B);
    }

    public TreeNode deleteBST(TreeNode root, int B)
    {
        if(root == null)
        {
            return null;
        }

        if(root.val > B)
        {
            root.left = deleteBST(root.left, B);
        }
        else if(root.val < B)
        {
            root.right = deleteBST(root.right, B);
        }
        else{
            if(root.left == null && root.right == null) // leaf child
            {
                return null;
            }
            else if(root.right == null) // only left child
            {
                return root.left;
            }
            else if(root.left == null) // only right child
            {
                return root.right;
            }
            else
            {
                int maxVal = maxLeftSubTree(root.left);
                root.val = maxVal;
                root.left = deleteBST(root.left, maxVal);
            }
        }
        return root;
    }

    //max in left sub tree
    public int maxLeftSubTree(TreeNode root)
    {
        while(root.right != null)
        {
            root = root.right;
        }

        return root.val;
    }
}
