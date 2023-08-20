package module3.trie2;

/**
 Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N, which has maximum XOR value.
 NOTE: If there are multiple subarrays with the same maximum value, return the subarray with minimum length. If the length is the same, return the subarray with the minimum starting index.

 Problem Constraints
 1 <= N <= 100000
 0 <= A[i] <= 109

 Input Format
 First and only argument is an integer array A.

 Output Format
 Return an integer array B of size 2. B[0] is the starting index(1-based) of the subarray and B[1] is the ending index(1-based) of the subarray.

 Example Input
 Input 1:
 A = [1, 4, 3]
 Input 2:
 A = [8]

 Example Output
 Output 1:
 [2, 3]
 Output 2:
 [1, 1]

 Example Explanation
 Explanation 1:
 There are 6 possible subarrays of A:
 subarray            XOR value
 [1]                     1
 [4]                     4
 [3]                     3
 [1, 4]                  5 (1^4)
 [4, 3]                  7 (4^3)
 [1, 4, 3]               6 (1^4^3)
 [4, 3] subarray has maximum XOR value. So, return [2, 3].
 Explanation 2:
 There is only one element in the array. So, the maximum XOR value is equal to 8 and the only possible subarray is [1, 1].
 */
public class Maximum_XOR_Subarray {
    private static class Node
    {
        int data;
        int ind;
       Node left;
       Node right;
        Node(int x)
        {
            ind=-1;
            this.data = x;
            left = null;
            right = null;
        }
    }

    public int[] solve(int[] A) {
        int n = A.length;
        Node root = new Node(-1);

        int[] pfXor = new int[n+1];
        int[] ans = new int[2];

        int maxVal = Integer.MIN_VALUE;


        insert(root, 0, 0);

        for(int i=1; i<=n; i++)
        {
            pfXor[i] = (pfXor[i-1] ^ A[i-1]);

            int[] temp = maxXor(root, pfXor[i]);

            if(temp[0] > maxVal)
            {
                maxVal=temp[0];

                ans[0] = temp[1] + 1;
                ans[1] = i;
            }
            if(temp[0] == maxVal && ((ans[1] - ans[0] + 1) > (i - temp[1])))
                {
                    ans[0] = temp[1] + 1;
                    ans[1] = i;

            }

            insert(root, pfXor[i], i);
        }
        return ans;
    }

    public int[] maxXor(Node root, int x)
    {
        int[] ans = new int[2];
        Node curr = root;
        int xor = 0;

        for(int j = 31; j>=0; j--)
        {
            if((1 & (x >> j)) == 1)
            {
                if(curr.left != null)
                {
                    xor = xor | (1 << j);
                    curr = curr.left;
                }
                else
                {
                    curr = curr.right;
                }
            }
            else{
                if(curr.right != null)
                {
                    xor = xor | (1 << j);
                    curr = curr.right;
                }
                else
                {
                    curr = curr.left;
                }
            }
        }
        ans[0] = xor;
        ans[1] = curr.ind;
        return ans;
    }
    public void insert(Node root, int x, int ind)
    {
        Node curr = root;
        for(int i=31; i>=0; i--)
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
        curr.ind = ind;
    }
}