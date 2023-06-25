"""
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.
NOTE:
It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 109

Input Format
The only argument given is the integer array A.

Output Format
Return the peak element.

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
Input 2:
A = [5, 17, 100, 11]

Example Output
Output 1:
 5
Output 2:
 100

Example Explanation
Explanation 1:
 5 is the peak.
Explanation 2:
 100 is the peak.
"""


class Solution:
    # @param A : list of integers
    # @return an integer
    def solve(self, A):

        n = len(A)

        if n == 1:
            return A[0]

        if A[0] > A[1]:
            return A[0]

        if A[n - 1] > A[n - 2]:
            return A[n - 1]

        l = 1
        h = n - 2

        ans = -1

        while l <= h:
            m = (l + h) // 2
            if A[m] >= A[m - 1] and A[m] >= A[m + 1]:
                ans = A[m]
                l = m + 1

            elif A[m - 1] <= A[m] < A[m + 1]:
                l = m + 1

            else:
                h = m - 1

        return ans
