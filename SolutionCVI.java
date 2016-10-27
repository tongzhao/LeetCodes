/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */
public class SolutionCVI {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    public TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is>ie || ps>pe) return null;
        int rootval = postorder[pe];
        int i;
        for (i=is; i<=ie; i++) {
            if (inorder[i]==rootval) break;
        }
        TreeNode root = new TreeNode(rootval);
        root.left =  build(inorder, is, i-1, postorder, ps, ps+i-1-is);
        root.right = build(inorder, i+1, ie, postorder, ps+i-is, pe-1);
        return root;
    }
}
