package module3.linkedlist3;

/**
 Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.

 You should preserve the original relative order of the nodes in each of the two partitions.

 Problem Constraints
 1 <= |A| <= 106
 1 <= A[i], B <= 109

 Input Format
 The first argument of input contains a pointer to the head to the given linked list.
 The second argument of input contains an integer, B.

 Output Format
 Return a pointer to the head of the modified linked list.

 Example Input
 Input 1:
 A = [1, 4, 3, 2, 5, 2]
 B = 3
 Input 2:
 A = [1, 2, 3, 1, 3]
 B = 2

 Example Output
 Output 1:
 [1, 2, 2, 4, 3, 5]
 Output 2:
 [1, 1, 2, 3, 3]

 Example Explanation
 Explanation 1:
 [1, 2, 2] are less than B wheread [4, 3, 5] are greater than or equal to B.
 Explanation 2:
 [1, 1] are less than B wheread [2, 3, 3] are greater than or equal to B.
 */
class ListNode {
    public int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Partition_List {
    public ListNode partition(ListNode A, int B) {

        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(0);

        ListNode t1 = h1;
        ListNode t2 = h2;

        ListNode curr = A;

        while(curr != null)
        {
            ListNode nn = new ListNode(curr.val);
            if(curr.val < B)
            {
                t1.next = nn;
                t1 = t1.next;
            }
            else
            {
                t2.next = nn;
                t2 = t2.next;
            }
            curr = curr.next;
        }

        t1.next = h2.next;

        return h1.next;
    }
}
