package module3.linkedlist3;

/**
 Write a program to find the node at which the intersection of two singly linked lists, A and B, begins. For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 NOTE:
 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 The custom input to be given is different than the one explained in the examples. Please be careful.

 Problem Constraints
 0 <= |A|, |B| <= 106

 Input Format
 The first argument of input contains a pointer to the head of the linked list A.
 The second argument of input contains a pointer to the head of the linked list B.

 Output Format
 Return a pointer to the node after which the linked list is intersecting.

 Example Input
 Input 1:
 A = [1, 2, 3, 4, 5]
 B = [6, 3, 4, 5]
 Input 2:
 A = [1, 2, 3]
 B = [4, 5]

 Example Output
 Output 1:
 [3, 4, 5]
 Output 2:
 []

 Example Explanation
 Explanation 1:
 In the first example, the nodes have the same values after 3rd node in A and 2nd node in B. Thus, the linked lists are intersecting after that point.
 Explanation 2:
 In the second example, the nodes don't have the same values, thus we can return None/Null.
 */
public class Intersection_of_Linked_Lists {
    public ListNode getIntersectionNode(ListNode A, ListNode B) {

        ListNode curr1 = A;
        ListNode curr2 = B;

        if(A == null || B == null)
        {
            return null;
        }

        int la = 0;
        int lb = 0;


        while(curr1 != null)
        {
            la += 1;
            curr1 = curr1.next;
        }

        while(curr2 != null)
        {
            lb += 1;
            curr2 = curr2.next;
        }

        curr1 = A;
        curr2 = B;

        while(curr1 != null && curr2 != null)
        {
            if(la > lb)
            {
                la = la - 1;
                curr1 = curr1.next;
            }
            else if(la < lb)
            {
                lb = lb - 1;
                curr2 = curr2.next;
            }
            else{
                if(curr1 == curr2)
                {
                    return curr1;
                }
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }
        return null;
    }
}
