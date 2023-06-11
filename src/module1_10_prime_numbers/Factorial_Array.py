"""
Groot has an array A of size N. However, seeking excitement, Groot embarked on constructing an equally-sized array B with a unique definition for each of its elements:

B[i] = factorial of A[i] for every i such that 1<= i <= N.

Now Groot is interested in the total number of non-empty subsequences of array B such that every element in the subsequence has the same non-empty set of prime factors.

Since the number can be huge, return it modulo 109 + 7.

NOTE:

Factorial of a number X denotes (1 x 2 x 3 x 4......(X-1) x (X)).
A set is a data structure having only distinct elements. E.g : the set of prime factors of Y=12 will be {2,3} and not {2,2,3}

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 106

Input Format
Only argument is an integer array A of size N.

Output Format
Return an integer deonting the total number of non-empty subsequences of array B such that every element in the subsequence has the same set of prime factors modulo 109+7.

Example Input
Input 1:
 A = [2, 3, 2, 3]
Input 2:
 A = [2, 3, 4]

Example Output
Output 1:
 6
Output 2:
 4

Example Explanation
Explanation 1:
 Array B will be : [2, 6, 2, 6]
 The total possible subsequences are 6 : [2], [2], [2, 2], [6], [6], [6, 6].
Explanation 2:
 Array B will be : [2, 6, 24]
 The total possible subsequences are 4 : [2], [6], [24], [6, 24].
"""

import collections
class Solution:
    # @param A : list of integers
    # @return an integer
    def solve(self, A):
        A.sort()
        n = len(A)
        mod = math.pow(10, 9) + 7

        def seive(n):

            pf = [True] * (n + 1)
            pf[0] = False
            pf[1] = False

            for i in range(2, int(math.sqrt(n)) + 1):
                if pf[i] == True:
                    for j in range(i*i, n+1, i):
                        pf[j] = False
            return pf

        l = A[n-1]
        pf = seive(l)

        primes = [0] * (l + 1)
        for i in range(2, l+1):
            if pf[i] == True:
                primes[i] = primes[i-1] + 1

            else:
                primes[i] = primes[i-1]

        hash_map = collections.defaultdict(int)
        for i in A:
            if i==1:
                continue
            else:
                hash_map[primes[i]] += 1
        ans = 0
        for k,v in hash_map.items():
            ans += (math.pow(2, v) - 1) % mod

        return int(ans % mod)
