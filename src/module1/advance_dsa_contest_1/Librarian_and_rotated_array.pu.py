
class Solution:
    # @param A : list of integers
    # @return an integer
    def solve(self, arr):

        n = len(arr)
        pos = -1
        for i in range(n-1):

            if arr[i] > arr[i+1]:
                pos = i
                break

        if pos == -1:
            return 1

        if(arr[0] < arr[n-1] and arr[pos+1] < arr[0]):
            return 0
        for i in range(pos+1, n-1):
            if arr[i] > arr[i+1]:
                return 0

        return 1
