package module3.trees_lca;

import java.util.ArrayList;

/**
 Problem Description
 Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
 Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.

 Problem Constraints
 1 <= size of tree <= 100000
 1 <= B, C <= 109

 Input Format
 First argument is head of tree A.
 Second argument is integer B.
 Third argument is integer C.

 Output Format
 Return the LCA.

 Example Input
 Input 1:
 1
 /  \
 2    3
 B = 2
 C = 3
 Input 2:
 1
 /  \
 2    3
 / \
 4   5
 B = 4
 C = 5

 Example Output
 Output 1:
 1
 Output 2:
 2

 Example Explanation
 Explanation 1:
 LCA is 1.
 Explanation 2:
 LCA is 2.
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }

public class Least_Common_Ancestor {
    public int lca(TreeNode A, int B, int C) {

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        boolean b = search(arr1, A, B);
        boolean c = search(arr2, A, C);

        if(!b || !c)
        {
            return -1;
        }

        int n = arr1.size()-1;
        int m = arr2.size()-1;

        while(n >= 0 && m >= 0 && ((int)arr1.get(n) == (int)arr2.get(m))) // in java when retrieving values from arr it retrieves as objects to compate we need to use primitive data types like int
        {
            n--;
            m--;
        }

        return arr2.get(m+1);
    }

    public boolean search(ArrayList<Integer> arr, TreeNode root, int B)
    {
        if(root == null)
        {
            return false;
        }

        if(root.val == B)
        {
            arr.add(root.val);
            return true;
        }

        if(search(arr, root.left, B))
        {
            arr.add(root.val); // adding root to node path from left end
            return true;
        }

        if(search(arr, root.right, B))
        {
            arr.add(root.val); // adding root to node path from right end
            return true;
        }

        return false;
    }
}
