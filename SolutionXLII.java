public class SolutionXLII {
    public int trap(int[] height) {
        int h = 0;
        int res = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right) {
            h = Math.max(h, Math.min(height[left], height[right]));
            res += h - Math.min(height[left], height[right]);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return res;
    }
}
