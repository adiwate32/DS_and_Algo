
class Solution:
    # @param A : list of integers
    # @param B : list of integers
    # @return a list of integers
    def solve(self, A, B):

        n = len(A)

        def check_set_bit(n, i):

            if ((n >> i) & 1) == 1:
                return True

            return False

        q = []
        for i in range(32):
            cnt = 0
            for j in range(n):

                if check_set_bit(A[j], i):
                    cnt +=1

            q.append(cnt * (n - cnt))

        ans = []
        for i in B:
            ans.append(q[i])

        return ans