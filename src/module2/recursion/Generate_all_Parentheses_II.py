"""
Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.

Problem Constraints
1 <= A <= 10

Input Format
First and only argument is integer A.

Output Format
Return a sorted list of all possible parenthesis.

Example Input
Input 1:
A = 3
Input 2:
A = 1

Example Output
Output 1:
[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
Output 2:
[ "()" ]

Example Explanation
Explanation 1:
 All paranthesis are given in the output list.
Explanation 2:
 All paranthesis are given in the output list.
"""
class Solution:
    # @param A : integer
    # @return a list of strings
    def generateParenthesis(self, A):

    lst = []

    def valid_parenthesis(A, s, opening, closing):
        if(len(s) == 2 * A):
            lst.append(s)

        if(opening < A):
            valid_parenthesis(A, s + '(', opening+1, closing)

        if(closing < opening):
            valid_parenthesis(A, s + ')', opening, closing+1)


    valid_parenthesis(A, '', 0, 0)

    return lst
