public class SolutionII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        if(l1==null&&l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        int carry = 0;
        while(l1!=null && l2!=null){
            int val = carry+l1.val+l2.val;
            carry = val/10;
            val = val%10;
            res.next = new ListNode(val);
            l1 = l1.next;
            l2 = l2.next;
            res = res.next;
        }
        if(l1==null && l2==null){
            if(carry!=0) res.next = new ListNode(carry);
            return dummy.next;
        }
        if(l1==null){
            while(l2!=null){
                int val = carry+l2.val;
                carry = val/10;
                val = val%10;
                res.next = new ListNode(val);
                l2 = l2.next;
                res = res.next;
            }
            if(carry>0) res.next = new ListNode(carry);
        }
        if(l2==null){
            while(l1!=null){
                int val = carry+l1.val;
                carry = val/10;
                val = val%10;
                res.next = new ListNode(val);
                l1 = l1.next;
                res = res.next;
            }
            if(carry>0) res.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
