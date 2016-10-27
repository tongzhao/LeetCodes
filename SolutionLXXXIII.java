/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class SolutionLXXXIII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        int last = Integer.MAX_VALUE;
        while(curr!=null) {
            if (curr.val==last) {
                prev.next = curr.next;
            } else {
                prev.next = curr;
                prev = prev.next;
                last = prev.val;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
