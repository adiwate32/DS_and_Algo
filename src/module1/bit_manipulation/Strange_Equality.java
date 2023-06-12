package module1.bit_manipulation;

/**
 Given an integer A.
 Two numbers, X and Y, are defined as follows:

 X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
 Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
 Find and return the XOR of X and Y.

 NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.

 NOTE 2: Your code will be run against a maximum of 100000 Test Cases.

 Problem Constraints
 1 <= A <= 109

 Input Format
 First and only argument is an integer A.

 Output Format
 Return an integer denoting the XOR of X and Y.

 Example Input
 A = 5

 Example Output
 10

 Example Explanation
 The value of X will be 2 and the value of Y will be 8. The XOR of 2 and 8 is 10.
 */
public class Strange_Equality {
    public int solve(int A) {

        int pos = -1;

        for(int i=31; i>=0; i--)
        {
            if(check_set_bit(A, i))
            {
                pos = i;
                break;
            }
        }

        int s_e = (1 << (pos + 1));
        int g_e = 0;
        for(int i=pos; i>=0; i--)
        {
            if(!check_set_bit(A, i))
            {
                g_e += (1 << i);
            }
        }
        return (s_e ^ g_e);

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
