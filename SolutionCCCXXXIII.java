/**
 * 333. Largest BST Subtree
 *
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

 Note:
 A subtree must include all of its descendants.
 Here's an example:
 10
 / \
 5  15
 / \   \
 1   8   7
 The Largest BST Subtree in this case is the highlighted one.
 The return value is the subtree's size, which is 3.

 Hint:

 You can recursively use algorithm similar to
 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
 */
public class SolutionCCCXXXIII {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        if (root.left==null && root.right==null) return 1;
        if (isValidBST(root, null, null)) return countNode(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root==null) return true;
        if (min != null && min >= root.val) return false;
        if (max != null && max <= root.val) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public int countNode(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null && root.right==null) return 1;
        return 1+countNode(root.left) + countNode(root.right);
    }
}
