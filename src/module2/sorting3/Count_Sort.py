import math

"""
Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.

Problem Constraints
1 <= |A| <= 105
1 <= A[i] <= 105

Input Format
The first argument is an integer array A.

Output Format
Return an integer array that is the sorted array A.

Example Input
Input 1:
A = [1, 3, 1]
Input 2:
A = [4, 2, 1, 3]

Example Output
Output 1:
[1, 1, 3]
Output 2:
[1, 2, 3, 4]

Example Explanation
For Input 1:
The array in sorted order is [1, 1, 3].
For Input 2:
The array in sorted order is [1, 2, 3, 4].
"""


class Solution:
    # @param A : list of integers
    # @return a list of integers
    def solve(self, A):

        n = len(A)

        def count_sort(A, k):

            freq = {}
            ans = []

            for i in range(n):

                val = int(A[i] / math.pow(10, k)) % 10

                if val not in freq:
                    freq[val] = [A[i]]

                else:
                    freq[val].append(A[i])

            for i in range(10):

                if i in freq:
                    ans.extend(freq[i])

            return ans

        max_ele = max(A)
        max_dig = len(str(max_ele))
        k = 0

        while max_dig > 0:
            A = count_sort(A, k)
            max_dig -= 1
            k += 1

        return A
