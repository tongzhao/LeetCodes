/**
 * Given an array of n integers where n > 1, nums,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].
 */
public class SolutionCCXXXVIII {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length==0) return res;
        int[] leftPart = new int[nums.length];
        leftPart[0] = nums[0];
        int[] rightPart = new int[nums.length];
        rightPart[nums.length-1] = nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            leftPart[i] = leftPart[i-1] * nums[i];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            rightPart[i] = rightPart[i+1] * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i==0) res[i] = rightPart[i+1];
            else if (i==nums.length-1) res[i] = leftPart[i-1];
            else res[i] = leftPart[i-1] * rightPart[i+1];
        }
        return res;
    }
}
