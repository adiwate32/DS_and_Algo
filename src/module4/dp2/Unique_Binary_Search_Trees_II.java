package module4.dp2;

/**
 Given an integer A, how many structurally unique BST's (binary search trees) exist that can store values 1...A?

 Problem Constraints
 1 <= A <=18

 Input Format
 First and only argument is the integer A

 Output Format
 Return a single integer, the answer to the problem

 Example Input
 Input 1:
 1
 Input 2:
 2

 Example Output
 Output 1:
 1
 Output 2:
 2

 Example Explanation
 Explanation 1:
 Only single node tree is possible.
 Explanation 2:
 2 trees are possible, one rooted at 1 and other rooted at 2.
 */
public class Unique_Binary_Search_Trees_II {
    public int numTrees(int A) {

        int[] dp = new int[A+1];

        if(A <= 2)
        {
            return A;
        }

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=A; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(j == 0 || j == i-1)
                {
                    dp[i] += dp[i-1];
                }
                else
                {
                    dp[i] += dp[j] * dp[i-j-1];
                }
            }
        }
        return dp[A];

    }
}
