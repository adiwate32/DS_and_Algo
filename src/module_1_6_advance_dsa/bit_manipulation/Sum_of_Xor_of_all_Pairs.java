package module_1_6_advance_dsa.bit_manipulation;

/**
 Given an array A of N integers. Find the sum of bitwise XOR all pairs of numbers in the array.

 Since the answer can be large, return the remainder after the dividing the answer by 109+7.

 Problem Constraints
 1 <= N <= 105
 1 <= A[i] < 109

 Input Format
 Only argument A is an array of integers

 Output Format
 Return an integer denoting the sum of xor of all pairs of number in the array.

 Example Input
 Input 1:
 A = [1, 2, 3]
 Input 2:
 A = [3, 4, 2]

 Example Output
 Output 1:
 6
 Output 2:
 14

 Example Explanation
 For Input 1:
 Pair    Xor
 {1, 2}  3
 {1, 3}  2
 {2, 3}  1
 Sum of xor of all pairs = 3 + 2 + 1 = 6.
 For Input 2:
 Pair    Xor
 {3, 4}  7
 {3, 2}  1
 {4, 2}  6
 Sum of xor of all pairs = 7 + 1 + 6 = 14.
 */

public class Sum_of_Xor_of_all_Pairs {
    public int solve(int[] A) {

        int n = A.length;

        long sum = 0;

        int mod = (int)(Math.pow(10, 9)) + 7;

        for(int i=0; i<32; i++)
        {
            long cnt_ones = 0;

            for(int j=0; j<n; j++)
            {
                if(check_set_bit(A[j], i))
                {
                    cnt_ones ++;
                }
            }

            long inter = ((cnt_ones * (n - cnt_ones)) % mod * (1 << i) % mod);
            sum = (sum + inter) % mod;
        }
        return (int)(sum % mod);
    }

    public boolean check_set_bit(int n, int i)
    {
        if(((n >> i) & 1) == 1)
        {
            return true;
        }
        return false;
    }
}
