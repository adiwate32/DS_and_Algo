package module3.linkedlist2;

/**
 You are given two linked lists, A and B, representing two non-negative numbers.
 The digits are stored in reverse order, and each of their nodes contains a single digit.
 Add the two numbers and return it as a linked list.

 Problem Constraints
 1 <= |A|, |B| <= 105

 Input Format
 The first argument of input contains a pointer to the head of linked list A.
 The second argument of input contains a pointer to the head of linked list B.

 Output Format
 Return a pointer to the head of the required linked lists

 Example Input
 Input 1:
 A = [2, 4, 3]
 B = [5, 6, 4]
 Input 2:
 A = [9, 9]
 B = [1]

 Example Output
 Output 1:
 [7, 0, 8]
 Output 2:
 [0, 0, 1]

 Example Explanation
 Explanation 1:
 A = 342 and B = 465. A + B = 807.
 Explanation 2:
 A = 99 and B = 1. A + B = 100.
 */
public class Add_Two_Numbers_as_Lists {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {

        ListNode head = new ListNode(0);
        ListNode temp = head;

        int carry = 0;

        while(A != null || B != null || carry != 0)
        {
            ListNode sum = new ListNode(0);

            if(A != null && B!= null)
            {
                sum.val = A.val + B.val + carry;
                A = A.next;
                B = B.next;
            }
            else if(A != null)
            {
                sum.val = A.val + carry;
                A = A.next;
            }
            else if(B != null)
            {
                sum.val = B.val + carry;
                B = B.next;
            }
            else{
                sum.val = carry;
            }

            carry = sum.val / 10;
            sum.val = sum.val % 10;
            temp.next = sum;

            temp = temp.next;
        }

        return head.next;
    }
}
