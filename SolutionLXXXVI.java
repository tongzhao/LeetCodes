/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class SolutionLXXXVI {
    public ListNode partition(ListNode head, int x) {
        if (head==null || head.next == null) return head;
        ListNode curr = head;
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode s = small;
        ListNode l = large;
        while (curr!=null) {
            if (curr.val < x) {
                s.next = new ListNode(curr.val);
                s = s.next;
            } else {
                l.next = new ListNode(curr.val);
                l = l.next;
            }
            curr = curr.next;
        }
        ListNode ss = small;
        while (ss.next!=null) {
            ss = ss.next;
        }
        ss.next = large.next;
        return small.next;
    }
}
