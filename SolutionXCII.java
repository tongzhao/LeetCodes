/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 return 1->4->3->2->5->NULL.
 */
public class SolutionXCII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode h = head;
        // symmetric swap
        for (int i = 0; i < n - m; i++) {
            int left = m + i;
            int right = n - i;
            if (left >= right) return head;
            ListNode p = h;
            ListNode q = h;
            while (left > 1) {
                p = p.next;
                left--;
            }
            while (right > 1) {
                q = q.next;
                right--;
            }
            int tmp = p.val;
            p.val = q.val;
            q.val = tmp;
        }
        return head;
    }
}
