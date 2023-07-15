package module3.linkedlist2;

/**
 Given a singly linked list A
 A: A0 → A1 → … → An-1 → An
 reorder it to:
 A0 → An → A1 → An-1 → A2 → An-2 → …
 You must do this in-place without altering the nodes' values.

 Problem Constraints
 1 <= |A| <= 106

 Input Format
 The first and the only argument of input contains a pointer to the head of the linked list A.

 Output Format
 Return a pointer to the head of the modified linked list.

 Example Input
 Input 1:
 A = [1, 2, 3, 4, 5]
 Input 2:
 A = [1, 2, 3, 4]

 Example Output
 Output 1:
 [1, 5, 2, 4, 3]
 Output 2:
 [1, 4, 2, 3]

 Example Explanation
 Explanation 1:
 The array will be arranged to [A0, An, A1, An-1, A2].
 Explanation 2:
 The array will be arranged to [A0, An, A1, An-1, A2].
 */
public class Reorder_List {
    public ListNode reorderList(ListNode A) {

        ListNode t1 = A;
        ListNode mid = midNode(A);

        ListNode h1 = mid.next;
        mid.next = null;

        ListNode t2 = reverse(h1);

        ListNode head = new ListNode(0);
        ListNode ans = head;

        while(t1 != null && t2 != null)
        {
            ans.next = t1;
            t1 = t1.next;
            ans = ans.next;
            ans.next = t2;
            t2 = t2.next;
            ans = ans.next;
        }

        if(t1 != null)
        {
            ans.next = t1;
        }

        return head.next;
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


    public ListNode reverse(ListNode A)
    {
        if(A == null)
        {
            return A;
        }

        ListNode prev = null;
        ListNode curr = A;

        while(curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
