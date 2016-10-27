import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class SolutionCIC {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root==null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode top = q.remove();
                if(i==0) res.add(top.val);
                if(top.right!=null) q.add(top.right);
                if(top.left!=null) q.add(top.left);
            }
        }
        return res;
    }
}
