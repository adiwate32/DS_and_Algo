package module1.array_1d;

import java.util.ArrayList;

/**
 Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

 The digits are stored such that the most significant digit is at the head of the list.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :

 Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
 A: For the purpose of this question, YES
 Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
 A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

 Problem Constraints
 1 <= size of the array <= 1000000

 Input Format
 First argument is an array of digits.

 Output Format
 Return the array of digits after adding one.

 Example Input
 Input 1:
 [1, 2, 3]

 Example Output
 Output 1:
 [1, 2, 4]

 Example Explanation  1:
 Given vector is [1, 2, 3].
 The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */

public class addOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        while((A.get(0) == 0) & (A.size() > 1))
        {
            A.remove(0);
        }

        for(int i=A.size()-1; i>=0; i--)
        {
            if(A.get(i) == 9)
            {
                A.set(i, 0);
            }
            else
            {
                A.set(i, (A.get(i) + 1));
                return A;
            }
        }

        A.add(0, 1);
        return A;
    }
}
