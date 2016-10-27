/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 For example, the following two linked lists:
 A:         a1 → a2
                    ↘
                    c1 → c2 → c3
                    ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.
 */
public class SolutionCLX {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        int diff = Math.abs(lengthA-lengthB);
        if (lengthA > lengthB) {
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        while (headA != null && headB !=null) {
            if (headA==headB) return headA;
            else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
    public int getLength(ListNode head) {
        int count = 0;
        if (head==null) return count;
        while (head!=null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
