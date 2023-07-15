package module3.linkedlist1;

/**
 Given a linked list A, remove the B-th node from the end of the list and return its head. For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5. NOTE: If B is greater than the size of the list, remove the first node of the list. NOTE: Try doing it using constant additional space.

 Problem Constraints
 1 <= |A| <= 106

 Input Format
 The first argument of input contains a pointer to the head of the linked list. The second argument of input contains the integer B.

 Output Format
 Return the head of the linked list after deleting the B-th element from the end.

 Example Input
 Input 1:
 A = 1->2->3->4->5
 B = 2
 Input 2:
 A = 1
 B = 1

 Example Output
 Output 1:
 1->2->3->5
 Output 2:

 Example Explanation
 Explanation 1:
 In the first example, 4 is the second last element.
 Explanation 2:
 In the second example, 1 is the first and the last element.
 */
public class Remove_Nth_Node_from_List_End {
    public ListNode removeNthFromEnd(ListNode A, int B) {

        ListNode temp1 = A;
        ListNode temp2 = A;

        for(int i=1; i<=B; i++)
        {
            if(temp1 != null)
            {
                temp1=temp1.next;
            }
            else
            {
                return A.next;
            }
        }

        ListNode prev = null;
        while(temp1!=null)
        {
            temp1 = temp1.next;
            prev = temp2;
            temp2 = temp2.next;
        }


        if(prev != null)
        {
            prev.next = temp2.next;
            temp2.next = null;
        }
        else{
            return A.next;
        }

        return A;
    }
}
