/**
 * Verify Preorder Sequence in Binary Search Tree
 Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 You may assume each number in the sequence is unique.
 */
public class SolutionCCLV {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) {
            return true;
        }
        return verifyPreorder(preorder, 0, preorder.length-1);
    }
    public boolean verifyPreorder(int[] preorder, int low, int high) {
        if (low >= high) return true;
        int root = preorder[low];
        int i=low+1;
        while (i <= high && preorder[i++] < root);
        int j=i;
        while (j <= high && preorder[j++] > root);
        if (j<=high) return false;
        return verifyPreorder(preorder, low+1, i-1) && verifyPreorder(preorder, i, high);
    }
}
