/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 */
public class SolutionXCVIII {
    public boolean isValidBST(TreeNode root) {
       return isValidBST(root, (long)Integer.MIN_VALUE, (long)Integer.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode node, long min, long max) {
        if (node==null) return true;
        long val = node.val;
        return node.val>=min && node.val<=max && isValidBST(node.left, min, val-1) && isValidBST(node.right, val+1, max);
    }
}
