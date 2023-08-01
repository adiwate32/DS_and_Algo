package module3.tree2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
 NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.

 Problem Constraints
 0 <= number of nodes <= 105

 Input Format
 First and only arument is a pointer to the root node of binary tree, A.

 Output Format
 Return a 2D array denoting the vertical order traversal of tree as shown.

 Example Input
 Input 1:
 6
 /   \
 3     7
 / \     \
 2   5     9
 Input 2:
 1
 /   \
 3     7
 /       \
 2         9

 Example Output
 Output 1:
 [
 [2],
 [3],
 [6, 5],
 [7],
 [9]
 ]
 Output 2:
 [
 [2],
 [3],
 [1],
 [7],
 [9]
 ]

 Example Explanation
 Explanation 1:
 First row represent the verical line 1 and so on.
 */
class Pair
{
    TreeNode node;
    int vl;

    Pair(TreeNode node, int x)
    {
        this.node = node;
        this.vl = x;
    }
}

public class Vertical_Order_Traversal {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Deque<Pair> q = new LinkedList<>();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        q.addLast(new Pair(A, 0));

        int minLvl = 0;
        int maxLvl = 0;

        while(!q.isEmpty())
        {
            Pair rp = q.removeFirst();

            if(!map.containsKey(rp.vl))
            {
                ArrayList<Integer> vlList = new ArrayList<>();
                vlList.add(rp.node.val);
                map.put(rp.vl, vlList);
            }
            else
            {
                map.get(rp.vl).add(rp.node.val);
            }

            if(rp.node.left != null)
            {
                q.addLast(new Pair(rp.node.left, rp.vl-1));
            }

            if(rp.node.right != null)
            {
                q.addLast(new Pair(rp.node.right, rp.vl+1));
            }

            minLvl = Math.min(minLvl, rp.vl);
            maxLvl = Math.max(maxLvl, rp.vl);
        }

        for(int i=minLvl; i<=maxLvl; i++)
        {
            ans.add(map.get(i));
        }

        return ans;

    }
}
