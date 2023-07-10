package module2.hashing1;

import java.util.HashMap;

/**
 Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 If the given array contains a sub-array with sum zero return 1, else return 0.

 Problem Constraints
 1 <= |A| <= 100000
 -10^9 <= A[i] <= 10^9

 Input Format
 The only argument given is the integer array A.

 Output Format
 Return whether the given array contains a subarray with a sum equal to 0.

 Example Input
 Input 1:
 A = [1, 2, 3, 4, 5]
 Input 2:
 A = [4, -1, 1]

 Example Output
 Output 1:
 0
 Output 2:
 1

 Example Explanation
 Explanation 1:
 No subarray has sum 0.
 Explanation 2:
 The subarray [-1, 1] has sum 0.
 */
public class Sub_array_with_0_sum {
    public int solve(int[] A) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.

        HashMap<Long, Integer> map = new HashMap<Long, Integer>();

        int n = A.length;
        long [] pSum = new long[n];

        pSum[0] = A[0];

        for(int i=1; i<n; i++)
        {
            pSum[i] = pSum[i-1] + A[i];
        }

        map.put((long)0, -1);

        for(int i=0; i<n; i++)
        {
            if(!map.containsKey(pSum[i]))
            {
                map.put(pSum[i], i);
            }
            else
            {
                return 1;
            }
        }
        return 0;
    }
}
