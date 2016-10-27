/**
 * Given a binary tree, determine if it is height-balanced.
 */
public class SolutionCX {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        return Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1 &&
               isBalanced(root.left) && isBalanced(root.right);
    }
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
