/**
 * Given a binary tree, flatten it to a linked list in-place.
 */
public class SolutionCXIV {
    public void flatten(TreeNode root) {
        flat(root);
    }
    public TreeNode flat(TreeNode root) {
        if (root==null) return null;
        TreeNode l = root.left;
        TreeNode r = root.right;
        if (l!=null) {
            root.right = flat(l);
            root.left = null;
            TreeNode rightmost = l;
            while (rightmost.right!=null) rightmost = rightmost.right;
            rightmost.right = r;
        }
        flat(r);
        return root;
    }
}
