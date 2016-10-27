public class SolutionX {
    public int maxArea(int[] height) {
        if (height==null || height.length <= 1) return 0;
        int res = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            res = res > area ? res :  area;
            if (height[left] < height[right]) left++;
            else right--;
        }
        return res;
    }
}
