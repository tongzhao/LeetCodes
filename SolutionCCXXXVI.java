/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 */
public class SolutionCCXXXVI {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return root;
        if (root==p || root==q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l!=null && r!=null) return root;
        return l != null ? l : r;
    }
}