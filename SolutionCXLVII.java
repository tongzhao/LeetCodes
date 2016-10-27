/**
 * Sort a linked list using insertion sort.
 */
public class SolutionCXLVII {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr!=null) {
            if (curr.next!=null && curr.next.val < curr.val) {
                while (prev.next!=null && prev.next.val < curr.next.val)
                    prev = prev.next;
                /*Insert curr.next after prev*/
                ListNode tmp = prev.next;
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = tmp;
                /*Move prev back to the start*/
                prev = dummy;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
