package module1_8_modular_arthemetic;

/**
 Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.

 A-1 mod B is also known as modular multiplicative inverse of A under modulo B.

 Problem Constraints
 1 <= A <= 109
 1<= B <= 109
 B is a prime number

 Input Format
 First argument is an integer A.
 Second argument is an integer B.

 Output Format
 Return an integer denoting the modulor inverse

 Example Input
 Input 1:
 A = 3
 B = 5
 Input 2:
 A = 6
 B = 23

 Example Output
 Output 1:
 2
 Output 2:
 4

 Example Explanation
 Explanation 1:
 Let's say A-1 mod B = X, then (A * X) % B = 1.
 3 * 2 = 6, 6 % 5 = 1.
 Explanation 2:
 Similarly, (6 * 4) % 23 = 1.
 */
public class Prime_Modulo_Inverse {
    public int solve(int A, int B) {
        long val = pow(A, B-2, B);
        return (int) val % B;
    }

    public long pow(int a, int b, int c)
    {
        if(b == 0)
        {
            return 1;
        }
        else
        {
            long t = pow(a, b/2, c);

            if(b % 2 == 0)
            {
                return (t % c * t % c) % c;
            }
            else
            {
                return (t % c * t % c * a) % c;
            }
        }
    }
}
