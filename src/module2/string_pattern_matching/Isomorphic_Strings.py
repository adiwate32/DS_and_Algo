"""
Given two strings A and B, determine if they are isomorphic. A and B are called isomorphic strings if all
occurrences of each character in A can be replaced with another character to get B and vice-versa.

Problem Constraints
1 <= |A| <= 100000
1 <= |B| <= 100000
A and B contain only lowercase characters.

Input Format
The first Argument is string A.
The second Argument is string B.

Output Format
Return 1 if strings are isomorphic, 0 otherwise.

Example Input
Input 1:
A = "aba"
B = "xyx"
Input 2:
A = "cvv"
B = "xyx"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 Replace 'a' with 'x', 'b' with 'y'.
Explanation 2:
 A cannot be converted to B.
"""


class Solution:
    # @param A : string
    # @param B : string
    # @return an integer
    def solve(self, A, B):

        da = {}
        db = {}

        n = len(A)
        m = len(B)

        if n != m:
            return 0

        for i in range(m):
            if A[i] not in da:
                da[A[i]] = B[i]

            else:
                if da[A[i]] != B[i]:
                    return 0

            if B[i] not in db:
                db[B[i]] = A[i]

            else:
                if db[B[i]] != A[i]:
                    return 0

        return 1
