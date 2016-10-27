/**
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST
 */
public class SolutionCVIII {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        return newBST(nums, 0, nums.length-1);
    }
    public TreeNode newBST(int[] nums, int left, int right) {
        if (left>right) return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = newBST(nums, left, mid-1);
        root.right = newBST(nums, mid+1, right);
        return root;
    }
}
