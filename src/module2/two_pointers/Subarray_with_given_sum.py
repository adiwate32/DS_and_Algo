"""
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
If the answer does not exist return an array with a single integer "-1".
First sub-array means the sub-array for which starting index in minimum.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:
 A = [5, 10, 20, 100, 105]
 B = 110

Example Output
Output 1:
 [2, 3]
Output 2:
 [-1]

Example Explanation
Explanation 1:
 [2, 3] sums up to 5.
Explanation 2:
 No subarray sums up to required number.
"""


class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return a list of integers
    def solve(self, A, B):

        l = 0
        r = 0

        n = len(A)
        sum = A[0]

        while r < n:

            if sum == B:
                return A[l: r + 1]

            elif sum > B:
                sum -= A[l]
                l += 1

            else:
                r += 1
                if r == n:
                    break
                sum += A[r]

        return [-1]
