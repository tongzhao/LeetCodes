public class SolutionXIX {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null || head.next==null) return null;
        ListNode tail = head;
        for (int i=n; i>0 ;i--) {
            tail = tail.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode target = head;
        while (tail!=null) {
            tail = tail.next;
            prev = prev.next;
            target = target.next;
        }
        prev.next = target.next;
        return dummy.next;
    }
}
