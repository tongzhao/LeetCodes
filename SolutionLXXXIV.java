import java.util.Stack;

/**
 * Given height = [2,1,5,6,2,3],
 return 10.
 Largest rectangular
 */
public class SolutionLXXXIV {
    public int largestRectangleArea(int[] height) {
        if (height==null || height.length==0) return 0;
        int res = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] < height[i]) {
                stack.push(i);
                i++;
            } else {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i-1- stack.peek();
                res = Math.max(res, h * w);
            }
        }
        while (!stack.isEmpty()) {
            int h = height[stack.pop()];
            int w = stack.isEmpty() ? i : i-1-stack.peek();
            res = Math.max(res, h * w);
        }
        return res;
    }
}
