"""Given two string A and B of length N and M respectively consisting of lowercase letters. Find the number of
occurrences of B in A.

Problem Constraints
1 <= M <= N <= 105

Input Format
Two argument A and B are strings

Output Format
Return an integer denoting the number of occurrences of B in A

Example Input
Input 1:
A = "acbac"
B = "ac"
Input 2:
A = "aaaa"
B = "aa"

Example Output
Output 1:
2
Output 2:
3

Example Explanation
For Input 1:
The string "ac" occurs twice in "acbac".
For Input 2:
The string "aa" occurs thrice in "aaaa".
"""


class Solution:
    def solve(self, A, B):
        def pow(x, y, mod):
            if y == 0:
                return 1
            p = pow(x, y >> 1, mod)
            if y % 2 == 0:
                return (p * p) % mod
            else:
                return (((p * p) % mod) * x) % mod

        n, m = len(B), len(A)
        mod = 10**9 + 7
        ans = 0
        p = 29
        ha, hb = 0, 0

        for i in range(n):
            hb = (hb + ord(B[i]) * pow(p, i, mod)) % mod
            ha = (ha + ord(A[i]) * pow(p, i, mod)) % mod

        if ha == hb:
            ans += 1

        l, r = 0, n
        while r < m:
            ha = (ha - ord(A[l]) * pow(p, l, mod)) % mod
            ha = (ha + ord(A[r]) * pow(p, r, mod)) % mod
            hb = (hb * p) % mod
            if ha == hb:
                ans += 1
            l += 1
            r += 1

        return ans
