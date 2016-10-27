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
public class SolutionCCL {
    public int countUnivalSubtrees(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null && root.right==null) return 1;
        int[] res = new int[]{0};
        helper(root, res);
        return res[0];
    }
    public boolean helper(TreeNode root, int[] res) {
        if (root.left==null && root.right==null) {
            res[0]++;
            return true;
        }
        else if (root.right!=null && root.left==null) {
            if (helper(root.right, res) && root.val == root.right.val) {
                res[0]++;
                return true;
            } else {
                return false;
            }
        }
        else if (root.right==null) {
            if (helper(root.left, res) && root.left.val == root.val) {
                res[0]++;
                return true;
            } else {
                return false;
            }
        }
        else {
            boolean l = helper(root.left, res);
            boolean r = helper(root.right, res);
            if (l && r && root.val==root.left.val && root.val==root.right.val) {
                res[0]++;
                return true;
            } else {
                return false;
            }
        }
    }
}
