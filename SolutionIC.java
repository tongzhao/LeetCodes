/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 */
// https://leetcode.com/discuss/13034/no-fancy-algorithm-just-simple-and-powerful-order-traversal
public class SolutionIC {
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    // The reason for this initialization is to avoid null pointer exception
    // in the first comparison when prevElement has not been initialized
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    public void traverse(TreeNode root) {
        // inorder traverse
        if (root==null) return;
        traverse(root.left);
        // do some business
        if (firstElement==null && prevElement.val >= root.val)
            firstElement = prevElement;
        if (firstElement!=null && prevElement.val >= root.val)
            secondElement = root;
        prevElement = root;
        traverse(root.right);
    }
}
