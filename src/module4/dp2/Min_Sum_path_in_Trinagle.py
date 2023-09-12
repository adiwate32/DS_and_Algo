
"""
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
Adjacent numbers for jth column of ith row is jth and (j+1)th column of (i + 1)th row

Problem Constraints
|A| <= 1000
A[i] <= 1000

Input Format
First and only argument is the vector of vector A defining the given triangle

Output Format
Return the minimum sum

Example Input
Input 1:
A = [
         [2],
        [3, 4],
       [6, 5, 7],
      [4, 1, 8, 3]
    ]
Input 2:
 A = [ [1] ]

Example Output
Output 1:
 11
Output 2:
 1

Example Explanation
Explanation 1:
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Explanation 2:
 Only 2 can be collected.
"""

def minimumTotal(self, A):
    n = len(A);

    for i in range(1, n):
        A[i][0] += A[i - 1][0]
        A[i][i] += A[i - 1][i - 1]

    for i in range(1, n):
        for j in range(1, len(A[i]) - 1):
            A[i][j] += min(A[i - 1][j], A[i - 1][j - 1])

    return min(A[n - 1])
