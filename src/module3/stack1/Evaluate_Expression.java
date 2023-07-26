package module3.stack1;

import java.util.HashSet;
import java.util.Stack;

/**
 An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 Valid operators are +, -, *, /. Each string may be an integer or an operator.
 Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.

 Problem Constraints
 1 <= N <= 105

 Input Format
 The only argument given is string array A.

 Output Format
 Return the value of arithmetic expression formed using reverse Polish Notation.

 Example Input
 Input 1:
 A =   ["2", "1", "+", "3", "*"]
 Input 2:
 A = ["4", "13", "5", "/", "+"]

 Example Output
 Output 1:
 9
 Output 2:
 6

 Example Explanation
 Explaination 1:
 starting from backside:
 * : () * ()
 3 : () * (3)
 + : (() + ()) * (3)
 1 : (() + (1)) * (3)
 2 : ((2) + (1)) * (3)
 ((2) + (1)) * (3) = 9

 Explaination 2:
 starting from backside:
 + : () + ()
 / : () + (() / ())
 5 : () + (() / (5))
 13 : () + ((13) / (5))
 4 : (4) + ((13) / (5))
 (4) + ((13) / (5)) = 6
 */
public class Evaluate_Expression {
    public int evalRPN(String[] A) {

        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("*");
        set.add("/");
        set.add("-");

        Stack<Integer> st = new Stack<>();

        for(String a: A)
        {
            if(set.contains(a))
            {
                int op2 = st.pop();
                int op1 = st.pop();

                switch(a)
                {
                    case "+":
                        st.push((op1 + op2));
                        break;

                    case "-":
                        st.push((op1 - op2));
                        break;

                    case "/":
                        st.push((op1 / op2));
                        break;

                    case "*":
                        st.push((op1 * op2));
                        break;

                    default:
                        break;
                }
            }
            else
            {
                st.push(Integer.parseInt(a));
            }
        }
        return st.peek();
    }
}
