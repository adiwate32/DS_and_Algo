
"""
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer A, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.

Problem Constraints
1 <= A <= 10

Input Format
First argument is an integer n denoting the size of chessboard

Output Format
Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.

Example Input
Input 1:
A = 4
Input 2:
A = 1

Example Output
Output 1:
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],
 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Output 1:
[
 [Q]
]

Example Explanation
Explanation 1:
There exist only two distinct solutions to the 4-queens puzzle:
Explanation 1:
There exist only one distinct solutions to the 1-queens puzzle:
"""
class Solution:
    # @param A : integer
    # @return a list of list of strings
    def solveNQueens(self, A):

        ans = []

        mat = [[0] * A for _ in range(A)]

        cols = [False] * A
        ant_diag = [False] * (2 * A - 1)
        diag = [False] * (2 * A - 1)

        def NQueens(mat, r, A, cols, ant_diag, diag):
            if r == A:
                ans.append(add_solution(mat))

            for c in range(A):
                if not cols[c] and not ant_diag[r + c] and not diag[r - c + A - 1]:
                    mat[r][c] = 1
                    cols[c] = True
                    ant_diag[r + c] = True
                    diag[r - c + A - 1] = True
                    NQueens(mat, r + 1, A, cols, ant_diag, diag)
                    mat[r][c] = 0
                    cols[c] = False
                    ant_diag[r + c] = False
                    diag[r - c + A - 1] = False

        def add_solution(arr):
            lst = []
            for r in range(len(arr)):
                r_str = ""
                for c in range(len(arr[0])):
                    if arr[r][c] == 0:
                        r_str += '.'
                    else:
                        r_str += 'Q'

                lst.append(r_str)

            return lst

        NQueens(mat, 0, A, cols, ant_diag, diag)
        return ans
