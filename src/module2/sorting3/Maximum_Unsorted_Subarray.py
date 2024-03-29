"""Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we
sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.

Note :
Follow 0-based indexing, while returning the sub-array's starting and ending indexes.

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000000

Input Format
First and only argument is an array of non-negative integers of size N.

Output Format
Return an array of length two where,
the first element denotes the starting index(0-based) and
the second element denotes the ending index(0-based) of the sub-array.
If the array is already sorted, return an array containing only one element i.e. -1.

Example Input
Input 1:
A = [1, 3, 2, 4, 5]
Input 2:
A = [1, 2, 3, 4, 5]

Example Output
Output 1:
[1, 2]
Output 2:
[-1]

Example Explanation 1:
If we sort the sub-array [A1, A2] then the whole array A gets sorted.
Explanation 2:
A is already sorted.
"""


class Solution:
    # @param A : list of integers
    # @return a list of integers
    def subUnsort(self, A):
        n = len(A)

        i = 0
        j = n - 1

        while i < n - 1 and A[i] <= A[i + 1]:
            i += 1

        while j > 0 and A[j] >= A[j - 1]:
            j -= 1

        if i == n - 1:
            return [-1]

        mn = min(A[i:j + 1])
        mx = max(A[i:j + 1])

        l = 0
        r = n - 1

        while A[l] <= mn and l <= i:
            l += 1

        while A[r] >= mx and r >= j:
            r -= 1

        return [l, r]
