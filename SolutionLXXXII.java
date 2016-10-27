/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */
public class SolutionLXXXII {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode (0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr!=null) {
            boolean dup = false;
            while (curr.next!=null && curr.val == curr.next.val) {
                dup = true;
                curr = curr.next;
            }
            if (dup) prev.next = curr.next;
            else prev = prev.next;
            curr = curr.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
        ListNode test = new ListNode(0);
        test.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode res = deleteDuplicates(test);
        ListNode curr = res;
        while (res!=null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
