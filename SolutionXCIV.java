import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */
public class SolutionXCIV {
    /**
     * RECURSIVE
     public List<Integer> inorderTraversal(TreeNode root) {
     if (root == null) return ans;
     inorderTraversal(root.left);
     ans.add(root.val);
     return inorderTraversal(root.right);
     }
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root==null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        TreeNode p = root.left;
        while(!stack.isEmpty()) {
            while(p!=null) {
                stack.add(p);
                p = p.left;
            }
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            p = tmp.right;
            while (p!=null) {
                stack.add(p);
                p = p.left;
            }
        }
        return res;
    }
}
