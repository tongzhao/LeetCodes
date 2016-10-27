import java.util.ArrayList;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class SolutionXCV {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    public List<TreeNode> generate(int min, int max) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (min>max) {
            res.add(null);
            return res;
        }
        for (int i=min; i<=max; i++) {
            List<TreeNode> lefts = generate(min, i-1);
            List<TreeNode> rights = generate(i+1, max);
            for (TreeNode left: lefts) {
                for (TreeNode right: rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
