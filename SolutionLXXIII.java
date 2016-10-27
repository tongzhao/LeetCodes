/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class SolutionLXXIII {
    public void setZeroes(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        // It is a really good solution to mark in the very first 0th row/col to indicate if there is a zero value. IN-PLACE!
        // Be careful that the 0th row/col should be recorded at first.
        int m = matrix.length;
        int n = matrix[0].length;
        boolean x = false; // to indicate the 0th row
        boolean y = false; // to indicate the 0th col

        // 0th row
        for(int i=0; i<n; i++){
            if(matrix[0][i]==0){
                x=true;
                break;
            }
        }
        // 0th col
        for(int i=0; i<m; i++){
            if(matrix[i][0]==0){
                y=true;
                break;
            }
        }
        // each element to bubble zero
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        // set value in row
        for(int i=1; i<m; i++){
            if(matrix[i][0]==0){
                for(int j=1; j<n; j++){
                    matrix[i][j]=0;
                }
            }
        }
        // set value in col
        for(int j=1; j<n; j++){
            if(matrix[0][j]==0){
                for(int i=1; i<m; i++){
                    matrix[i][j]=0;
                }
            }
        }
        // finally the 0th row and col
        if(x){
            for(int j=0; j<n; j++){
                matrix[0][j]=0;
            }
        }
        if(y){
            for(int i=0; i<m; i++){
                matrix[i][0]=0;
            }
        }
    }
}
