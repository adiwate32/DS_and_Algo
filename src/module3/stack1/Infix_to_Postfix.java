package module3.stack1;

import java.util.Stack;

/**
 Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
 String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
 Find and return the postfix expression of A.

 NOTE:
 ^ has the highest precedence.
 / and * have equal precedence but greater than + and -.
 + and - have equal precedence and lowest precedence among given operators.

 Problem Constraints
 1 <= length of the string <= 500000

 Input Format
 The only argument given is string A.

 Output Format
 Return a string denoting the postfix conversion of A.

 Example Input
 Input 1:
 A = "x^y/(a*z)+b"

 Example Output
 Output 1:
 "xy^az*b+"

 */
public class Infix_to_Postfix {
    public String solve(String A) {

        StringBuilder sb = new StringBuilder();

        Stack<Character> st = new Stack<>();

        for(int i=0; i<A.length(); i++)
        {
            char ch = A.charAt(i);

            if(ch >= 'a' && ch <= 'z')
            {
                sb.append(ch);
            }

            else if(ch == '^' || ch == '/' || ch == '*' || ch == '+' || ch == '-')
            {
                while(!st.isEmpty() && (prio(st.peek()) >= prio(ch)))
                {
                    sb.append(st.pop());
                }
                st.push(ch);
            }

            else if(ch == '(')
            {
                st.push(ch);
            }

            else if(ch == ')')
            {
                while(st.peek() != '(')
                {
                    sb.append(st.pop());
                }
                st.pop();
            }
        }
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }

        return sb.toString();
    }

    private int prio(char ch)
    {
        if(ch == '^')
        {
            return 3;
        }
        else if(ch == '/' || ch == '*')
        {
            return 2;
        }
        else if(ch == '+' || ch == '-')
        {
            return 1;
        }
        return 0;
    }
}
