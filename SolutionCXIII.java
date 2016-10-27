import java.util.ArrayList;
import java.util.List;

/**
 * Path sum to find all paths from root to leaf
 */
public class SolutionCXIII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        pathSum(root, sum, tmp, res);
        return res;
    }
    public void pathSum(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> res) {
        if (root==null) return;
        if (root.val==sum && root.left==null && root.right==null) {
            List<Integer> sub = new ArrayList<Integer>(tmp);
            sub.add(root.val);
            res.add(sub);
            return;
        } else {
            tmp.add(root.val);
            if (root.left!=null) {
                pathSum(root.left, sum-root.val, tmp, res);
            }
            if (root.right!=null) {
                pathSum(root.right, sum-root.val, tmp, res);
            }
            tmp.remove(tmp.size()-1);
        }
    }
}
