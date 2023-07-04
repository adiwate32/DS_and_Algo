"""
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of
integers ( A[i], A[j] ) such that i != j have sum equal to B. Since the number of such pairs can be very large,
return number of such pairs modulo (109 + 7).

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).

Example Input
Input 1:
A = [1, 1, 1]
B = 2
Input 2:
A = [1, 5, 7, 10]
B = 8

Example Output
Output 1:
 3
Output 2:
 1

Example Explanation
Explanation 1:
 The pairs of A[i] and A[j] which sum up to 2 are (0, 1), (0, 2) and (1, 2).
 There are 3 pairs.
Explanation 2:
 There is only one pair, such that i = 0, and j = 2 sums up to 8.
"""


class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def solve(self, A, B):

        n = len(A)
        l = 0
        r = n-1
        mod = 1000000007

        ans = 0

        while l < r:
            if A[l] + A[r] == B:
                if A[l] == A[r]:
                    cnt = r - l + 1
                    ans += cnt * (cnt - 1) / 2
                    break

                cnt_l = 0
                for i in range(l, r+1):
                    if A[l] == A[i]:
                        cnt_l += 1

                    else:
                        break

                cnt_r = 0
                for j in range(r, l-1, -1):
                    if A[r] == A[j]:
                        cnt_r += 1

                    else:
                        break

                ans += cnt_l * cnt_r
                l += cnt_l
                r -= cnt_r

            elif A[l] + A[r] > B:
                r -= 1

            else:
                l += 1

        return int(ans % mod)
