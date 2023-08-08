package module3.tree_problems_addnl;

/**
 Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.

 Problem Constraints
 1 <= size of tree <= 100000
 0 <= value of node <= 109

 Input Format
 First and only argument is head of tree A.

 Output Format
 Return 1 if the tree can be partitioned into two trees of equal sum else return 0.

 Example Input
 Input 1:
 5
 /  \
 3    7
 / \  / \
 4  6  5  6
 Input 2:
 1
 / \
 2   10
 / \
 20  2

 Example Output
 Output 1:
 1
 Output 2:
 0

 Example Explanation
 Explanation 1:
 Remove edge between 5(root node) and 7:
 Tree 1 =                                               Tree 2 =
 5                                                     7
 /                                                     / \
 3                                                     5   6
 / \
 4   6
 Sum of Tree 1 = Sum of Tree 2 = 18
 Explanation 2:
 The given Tree cannot be partitioned.
 */
public class Equal_Tree_Partition   {
    int ans = 0;
    public int solve(TreeNode A) {
        long sum = treeSum(A);

        if(sum % 2 == 1)
        {
            return 0; // if we have odd sum we will not be able to find equal partition
        }

        equalPartition(A, sum);

        return ans;
    }

    public long treeSum(TreeNode A)
    {
        if(A == null)
        {
            return 0;
        }
        return treeSum(A.left) + treeSum(A.right) + A.val;
    }

    public long equalPartition(TreeNode A, long sum)
    {
        if(A == null)
        {
            return 0; // no child sum equals to 0
        }

        long l = equalPartition(A.left, sum); //computing left subtree sum
        long r = equalPartition(A.right, sum); //computing right subtree sum

        if(l == sum/2 || r == sum/2)
        {
            ans = 1; // if left subtree or right subtree sum equals to totat sum / 2
        }

        return l + r + A.val;
    }
}
