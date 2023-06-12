package module1.module1_11_combinatorics;

/**
 Given three integers A, B, and C, where A represents n, B represents r, and C represents p and p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.

 x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

 NOTE: For this problem, we are considering 1 as a prime.

 Problem Constraints
 1 <= A <= 106
 1 <= B <= A
 A <= C <= 109+7

 Input Format
 The first argument given is the integer A ( = n).
 The second argument given is the integer B ( = r).
 The third argument given is the integer C ( = p).

 Output Format
 Return the value of nCr % p.

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
 nCr( n=5 and r=2) = 10.
 p=13. Therefore, nCr%p = 10.
 */
public class Compute_nCr_mod_p {
    public int solve(int A, int B, int C) {

        long[] fact = new long[A+1];
        fact[0] = 1;

        for(int i=1; i<=A; i++)
        {
            fact[i] = (fact[i-1] * i) % C;
        }

        long nf = fact[A];

        long rf = fact[B];

        long nrf = fact[A-B];

        long inv_rf = powmod(rf, C-2, C);

        long inv_nrf = powmod(nrf, C-2, C);

        return (int)((nf % C * (inv_rf % C * inv_nrf % C)) % C);

    }

    public long powmod(long a, long b, long c)
    {
        if(b == 0)
        {
            return 1;
        }
        long t = powmod(a, b/2 , c);

        if(b % 2 == 0)
        {
            return (t % c * t % c) % c;
        }
        else
        {
            return ((t % c * t % c) % c * a) % c;
        }
    }
}
