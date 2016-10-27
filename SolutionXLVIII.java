public class SolutionXLVIII {
    public void rotate(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = matrix.length;
        for(int i=0; i<(n/2); i++){
            for(int j=0; j<((n+1)/2); j++){
                int tmp = matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=tmp;
            }
        }
        return;
    }
}
