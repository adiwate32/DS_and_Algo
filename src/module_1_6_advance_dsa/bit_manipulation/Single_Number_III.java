package module_1_6_advance_dsa.bit_manipulation;

/**
 Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
 Find the two integers that appear only once.

 Note: Return the two numbers in ascending order.

 Problem Constraints
 2 <= |A| <= 100000
 1 <= A[i] <= 109

 Input Format
 The first argument is an array of integers of size N.

 Output Format
 Return an array of two integers that appear only once.

 Example Input
 Input 1:
 A = [1, 2, 3, 1, 2, 4]
 Input 2:
 A = [1, 2]

 Example Output
 Output 1:
 [3, 4]
 Output 2:
 [1, 2]

 Example Explanation  1:
 3 and 4 appear only once.
 Explanation 2:
 1 and 2 appear only once.
 */
public class Single_Number_III {
    public int[] solve(int[] A) {

        int pos = -1;
        int n = A.length;

        int[] ans = new int[2];

        for(int i=0; i<32; i++)
        {
            int val = 0;
            for(int j=0; j<n; j++)
            {
                val = (val ^ check_set_bit(A[j], i));
            }
            if(val == 1)
            {
                pos = i;
                break;
            }
        }

        int set = 0;
        int unset = 0;

        for(int i=0; i<n; i++)
        {
            if(((A[i]>>pos)&1) == 1)
            {
                set = (set ^ A[i]);

            }
            else
            {
                unset = (unset ^ A[i]);
            }
        }

        if(set > unset)
        {
            ans[0] = unset;
            ans[1] = set;
        }
        else{
            ans[0] = set;
            ans[1] = unset;
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
