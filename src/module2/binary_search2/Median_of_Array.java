package module2.binary_search2;

import java.util.List;

/**
 There are two sorted arrays A and B of sizes N and M respectively.
 Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
 NOTE:
 The overall run time complexity should be O(log(m+n)).
 IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.

 Problem Constraints
 1 <= N + M <= 2*106

 Input Format
 The first argument is an integer array A of size N.
 The second argument is an integer array B of size M.

 Output Format
 Return a decimal value denoting the median of two sorted arrays.

 Example Input
 Input 1:
 A = [1, 4, 5]
 B = [2, 3]
 Input 2:
 A = [1, 2, 3]
 B = [4]

 Example Output
 Output 1:
 3.0
 Output 2:
 2.5

 Example Explanation
 Explanation 1:
 The median of both the sorted arrays will be 3.0.
 Explanation 2:
 The median of both the sorted arrays will be (2+3)/2 = 2.5.
 */
public class Median_of_Array {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        int lenA = a.size(), lenB = b.size();
        if (lenA > lenB) return findMedianSortedArrays(b, a);
        int start = 0, end = lenA, partitionCount = (lenA + lenB + 1) / 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int leftA = mid == 0 ? Integer.MIN_VALUE : a.get(mid - 1);
            int leftB = partitionCount - mid == 0 ? Integer.MIN_VALUE : b.get(partitionCount - mid - 1);
            int rightA = mid == lenA ? Integer.MAX_VALUE : a.get(mid);
            int rightB = partitionCount - mid == lenB ? Integer.MAX_VALUE : b.get(partitionCount - mid);
            if (leftA <= rightB && leftB <= rightA) {
                if ((lenA + lenB) % 2 == 0)
                {
                    return (Math.max(leftA, leftB) * 1d + Math.min(rightA, rightB)) / 2;
                }
                else
                {
                    return Math.max(leftA, leftB) * 1d;
                }
            }
            else if (leftA > rightB)
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return 0.0;
    }
}
