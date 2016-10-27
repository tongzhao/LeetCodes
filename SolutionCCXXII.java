/**
 * Given a complete binary tree, count the number of nodes.
 */
public class SolutionCCXXII {
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
               height(root.right) == h-1 ? (1<<h) + countNodes(root.right)
                                         : (1<<h-1) + countNodes(root.left);
    }
    // root==null, height = -1; root!=null, height = 0;
    public int height(TreeNode root) {
        return root==null ? -1 : 1+ height(root.left); // since complete, left highter
    }
}
