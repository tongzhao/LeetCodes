public class SolutionXXV {
    ListNode tail = new ListNode(0);
    public ListNode reverseKGroup(ListNode head, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // count for the total number
        if(head==null) return null;
        if(k==1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        int count = 0;
        while(p.next!=null){
            p = p.next;
            count++;
        }
        if(k>count) return head;
        p=head;
        ListNode mark = dummy;
        int i=1;
        while(i<=count){
            if(i%k==0){
                if(p.next==null){
                    mark.next = reverse(head);
                }
                else{
                    ListNode tmp = p.next;
                    p.next = null;
                    mark.next = reverse(head);
                    mark = tail;
                    tail.next = tmp;
                    head = tmp;
                    p = tmp;
                }
            }
            else p = p.next;
            i++;
        }
        return dummy.next;
    }
    public ListNode reverse (ListNode head){
        if(head==null||head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head.next;
        while(curr!=null){
            ListNode tmp = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            head.next = tmp;
            curr = tmp;
        }
        tail = head;
        return dummy.next;
    }
}
