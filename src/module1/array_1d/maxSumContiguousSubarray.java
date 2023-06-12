package module1.array_1d;

import java.util.List;

/**
 Find the contiguous non-empty subarray within an array, A of length N, with the largest sum.

 Problem Constraints
 1 <= N <= 1e6
 -1000 <= A[i] <= 1000

 Input Format
 The first and the only argument contains an integer array, A.

 Output Format
 Return an integer representing the maximum possible sum of the contiguous subarray.

 Example Input
 Input 1:
 A = [1, 2, 3, 4, -10]
 Input 2:
 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

 Example Output
 Output 1:
 10
 Output 2:
 6

 Example Explanation  1:

 The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 Explanation 2:

 The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */

public class maxSumContiguousSubarray {

    /**
     Brute force approach
     TC: O(n2)
     SC: O(1)
     */
    public int maxSubArray(final List<Integer> A) {
        int maxAns = Integer.MIN_VALUE;
        int n = A.size();
        for(int i=0; i<n; i++)
        {
            int sum = 0;
            for(int j=i; j<n; j++)
            {
                sum += A.get(j);
                maxAns = Math.max(sum, maxAns);

            }
        }
        return maxAns;
    }


    /**
     Optimised approach
     TC: O(n)
     SC: O(1)
     */
    public int maxSubArray2(final List<Integer> A) {
        int maxAns = Integer.MIN_VALUE;
        int n = A.size();
        int sum = 0;
        for (Integer integer : A) {
            sum += integer;
            maxAns = Math.max(sum, maxAns);

            if (sum < 0) {
                sum = 0;
            }
        }
        return maxAns;
    }
}
