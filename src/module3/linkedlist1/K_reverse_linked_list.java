package module3.linkedlist1;

/**
 Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.

 Problem Constraints
 1 <= |A| <= 103
 B always divides A

 Input Format
 The first argument of input contains a pointer to the head of the linked list.
 The second argument of input contains the integer, B.

 Output Format
 Return a pointer to the head of the modified linked list.

 Example Input
 Input 1:
 A = [1, 2, 3, 4, 5, 6]
 B = 2
 Input 2:
 A = [1, 2, 3, 4, 5, 6]
 B = 3

 Example Output
 Output 1:
 [2, 1, 4, 3, 6, 5]
 Output 2:
 [3, 2, 1, 6, 5, 4]

 Example Explanation
 Explanation 1:
 For the first example, the list can be reversed in groups of 2.
 [[1, 2], [3, 4], [5, 6]]
 After reversing the K-linked list
 [[2, 1], [4, 3], [6, 5]]
 Explanation 2:
 For the second example, the list can be reversed in groups of 3.
 [[1, 2, 3], [4, 5, 6]]
 After reversing the K-linked list
 [[3, 2, 1], [6, 5, 4]]
 */
public class K_reverse_linked_list {
    public ListNode reverseList(ListNode A, int B) {

        ListNode p1 = null;
        ListNode p2 = A;

        ListNode curr = A;
        int flag = 0;
        while(curr != null)
        {
            ListNode prev = null;
            for(int i=1; i<=B; i++)
            {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            if(flag == 0)
            {
                A = prev;
                flag = 1;
            }

            if(p1 != null)
            {
                p1.next = prev;
            }

            p1 = p2;
            p2 = curr;
        }

        return A;

    }
}
