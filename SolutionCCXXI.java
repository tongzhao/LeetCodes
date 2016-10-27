import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing all 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.
 */
public class SolutionCCXXI {
    public int maximalSquare(char[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int[] store = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]=='0') store[j] = 0;
                else store[j]++;
            }
            res = Math.max(res, getRes(store));
        }
        return res;
    }
    public int getRes(int[] store) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        for (int i = 0; i < store.length; i++) {
            while (!stack.isEmpty() && store[i] < store[stack.peek()]) {
                int index = stack.pop();
                int height = store[index];
                int preIndex = stack.isEmpty() ? -1 : stack.peek();
                int width = i - preIndex - 1;
                res = Math.max(res, height < width ? height*height : width*width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int height = store[index];
            int preIndex = stack.isEmpty() ? -1 : stack.peek();
            int width = store.length - preIndex - 1;
            res = Math.max(res, height < width ? height*height : width*width);
        }
        return res;
    }
}
