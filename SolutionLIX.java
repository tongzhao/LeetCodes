public class SolutionLIX {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n<=0) return matrix;
        if (n==1) {
            matrix[0][0] = 1;
            return matrix;
        }
        spiral(matrix, 0, n-1, 0, n-1, 1, n*n);
        return matrix;
    }
    public void spiral(int[][] matrix, int top, int bottom, int left, int right, int num, int total) {
        if (num > total) return;
        if (top > bottom || left > right) return;
        if (top == bottom) {
            matrix [top][left] = num;
            return;
        }
        for (int i = left; i < right; i++) {
            matrix[top][i] = num++;
            if (num > total) return;
        }
        for (int i = top; i < bottom; i++) {
            matrix[i][right] = num++;
        }
        for (int i = right; i>left; i--) {
            matrix[bottom][i] = num++;
        }
        for (int i = bottom; i > top; i--) {
            matrix[i][left] = num++;
        }
        spiral(matrix, top+1, bottom-1, left+1, right-1, num, total);
    }
}
