import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Closest Binary Search Tree Value II:
 *
 * Given a non-empty binary search tree and a target value,
 * find k values in the BST that are closest to the target.
 Note:
 Given target value is a floating point.
 You may assume k is always valid, that is: k ≤ total nodes.
 You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 */
public class SolutionCCLXXII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // Consider the method in iterative of in-order traversal of a tree, expand from it
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // In order to compare the values inside a linkedlist
        LinkedList<Integer> res = new LinkedList<Integer>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                // if-else as added logic for find top-k, since inorder, can apply linked list
                if (res.size() < k) res.addLast(curr.val);
                else {
                    if (Math.abs(res.getFirst() - target) > Math.abs(curr.val - target)) {
                        res.removeFirst();
                        res.addLast(curr.val);
                    } else break;
                }
                curr = curr.right;
            }
        }
        return res;
    }
}
