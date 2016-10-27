import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 */
public class SolutionCIII {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root==null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode dummy = new TreeNode(0);
        q.add(root);
        q.add(dummy);
        boolean reverse = false;
        while (true) {
            List<Integer> level = new ArrayList<Integer>();
            while (q.peek()!=dummy) {
                TreeNode top = q.poll();
                level.add(top.val);
                if (top.left!=null) q.add(top.left);
                if (top.right!=null) q.add(top.right);
            }
            if (reverse) {
                Collections.reverse(level);
            }
            res.add(level);
            reverse = !reverse;
            if (q.size()==1 && q.peek()==dummy) break;
            q.add(q.poll());
        }
        return res;
    }
}
