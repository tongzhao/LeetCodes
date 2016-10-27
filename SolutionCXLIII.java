/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 You must do this in-place without altering the nodes' values.
 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}
 */
public class SolutionCXLIII {
    public void reorderList(ListNode head){
        if(head==null||head.next==null||head.next.next==null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = slow.next;
        slow.next = null;
        rev = reverse(rev);
        ListNode curr = head;
        while(rev!=null){
            ListNode tmp = rev.next;
            rev.next = curr.next;
            curr.next = rev;
            curr = curr.next.next;
            rev = tmp;
        }
    }

    public ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        while(curr.next!=null){
            ListNode tmp = curr.next;
            curr.next = curr.next.next;
            tmp.next = prev.next;
            prev.next = tmp;
        }
        return dummy.next;
    }
}
