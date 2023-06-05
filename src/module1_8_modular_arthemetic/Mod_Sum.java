package module1_8_modular_arthemetic;

/**
 Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.

 Problem Constraints
 1 <= length of the array A <= 105
 1 <= A[i] <= 103

 Input Format
 The only argument given is the integer array A.

 Output Format
 Return a single integer denoting sum % (109 + 7).

 Example Input
 Input 1:
 A = [1, 2, 3]
 Input 2:
 A = [17, 100, 11]

 Example Output
 Output 1:
 5
 Output 2:
 61

 Example Explanation
 Explanation 1:
 (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) + (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5
 */
public class Mod_Sum {
    public int solve(int[] A) {

        int n = A.length;
        int mod = 1000000007;
        int [] count = new int[1001];

        for(int i=0; i<n; i++)
        {
            count[A[i]] += 1;
        }

        long ans = 0;
        for(int i=1; i<=1000; i++)
        {
            for(int j=1; j<=1000; j++)
            {
                int val = count[i] * count[j] * (i % j);
                ans = (ans % mod + val % mod) % mod;
            }
        }
        return (int) ans;
    }
}
