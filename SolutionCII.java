import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values
 */
public class SolutionCII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root==null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode dummy = new TreeNode(0);
        q.add(root);
        q.add(dummy);
        while (true) {
            List<Integer> level = new ArrayList<Integer>();
            while (q.peek()!=dummy) {
                TreeNode top = q.poll();
                level.add(top.val);
                if (top.left!=null) q.add(top.left);
                if (top.right!=null) q.add(top.right);
            }
            res.add(level);
            if (q.size()==1 && q.peek()==dummy) break;
            q.add(q.poll());
        }
        return res;
    }
}
