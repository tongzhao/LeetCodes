/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SolutionCXLVIII {
    public ListNode sortList(ListNode head){
        if(head==null) return null;
        ListNode end = head;
        while(end.next!=null){
            end = end.next;
        }
        return sort(head, end);
    }
    public ListNode sort(ListNode head, ListNode end){
        if(head==end) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=end && fast.next!=end){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode start1 = head;
        ListNode start2 = slow.next;
        slow.next = null;
        ListNode end1 = slow;
        ListNode end2 = (fast==end)? fast : fast.next;
        ListNode head1 = sort(start1, end1);
        ListNode head2 = sort(start2, end2);
        ListNode res = new ListNode(0);
        ListNode p = res;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                p.next = head1;
                head1 = head1.next;
            }
            else{
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        p.next = (head1==null) ? head2 : head1;
        return res.next;
    }
}
