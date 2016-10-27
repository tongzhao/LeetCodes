import java.util.ArrayList;
import java.util.List;

/**
 * 366. Find Leaves of Binary Tree
 *
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 Example:
 Given binary tree
     1
    / \
   2   3
  / \
 4   5
 Returns [4, 5, 3], [2], [1].

 Explanation:
 1. Removing the leaves [4, 5, 3] would result in this tree:

   1
  /
 2

 2. Now removing the leaf [2] would result in this tree:

 1

 3. Now removing the leaf [1] would result in the empty tree:

 []
 Returns [4, 5, 3], [2], [1].
 */
public class SolutionCCCLXVI {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;

        while(root != null) {
            List<Integer> tmp = new ArrayList<Integer>();
            root = removeLeaves(root, tmp);
            res.add(tmp);
        }
        return res;
    }

    public TreeNode removeLeaves(TreeNode root, List<Integer> res) {
        if (root == null) return null;
        if (root.left==null && root.right == null) {
            res.add(root.val);
            return null;
        }
        root.left = removeLeaves(root.left, res);
        root.right = removeLeaves(root.right, res);
        return root;
    }
}
