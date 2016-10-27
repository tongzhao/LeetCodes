import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing all ones and
 * return its area.
 */
public class SolutionLXXXV {
    public int maximalRectangle(char[][] matrix){
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        int[][] count = new int[m][n];
        int localmax = 0;
        int max = 0;
        for(int i=0; i<n; i++){
            if(matrix[0][i]=='1') count[0][i]=1;
        }
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]=='0') count[i][j]=0;
                else count[i][j] = count[i-1][j]+1;
            }
        }
        for(int i=0; i<m; i++){
            localmax = largestRectangleArea(count[i]);
            max = Math.max(max, localmax);
        }
        return max;
    }

    public int largestRectangleArea(int[] height){
        int length = height.length;
        if(length==0) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i=0;
        int max=0;
        while(i<length){
            if(s.isEmpty()||height[i]>height[s.peek()]){
                s.push(i);
                i++;
            }
            else{
                int h = height[s.pop()];
                int w = s.isEmpty() ? i : i-1-s.peek();
                max = Math.max(max, h*w);
            }
        }
        while(!s.isEmpty()){
            int h = height[s.pop()];
            int w = s.isEmpty() ? i : i-1-s.peek();
            max = Math.max(max, h*w);
        }
        return max;
    }
}
