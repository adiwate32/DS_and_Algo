package module3.stack1;

import java.util.Stack;

/**
 Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 NOTE:
 All the operations have to be constant time operations.
 getMin() should return -1 if the stack is empty.
 pop() should return nothing if the stack is empty.
 top() should return -1 if the stack is empty.

 Problem Constraints
 1 <= Number of Function calls <= 107

 Input Format
 Functions will be called by the checker code automatically.

 Output Format
 Each function should return the values as defined by the problem statement.

 Example Input
 Input 1:
 push(1)
 push(2)
 push(-2)
 getMin()
 pop()
 getMin()
 top()
 Input 2:
 getMin()
 pop()
 top()

 Example Output
 Output 1:
 -2 1 2
 Output 2:
 -1 -1

 Example Explanation
 Explanation 1:
 Let the initial stack be : []
 1) push(1) : [1]
 2) push(2) : [1, 2]
 3) push(-2) : [1, 2, -2]
 4) getMin() : Returns -2 as the minimum element in the stack is -2.
 5) pop() : Return -2 as -2 is the topmost element in the stack.
 6) getMin() : Returns 1 as the minimum element in stack is 1.
 7) top() : Return 2 as 2 is the topmost element in the stack.
 Explanation 2:
 Let the initial stack be : []
 1) getMin() : Returns -1 as the stack is empty.
 2) pop() :  Returns nothing as the stack is empty.
 3) top() : Returns -1 as the stack is empty.
 */
public class Min_Stack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> min_st = new Stack<>();

    public void push(int x) {
        if(min_st.isEmpty())
        {
            min_st.push(x);
        }
        else
        {
            if(x <= min_st.peek())
            {
                min_st.push(x);
            }
        }
        st.push(x);
    }

    public void pop() {
        if(!st.isEmpty())
        {
            int x = st.pop();
            if(x == min_st.peek())
            {
                min_st.pop();
            }
        }
    }

    public int top() {
        if(!st.isEmpty())
        {
            return st.peek();
        }
        return -1;
    }

    public int getMin() {
        if(!min_st.isEmpty())
        {
            return min_st.peek();
        }
        return -1;
    }
}
