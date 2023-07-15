package module3.linkedlist1;

/**
 Given a sorted linked list, delete all duplicates such that each element appears only once.

 Problem Constraints
 0 <= length of linked list <= 106

 Input Format
 First argument is the head pointer of the linked list.

 Output Format
 Return the head pointer of the linked list after removing all duplicates.

 Example Input
 Input 1:
 1->1->2
 Input 2:
 1->1->2->3->3

 Example Output
 Output 1:
 1->2
 Output 2:
 1->2->3

 Example Explanation
 Explanation 1:
 Each element appear only once in 1->2.
 */
public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode A) {

        ListNode node = A;

        while(node.next != null)
        {
            if(node.val == node.next.val)
            {
                node.next = node.next.next;
            }
            else
            {
                node = node.next;
            }
        }

        return A;
    }
}
