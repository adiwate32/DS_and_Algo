package module1_8_modular_arthemetic;

/**
 Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).

 "^" means power,
 "%" means mod, and
 "!" means factorial.

 Note: Ensure to handle integer overflow when performing the calculations.

 Problem Constraints
 1 <= A, B <= 5e5

 Input Format
 First argument is the integer A
 Second argument is the integer B
 Output Format
 Return one integer, the answer to the problem

 Example Input
 Input 1:
 A = 1
 B = 1
 Input 2:
 A = 2
 B = 2

 Example Output
 Output 1:
 1
 Output 2:
 4

 Example Explanation
 Explanation 1:
 1! = 1. Hence 1^1 = 1.
 Explanation 2:
 2! = 2. Hence 2^2 = 4.
 */
public class Very_Large_Power {
    public int solve(int A, int B) {
        int mod = 1000000007;
        long factorial = fact(B);
        long ans = pow(A, factorial);

        return (int)ans % mod;

    }

    public long fact(int n)
    {
        int mod = 1000000006;
        if(n == 1 || n == 0)
        {
            return 1;
        }

        return (n * fact(n-1) % mod) % mod;
    }

    public long pow(int a, long b)
    {
        int mod = 1000000007;
        if(b == 0)
        {
            return 1;
        }
        else
        {
            long t = pow(a, b/2);

            long l = (t % mod * t % mod) % mod;
            if(b % 2 == 0)
            {
                return l;
            }
            else
            {
                return (l * a) % mod;
            }
        }
    }
}
