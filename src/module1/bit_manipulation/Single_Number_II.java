package module1.bit_manipulation;

/**
 Given an array of integers, every element appears thrice except for one, which occurs once.

 Find that element that does not appear thrice.

 NOTE: Your algorithm should have a linear runtime complexity.

 Could you implement it without using extra memory?

 Problem Constraints
 2 <= A <= 5*106
 0 <= A <= INTMAX

 Input Format
 First and only argument of input contains an integer array A.

 Output Format
 Return a single integer.

 Example Input
 Input 1:
 A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
 Input 2:
 A = [0, 0, 0, 1]

 Example Output  1:
 4
 Output 2:
 1

 Example Explanation  1:
 4 occurs exactly once in Input 1.
 1 occurs exactly once in Input 2.
 */
public class Single_Number_II {
    public int singleNumber(final int[] A) {

        int n = A.length;
        int ans = 0;

        for(int i=0; i<32; i++)
        {
            int cnt = 0;
            for(int j=0; j<n; j++)
            {
                if(check_set_bit(A[j], i) == 1)
                {
                    cnt ++;
                }
            }
            if((cnt % 3) != 0)
            {
                ans += (1 << i);
            }
        }
        return ans;
    }

    public int check_set_bit(int n, int i)
    {
        if(((n>>i)&1) == 1)
        {
            return 1;
        }
        return 0;
    }
}
