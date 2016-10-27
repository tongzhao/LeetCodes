/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 */
public class SolutionCXII {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasSum(root, sum);
    }
    public boolean hasSum(TreeNode root, int sum) {
        if (root==null) return false;
        if (root.val==sum && root.left==null && root.right==null) return true;
        else return hasSum(root.left, sum-root.val) || hasSum(root.right, sum-root.val);
    }
}
