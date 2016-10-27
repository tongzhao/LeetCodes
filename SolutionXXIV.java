public class SolutionXXIV {
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        ListNode l1 = dummy;
        ListNode l2 = head;
        dummy.next = head;
        while (l2!=null && l2.next!=null) {
            ListNode tmp = l2.next.next;
            l2.next.next = l1.next;
            l1.next = l2.next;
            l2.next = tmp;
            l1 = l2;
            l2 = tmp;
        }
        return dummy.next;
    }
}
