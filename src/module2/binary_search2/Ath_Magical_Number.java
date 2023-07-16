package module2.binary_search2;

/**
 You are given three positive integers, A, B, and C.
 Any positive integer is magical if divisible by either B or C.
 Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 Note: Ensure to prevent integer overflow while calculating.

 Problem Constraints
 1 <= A <= 109
 2 <= B, C <= 40000

 Input Format
 The first argument given is an integer A.
 The second argument given is an integer B.
 The third argument given is an integer C.

 Output Format
 Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

 Example Input
 Input 1:
 A = 1
 B = 2
 C = 3
 Input 2:
 A = 4
 B = 2
 C = 3

 Example Output
 Output 1:
 2
 Output 2:
 6

 Example Explanation
 Explanation 1:
 1st magical number is 2.
 Explanation 2:
 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 */
public class Ath_Magical_Number {
    int mod = 1000000007;

    public int solve(int A, int B, int C) {

        long l = 0;
        long h = (long) A * Math.min(B, C);
        long lcm = ((long) B * C) / gcd(B, C);
        long ans = -1;

        while (l <= h)
        {
            long m = (l + h) / 2;

            long magic_cnt = magicCnt(m, B, C, lcm);

            if(magic_cnt < A)
            {
                l = m+1;
            }
            else
            {
                ans = m;
                h = m-1;
            }
        }
        return (int)(ans % mod);
    }

    public int gcd(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }

        return gcd(b, a % b);
    }

    public long magicCnt(long a, int b, int c, long lcm) {
        return a/b + a/c - a/lcm;
    }
}
