/**
 * Given a singly linked list, determine if it is a palindrome.
 * O(n) time and O(1) space
 *
 * 1->2->3->4->3->2->1
 * 1->2->3->4->4->3->2->1
 */
public class SolutionCCXXXIV {
    public boolean isPalindrome(ListNode head) {
        // reverse the right part and compare one by one
        ListNode slow = head;
        ListNode fast = head;
        if (head==null || head.next==null) return true;
        while (fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightHead = slow.next;
        slow.next = reverse(rightHead);
        ListNode end = slow;
        fast = slow.next;
        slow = head;
        while (slow!=end) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return slow==end && (fast==null || fast.val==slow.val);
    }
    public ListNode reverse(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next!=null) {
            ListNode tmp = head.next;
            head.next = head.next.next;
            ListNode last = dummy.next;
            dummy.next = tmp;
            tmp.next = last;
        }
        return dummy.next;
    }
}
