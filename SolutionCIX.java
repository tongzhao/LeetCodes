import java.util.ArrayList;

public class SolutionCIX {
    public TreeNode sortedListToBST(ListNode head){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(head==null) return null;
        while(head!=null){
            res.add(head.val);
            head = head.next;
        }
        return toBST(res, 0, res.size()-1);
    }
    public TreeNode toBST(ArrayList<Integer> res, int start, int end){
        if(start==end) return new TreeNode(res.get(start));
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(res.get(mid));
        root.left = toBST(res, start, mid-1);
        root.right = toBST(res, mid+1, end);
        return root;
    }
}
