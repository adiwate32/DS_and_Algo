package module1_6_advance_dsa.bit_manipulation;

/**
 You are given an array of integers A of size N.

 The value of a subarray is defined as BITWISE OR of all elements in it.

 Return the sum of value of all subarrays of A % 109 + 7.

 Problem Constraints
 1 <= N <= 105
 1 <= A[i] <= 108

 Input Format
 The first argument given is the integer array A.

 Output Format
 Return the sum of Value of all subarrays of A % 109 + 7.

 Example Input
 Input 1:
 A = [1, 2, 3, 4, 5]
 Input 2:
 A = [7, 8, 9, 10]

 Example Output  1:
 71
 Output 2:
 110

 Example Explanation
 Explanation 1:
 Value([1]) = 1
 Value([1, 2]) = 3
 Value([1, 2, 3]) = 3
 Value([1, 2, 3, 4]) = 7
 Value([1, 2, 3, 4, 5]) = 7
 Value([2]) = 2
 Value([2, 3]) = 3
 Value([2, 3, 4]) = 7
 Value([2, 3, 4, 5]) = 7
 Value([3]) = 3
 Value([3, 4]) = 7
 Value([3, 4, 5]) = 7
 Value([4]) = 4
 Value([4, 5]) = 5
 Value([5]) = 5
 Sum of all these values = 71
 Explanation 2:
 Sum of value of all subarray is 110.
 */
public class SUBARRAY_OR {
    public int solve(int[] A) {

        int n = A.length;

        int mod = 1000000007;

        long total_sub_arrays = (1l * n * (n+1)) / 2;

        long sum = 0;

        for(int i=0; i<32; i++)
        {
            int cnt_zeroes = 0;
            long cntr_zeroes = 0;
            for(int j=0; j<n; j++)
            {
                if(check_set_bit(A[j], i))
                {
                    cntr_zeroes += ((1l * cnt_zeroes * (cnt_zeroes + 1)) / 2);
                    cnt_zeroes = 0;
                }
                else
                {
                    cnt_zeroes ++;
                }
            }
            cntr_zeroes += ((1l * cnt_zeroes * (cnt_zeroes + 1)) / 2);
            long intermediate = (((total_sub_arrays - cntr_zeroes) % mod) * (1 << i) % mod) ;
            sum = (sum + intermediate) % mod;
        }
        return (int)sum;
    }

    public boolean check_set_bit(int n, int i)
    {
        if(((n>>i)&1) == 1)
        {
            return true;
        }
        return false;
    }
}
