/**
 * Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class SolutionCCIII {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast!=null) {
            if (fast.val == val) {
                slow.next = fast.next;
                fast = fast.next;
            }
            else{
                slow = slow.next;
                fast = fast.next;
            }

        }
        return dummy.next;
    }
}
