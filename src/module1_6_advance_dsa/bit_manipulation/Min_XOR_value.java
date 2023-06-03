package module1_6_advance_dsa.bit_manipulation;

import java.util.Arrays;

/**
 Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.



 Problem Constraints
 2 <= length of the array <= 100000
 0 <= A[i] <= 109

 Input Format
 First and only argument of input contains an integer array A.

 Output Format
 Return a single integer denoting minimum xor value.

 Example Input
 Input 1:
 A = [0, 2, 5, 7]
 Input 2:
 A = [0, 4, 7, 9]

 Example Output  1:
 2
 Output 2:
 3

 Example Explanation  1:
 0 xor 2 = 2
 */

public class Min_XOR_value {
    public int findMinXor(int[] A) {

        Arrays.sort(A);

        int n = A.length;

        int xor = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n-1; i++)
        {
            xor = (A[i] ^ A[i+1]);
            min = Math.min(xor, min);
        }

        return min;
    }
}
