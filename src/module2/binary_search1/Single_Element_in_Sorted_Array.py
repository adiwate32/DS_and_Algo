"""
Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
Elements which are appearing twice are adjacent to each other.
NOTE: Users are expected to solve this in O(log(N)) time.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the single element that appears only once.

Example Input
Input 1:
A = [1, 1, 7]
Input 2:
A = [2, 3, 3]

Example Output
Output 1:
 7
Output 2:
 2

Example Explanation
Explanation 1:
 7 appears once
Explanation 2:
 2 appears once
"""


class Solution:
    # @param A : list of integers
    # @return an integer
    def solve(self, A):

        n = len(A)

        if n == 1:
            return A[0]

        if A[0] != A[1]:
            return A[0]

        if A[n - 1] != A[n - 2]:
            return A[n - 1]

        l = 1
        h = n - 2

        while l <= h:
            m = (l + h) // 2

            if A[m] != A[m - 1] and A[m] != A[m + 1]:
                return A[m]

            else:
                if A[m] == A[m - 1]:
                    m = m - 1

                if m % 2 == 0:
                    l = m + 2

                else:
                    h = m - 1
