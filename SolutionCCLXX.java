import java.util.Stack;

/**
 * Closest Binary Search Tree Value
 *
 Given a non-empty binary search tree and a target value,
 find the value in the BST that is closest to the target.
 */
public class SolutionCCLXX {
    // iterative
    public int closestValue(TreeNode root, double target) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        double min = Double.MAX_VALUE;
        if (root==null) return Integer.MAX_VALUE;
        int res = 0;
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (Math.abs(curr.val-target) < min) {
                    res = curr.val;
                    min = Math.abs(curr.val-target);
                }
                curr = curr.right;
            }
        }
        return res;
    }
}
