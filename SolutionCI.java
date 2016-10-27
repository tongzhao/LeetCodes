/**
 * Given a binary tree,
 * check whether it is a mirror of itself (ie, symmetric around its center)
 */
public class SolutionCI {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSameTree(root.left, reverse(root.right));
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;
        if (p.val==q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
    public TreeNode reverse(TreeNode root) {
        if (root==null) return null;
        TreeNode tmp = reverse(root.left);
        root.left = reverse(root.right);
        root.right = tmp;
        return root;
    }
}
