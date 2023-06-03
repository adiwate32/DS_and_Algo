#


class Solution:
    # @param A : list of list of integers
    # @return an integer
    def solve(self, A):
        if not A:
            return 0

        n = len(A)
        m = len(A[0])
        per = 0

        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        for r in range(n):
            for c in range(m):
                if A[r][c] == 0:
                    continue #skip

                per += 4
                for dir in dirs:
                    new_r = r + dir[0]
                    new_c = c + dir[1]

                    if new_r < 0 or new_r == n or new_c < 0 or new_c == m or A[new_r][new_c] == 0:
                        continue

                    per -= 1

        return per