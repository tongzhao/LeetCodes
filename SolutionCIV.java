/**
 * Given a binary tree, find its maximum depth
 */
public class SolutionCIV {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
