"""
Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Note: The answer might not fit in an integer, so return your answer % 1000003

Problem Constraints
1 <= |A| <= 1000


Input Format
First argument is a string A.

Output Format
Return an integer denoting the rank of the given string.

Example Input
Input 1:
A = "acb"
Input 2:
A = "a"

Example Output
Output 1:
2
Output 2:
1

Example Explanation
Explanation 1:
Given A = "acb".
The order permutations with letters 'a', 'c', and 'b' :
abc
acb
bac
bca
cab
cba
So, the rank of A is 2.
Explanation 2:
Given A = "a".
Rank is clearly 1.
"""

class Solution:
    # @param A : string
    # @return an integer
    def findRank(self, A):

    A_sort = list(A)
    A_sort.sort()
    n = len(A)

    fact = [1] * (n)

    mod = 1000003

    ans = 0

    for i in range(2, n):
        fact[i] = (fact[i-1] * i) % mod

    for i in range(n):

        j = 0

        while(A_sort[j] != A[i]):
            j += 1

        if(j > 0):
            ans += (fact[len(A_sort) - 1] % mod * j % mod) % mod

        A_sort.remove(A[i])

    return (ans + 1) % mod
