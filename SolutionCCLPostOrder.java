/**
 * Count Uni-value Subtrees:
 *
 * Given a binary tree, count the number of uni-value subtrees.

 A Uni-value subtree means all nodes of the subtree have the same value.

 For example:

 Given binary tree,


 5
 / \
 1   5
 / \   \
 5   5   5
 return 4.
 */
public class SolutionCCLPostOrder {
    public int countUnivalSubtrees(TreeNode root) {
        // record with array[0]
        int[] res = new int[1];
        postorder(res, root);
        return res[0];
    }
    public boolean postorder(int[] res, TreeNode node) {
        // bottom-up
        if (node == null) return true; // add count when not null and subtree uni-value
        boolean left = postorder(res, node.left);
        boolean right = postorder(res, node.right);
        if (left && right) {
            if (node.left!=null && node.left.val!=node.val) return false;
            if (node.right!=null && node.right.val!=node.val) return false;
            res[0]++;
            return true;
        }
        return false; // left or right is false
    }
}
