import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionXXIII {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(final ListNode listNode, final ListNode t1) {
                return listNode.val - t1.val;
            }
        });
        for (ListNode n: lists) {
            if (n!=null) pq.add(n);
        }
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            dummy.next = new ListNode(tmp.val);
            dummy = dummy.next;
            tmp = tmp.next;
            if (tmp!=null) pq.add(tmp);
        }
        return head.next;
    }
}
