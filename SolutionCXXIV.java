/**
 * Given a binary tree, find the maximum path sum.
 For this problem, a path is defined as any sequence of nodes from some starting node
 to any node in the tree along the parent-child connections. The path does not need to go through the root.

 For example:
 Given the below binary tree,

   1
  / \
 2   3
 Return 6.
 */
public class SolutionCXXIV {
    public int maxPathSum(TreeNode root) {
        int total = Integer.MIN_VALUE;
        maxPathSum(root, total);
        return total;
    }
    public int maxPathSum(TreeNode root, int sum) {
        if (root==null) return 0;
        int leftSingle = maxPathSum(root.left, sum);
        int rightSingle = maxPathSum(root.right, sum);
        int total = leftSingle + root.val +rightSingle;
        int single = Math.max(root.val, Math.max(leftSingle, rightSingle)+root.val);
        sum = Math.max(sum, Math.max(total, single));
        return single;
    }
}
