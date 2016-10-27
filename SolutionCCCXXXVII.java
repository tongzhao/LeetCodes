/**
 * 337. House Robber III
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:
 3
 / \
 2   3
 \   \
 3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 Example 2:
 3
 / \
 4   5
 / \   \
 1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class SolutionCCCXXXVII {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        int left = 0; int right = 0;
        int subLeft = 0; int subRight = 0;

        if (root.left != null) {
            left = rob(root.left);
            subLeft = rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            right = rob(root.right);
            subRight = rob(root.right.left) + rob(root.right.right);
        }

        int sum1 = left + right;
        int sum2 = root.val + subLeft + subRight;

        return sum1 > sum2 ? sum1 : sum2;
    }
}
