/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */

public class SolutionLXI {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode right = dummy;
        ListNode left = dummy;
        int count = 0;
        while (right.next!=null) {
            count++;
            right = right.next;
        }
        right = dummy;
        k = k % count;
        if (k == 0) return head;
        int i = 0;
        while (i < k) {
            right = right.next;
            i++;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        ListNode tmp = dummy.next;
        dummy.next = left.next;
        right.next = tmp;
        left.next = null;
        return dummy.next;
    }
}
