import java.util.HashMap;

public class SolutionCXXXVIII {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode x = head;
        while (x!=null) {
            RandomListNode y = new RandomListNode(x.label);
            y.next = null;
            y.random = null;
            map.put(x, y);
            x = x.next;
        }
        x = head;
        while (x!=null) {
            RandomListNode y = map.get(x);
            y.next = map.get(x.next);
            y.random = map.get(x.random);
            x = x.next;
        }
        return map.get(head);
    }
}
