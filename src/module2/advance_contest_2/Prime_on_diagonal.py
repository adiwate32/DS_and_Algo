import math


class Solution:
    # @param A : list of integers
    # @return an integer
    def solve(self, A):

        r = len(A)

        def is_prime(n):
            if n < 2:
                return False

            for i in range(2, int(math.sqrt(n)) + 1):
                if n % i == 0:
                    return False

            return True

        r = len(A)
        i = 0

        ans = 0
        while i * i < r * r:
            if is_prime(A[i][i]):
                ans = max(ans, A[i][i])

            i += 1

        i = 0
        j = r - 1
        while i < r and j >= 0:
            if is_prime(A[i][j]):
                ans = max(ans, A[i][j])

            i += 1
            j -= 1

        return ans
