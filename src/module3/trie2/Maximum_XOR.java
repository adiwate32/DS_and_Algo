package module3.trie2;

import java.util.ArrayList;
import java.util.Collections;

/**
 Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.

 Problem Constraints
 1 <= length of the array <= 100000
 0 <= A[i] <= 109

 Input Format
 The only argument given is the integer array A.

 Output Format
 Return an integer denoting the maximum result of A[i] XOR A[j].

 Example Input
 Input 1:
 A = [1, 2, 3, 4, 5]
 Input 2:
 A = [5, 17, 100, 11]

 Example Output
 Output 1:
 7
 Output 2:
 117

 Example Explanation
 Explanation 1:
 Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.
 Explanation 2:
 Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.
 */
class Node
{
    int data;
    Node left;
    Node right;
    Node(int x)
    {
        data = x;
        left = null;
        right = null;
    }
}

public class Maximum_XOR {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int maxi = Collections.max(A);
        int maxBits = maxBits(maxi);
        Node root = new Node(-1);

        for(int i=0; i<n; i++)
        {
            insert(root, A.get(i), maxBits);
        }
        return maxXor(A, root, maxBits);
    }

    public int maxBits(int n)
    {
        int cnt = 0;
        while(n > 0)
        {
            cnt ++;
            n = n >> 1;
        }
        return cnt ;
    }

    public int maxXor(ArrayList<Integer> A, Node root, int maxBits)
    {
        int ans = Integer.MIN_VALUE;

        for (Integer integer : A) {
            Node curr = root;
            int xor = 0;
            int val = integer;
            for (int j = maxBits - 1; j >= 0; j--) {
                if ((1 & (val >> j)) == 1) {
                    if (curr.left != null) {
                        xor = xor | (1 << j);
                        curr = curr.left;
                    } else {
                        curr = curr.right;
                    }
                } else {
                    if (curr.right != null) {
                        xor = xor | (1 << j);
                        curr = curr.right;
                    } else {
                        curr = curr.left;
                    }
                }
            }
            ans = Math.max(ans, xor);
        }
        return ans;
    }

    public void insert(Node root, int x, int n)
    {
        Node curr = root;
        for(int i=n-1; i>=0; i--)
        {
            if((1 & (x >> i)) == 1)
            {
                if(curr.right == null)
                {
                    curr.right = new Node(1);
                }
                curr = curr.right;
            }
            else
            {
                if(curr.left == null)
                {
                    curr.left = new Node(0);
                }
                curr = curr.left;
            }
        }
    }
}
