/**
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?
 */
public class SolutionCXLII {
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                slow = head;
                while (slow!=fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
