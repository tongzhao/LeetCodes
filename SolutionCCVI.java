/**
 * Reverse a singly linked list.
 */
public class SolutionCCVI {
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head.next;
        while (fast!=null) {
            ListNode tmp = fast.next;
            ListNode temp = dummy.next;
            dummy.next = fast;
            fast.next = temp;
            head.next = tmp;
            fast = tmp;
        }
        return dummy.next;
    }
}
