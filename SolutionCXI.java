/**
 * Given a binary tree, find its minimum depth.
 */
public class SolutionCXI {
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null && root.right!=null) return minDepth(root.right)+1;
        if (root.left!=null && root.right==null) return minDepth(root.left)+1;
        return helper(root);

    }
    public int helper(TreeNode root) {
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}
