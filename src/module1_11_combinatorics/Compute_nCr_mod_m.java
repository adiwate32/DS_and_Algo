package module1_11_combinatorics;

/**
 Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.

 x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

 Problem Constraints
 1 <= A * B <= 106
 1 <= B <= A
 1 <= C <= 106

 Input Format
 The first argument given is integer A ( = n).
 The second argument given is integer B ( = r).
 The third argument given is integer C ( = m).

 Output Format
 Return the value of nCr % m.

 Example Input
 Input 1:
 A = 5
 B = 2
 C = 13
 Input 2:
 A = 6
 B = 2
 C = 13

 Example Output
 Output 1:
 10
 Output 2:
 2

 Example Explanation
 Explanation 1:
 The value of 5C2 % 11 is 10.
 Explanation 2:
 The value of 6C2 % 13 is 2.
 */
public class Compute_nCr_mod_m {
    public int solve(int A, int B, int m) {

        long[][] C = new long[A+1][B+1];
        for(int i=1; i<=A; i++)
        {
            C[i][0] = 1;

            for(int j = 1; j <=B; j++)
            {
                if(i==j)
                {
                    C[i][i] = 1;
                }
                else
                {
                    C[i][j] = (C[i-1][j] % m + C[i-1][j-1] % m) % m;
                }
            }
        }

        return (int)C[A][B];
    }
}
