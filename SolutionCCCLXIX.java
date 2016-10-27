/**
 * 369. Plus One Linked List
 *
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class SolutionCCCLXIX {
    public ListNode plusOne(ListNode head) {
        head = reverseList(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode x = dummy;
        int carry = 1;
        while (carry > 0 || x.next != null) {
            if (x.next != null) {
                x = x.next;
                carry += x.val;
                x.val = carry % 10;
                carry /= 10;
            }
            else {
                x.next = new ListNode(carry);
                x = x.next;
                carry = 0;
            }
        }
        return reverseList(dummy.next);
    }
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if(head==null || head.next==null) return head;
        while(head.next!=null) {
            ListNode tmp = dummy.next;
            ListNode tmp1 = head.next.next;
            dummy.next = head.next;
            head.next.next = tmp;
            head.next = tmp1;
        }
        return dummy.next;
    }
}
