/**
 * Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 */
public class SolutionCLIV {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }
    public int findMin(int[] num, int left, int right){
        if(left==right) return num[left];
        if(right==left+1) return Math.min(num[left], num[right]);
        int mid = (left+right)/2;
        // no rotate
        if(num[left]<num[right]) return num[left];
        // only diff
        else if(num[left]==num[right]){
            return findMin(num, left+1, right);
        }
        // right rotate
        else if(num[mid]>=num[left]){
            return findMin(num, mid, right);
        }
        else return findMin(num, left, mid);
    }
}
