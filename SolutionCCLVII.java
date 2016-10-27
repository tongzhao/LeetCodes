import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

    1
  /   \
 2     3
  \
   5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class SolutionCCLVII {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root==null) return res;
        binaryTreePaths(root, "", res);
        return res;
    }
    public void binaryTreePaths(TreeNode root, String tmp, List<String> res) {
        if (root.left==null && root.right==null) {
            tmp += String.valueOf(root.val);
            res.add(tmp);
        } else {
            tmp += String.valueOf(root.val) + "->";
            if (root.left!=null) binaryTreePaths(root.left, tmp, res);
            if (root.right!=null) binaryTreePaths(root.right, tmp, res);
        }
    }
}
