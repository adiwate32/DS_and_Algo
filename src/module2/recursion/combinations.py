"""
Given two integers A and B, return all possible combinations of B numbers out of 1 2 3 ... A.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

Problem Constraints
1 <= A, B <= 10

Input Format
The first argument is an integer A.
The second argument is an integer B.

Output Format
Return a 2-D vector denoting all possible combinations.

Example Input
Input 1:
 A = 4
 B = 2
Input 2:
 A = 3
 B = 2

Example Output
Output 1:
 [
  [1, 2],
  [1, 3],
  [1, 4],
  [2, 3],
  [2, 4],
  [3, 4],
 ]
Output 2:
 [
  [1, 2],
  [1, 3],
  [2, 3]
 ]

Example Explanation
Explanation 1:
All the possible combinations of size 2 in sorted order.
"""


class Solution:
    # @param A : integer
    # @param B : integer
    # @return a list of list of integers
    def combine(self, A, B):
        ans = []

        def backtrack(start, combination):
            if len(combination) == B:
                ans.append(combination[:])  # Append a copy of the combination to the result
                return

            for num in range(start, A + 1):
                combination.append(num)  # Add the current number to the combination
                backtrack(num + 1, combination)  # Recursively generate combinations with the next numbers
                combination.pop()  # Remove the current number from the combination

        backtrack(1, [])
        return ans
