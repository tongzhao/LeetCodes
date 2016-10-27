import java.util.ArrayList;
import java.util.List;

public class SolutionLIV {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix==null || matrix.length==0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        spiral(matrix, 0, m-1, 0, n-1, res);
        return res;
    }
    public void spiral(int[][] matrix, int top, int down, int left, int right, List<Integer> res) {
        if (top > down) return;
        if (left > right) return;
        if(top==down){
            for(int i=left; i<=right; i++){
                res.add(matrix[top][i]);
            }
        }
        else if(left==right){
            for(int i=top; i<=down; i++){
                res.add(matrix[i][left]);
            }
        }
        else {
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            for (int i = top; i < down; i++) {
                res.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) {
                res.add(matrix[down][i]);
            }
            for (int i = down; i > top; i--) {
                res.add(matrix[i][left]);
            }
        }
        spiral(matrix, top+1, down-1, left+1, right-1, res);
    }
}
