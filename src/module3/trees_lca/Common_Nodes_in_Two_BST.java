package module3.trees_lca;

/**
 Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .
 In case there is no common node, return 0.
 NOTE:
 Try to do it one pass through the trees.

 Problem Constraints
 1 <= Number of nodes in the tree A and B <= 105
 1 <= Node values <= 106

 Input Format
 First argument represents the root of BST A.
 Second argument represents the root of BST B.

 Output Format
 Return an integer denoting the (sum of all common nodes in both BST's A and B) % (109 +7) .

 Example Input
 Input 1:
 Tree A:
 5
 / \
 2   8
 \   \
 3   15
 /
 9
 Tree B:
 7
 / \
 1  10
 \   \
 2  15
 /
 11
 Input 2:
 Tree A:
 7
 / \
 1   10
 \   \
 2   15
 /
 11
 Tree B:
 7
 / \
 1  10
 \   \
 2  15
 /
 11

 Example Output
 Output 1:
 17
 Output 2:
 46

 Example Explanation
 Explanation 1:
 Common Nodes are : 2, 15
 So answer is 2 + 15 = 17
 Explanation 2:
 Common Nodes are : 7, 2, 1, 10, 15, 11
 So answer is 7 + 2 + 1 + 10 + 15 + 11 = 46
 */
public class Common_Nodes_in_Two_BST {
    public int solve(TreeNode A, TreeNode B) {

        // finding sorted array using morris inorder traversal
        TreeNode a = inorder(A); //no extra space
        TreeNode b = inorder(B);

        int mod = 1000000007;

        int sum = 0;

        while(a != null && b != null)
        {
            if(a.val == b.val)
            {
                // System.out.println(a);
                sum = (sum + a.val) % mod;
                a = a.right;
                b = b.right;
            }
            else if(b.val < a.val)
            {
                b = b.right;
            }
            else
            {
                a = a.right;
            }
        }

        return sum;
    }

    public TreeNode inorder(TreeNode A) {

        TreeNode newNode = new TreeNode(-1);
        TreeNode root = newNode;
        root.left = null;

        TreeNode curr = A;

        while(curr != null) //LDR
        {
            if(curr.left == null) // if we dont have any left child we can add data to list and move on
            {
                root.right = new TreeNode(curr.val);
                root = root.right;
                curr = curr.right;
            }
            else
            {
                TreeNode temp = curr.left;

                while(temp.right != null && temp.right != curr)
                {
                    temp = temp.right;
                }

                if(temp.right == null)
                {
                    temp.right = curr; // creating a connection from right most node in lST to root and move to left
                    curr = curr.left;
                }

                if(temp.right == curr)
                {
                    temp.right = null; // removing already created conn and adding curr node and moving to right node
                    root.right = new TreeNode(curr.val);
                    root = root.right;
                    curr = curr.right;
                }
            }
        }
        return newNode.right;
    }
}
