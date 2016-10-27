/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 An example is the root-to-leaf path 1->2->3 which represents the number 123.
 Find the total sum of all root-to-leaf numbers.
 For example,
   1
  / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */
public class SolutionCXXIX {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root==null || root.val==0) return res;
        sumNumbers(root, 0);
        return res;
    }
    public void sumNumbers(TreeNode root, int tmp) {
        if (root==null) {
            res += tmp;
            return;
        }
        // find the leaf node
        if (root.left==null && root.right==null) {
            tmp = 10 * tmp + root.val;
            res += tmp;
            return;
        }
        if (root.left!=null) sumNumbers(root.left, 10*tmp+root.val);
        if (root.right!=null) sumNumbers(root.right, 10*tmp+root.val);
    }
}
