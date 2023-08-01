package module3.tree2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
 The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
 Return the nodes in any order.

 Problem Constraints
 1 <= Number of nodes in binary tree <= 100000
 0 <= node values <= 10^9

 Input Format
 First and only argument is head of the binary tree A.

 Output Format
 Return an array, representing the top view of the binary tree.

 Example Input
 Input 1:

 1
 /   \
 2    3
 / \  / \
 4   5 6  7
 /
 8
 Input 2:
 1
 /  \
 2    3
 \
 4
 \
 5

 Example Output
 Output 1:
 [1, 2, 4, 8, 3, 7]
 Output 2:
 [1, 2, 3]

 Example Explanation
 Explanation 1:
 Top view is described.
 Explanation 2:
 Top view is described.
 */
public class Top_View_of_Binary_tree {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();

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
            ans.add(map.get(i).get(0));
        }

        return ans;
    }
}
