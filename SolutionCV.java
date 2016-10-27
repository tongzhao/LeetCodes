/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 */
public class SolutionCV {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe || is > ie) return null;
        int i;
        for (i = is; i <= ie; i++) {
            // search for root
            if (inorder[i]==preorder[ps]) {
                break;
            }
        }
        TreeNode root = new TreeNode(inorder[i]);
        root.left = build(preorder, ps+1, ps+i-is, inorder, is, i-1);
        root.right = build(preorder, ps+i-is+1, pe, inorder, i+1, ie);
        return root;
    }
}
