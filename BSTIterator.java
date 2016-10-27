import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.
 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BSTIterator {
 Stack<TreeNode> stack = new Stack<TreeNode>();
  public BSTIterator(TreeNode root) {
   while (root!=null) {
    stack.push(root);
    root = root.left;
   }
  }

  /**
   * @return whether we have a next smallest number
   */
  public boolean hasNext() {
   return !stack.isEmpty();
  }

  /**
   * @return the next smallest number
   */
  public int next() {
    TreeNode node = stack.pop();
    int res = node.val;
    TreeNode right = node.right;
    while (right!=null) {
     stack.push(right);
     right = right.left;
    }
    return res;
  }
}
