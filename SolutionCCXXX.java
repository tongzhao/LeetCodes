/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class SolutionCCXXX {
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }
    public int helper(TreeNode root, int k) {
        if (root==null) return 0;
        int leftCount = helper(root.left, k);
        int rightCount = helper(root.right, k - leftCount -1);
        if (k==leftCount+1) res = root.val;
        return leftCount+rightCount+1;
    }
}
