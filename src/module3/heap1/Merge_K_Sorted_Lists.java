package module3.heap1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

public class Merge_K_Sorted_Lists {
    public ListNode mergeKLists(ArrayList<ListNode> a) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.val));
        pq.addAll(a);
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while(!pq.isEmpty()) {
            curr.next = pq.remove();
            curr = curr.next;
            if(curr.next!=null) pq.add(curr.next);
        }
        return head.next;
    }
}
