package module3.linkedlist2;

/**
 Sort a linked list, A in O(n log n) time.

 Problem Constraints
 0 <= |A| = 105

 Input Format
 The first and the only argument of input contains a pointer to the head of the linked list, A.

 Output Format
 Return a pointer to the head of the sorted linked list.

 Example Input
 Input 1:
 A = [3, 4, 2, 8]
 Input 2:
 A = [1]

 Example Output
 Output 1:
 [2, 3, 4, 8]
 Output 2:
 [1]

 Example Explanation
 Explanation 1:
 The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
 Explanation 2:
 The sorted form of [1] is [1].
 */
public class Sort_List {
    public ListNode sortList(ListNode A) {

        if(A == null || A.next == null)
        {
            return A;
        }

        ListNode mid = midNode(A);
        ListNode h1 = mid.next;
        mid.next = null;
        ListNode t1 = sortList(A);
        ListNode t2 = sortList(h1);
        return mergeTwoLists(t1, t2);
    }

    public ListNode midNode(ListNode A) {

        ListNode slow = A;
        ListNode fast = A;

        if(A == null)
        {
            return A;
        }

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {

        if (A == null)
        {
            return B;
        }

        if(B == null)
        {
            return A;
        }

        ListNode head = null;

        if(A.val <= B.val)
        {
            head = A;
            A = A.next;
        }
        else
        {
            head = B;
            B = B.next;
        }

        ListNode temp = head;

        while(A != null && B != null)
        {
            if(A.val <= B.val)
            {
                temp.next = A;
                A = A.next;
            }
            else
            {
                temp.next = B;
                B = B.next;
            }
            temp = temp.next;
        }

        if(A != null)
        {
            temp.next = A;
        }

        if(B != null)
        {
            temp.next = B;
        }

        return head;
    }
}
