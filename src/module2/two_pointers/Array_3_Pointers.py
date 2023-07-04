"""
You are given 3 sorted arrays A, B and C.
Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).

Problem Constraints
1 <= len(A), len(B), len(c) <= 106
0 <= A[i], B[i], C[i] <= 107

Input Format
First argument is an integer array A.
Second argument is an integer array B.
Third argument is an integer array C.

Output Format
Return a single integer denoting the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).

Example Input
Input 1:
 A = [1, 4, 10]
 B = [2, 15, 20]
 C = [10, 12]
Input 2:
 A = [3, 5, 6]
 B = [2]
 C = [3, 4]

Example Output
Output 1:
 5
Output 2:
 1

Example Explanation
Explanation 1:
 With 10 from A, 15 from B and 10 from C.
Explanation 2:
 With 3 from A, 2 from B and 3 from C.
"""


class Solution:
    # @param A : tuple of integers
    # @param B : tuple of integers
    # @param C : tuple of integers
    # @return an integer
    def minimize(self, A, B, C):

        i = 0
        j = 0
        k = 0

        a = len(A)
        b = len(B)
        c = len(C)

        ans = float('inf')

        while i < a and j < b and k < c:
            min_ele = min(A[i], min(B[j], C[k]))
            max_ele = max(A[i], max(B[j], C[k]))

            if max_ele - min_ele < ans:
                ans = max_ele - min_ele

            if min_ele == A[i] and i < a:
                i += 1

            if min_ele == B[j] and j < b:
                j += 1

            if min_ele == C[k] and k < c:
                k += 1

        return ans
