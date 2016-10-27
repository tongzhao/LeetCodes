/**
 * Sparse Matrix Multiplication
 *
 * Given two sparse matrices A and B, return the result of AB.

 You may assume that A's column number is equal to B's row number.

 Example:

 A = [
 [ 1, 0, 0],
 [-1, 0, 3]
 ]

 B = [
 [ 7, 0, 0 ],
 [ 0, 0, 0 ],
 [ 0, 0, 1 ]
 ]


      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                   | 0 0 1 |
 */
public class SolutionCCCX {
    public int[][] multiply(int[][] A, int[][] B) {
        int x = A.length;
        int y = A[0].length;
        int z = B[0].length;
        int[][] C = new int[x][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (A[i][j] != 0) {
                    for (int l = 0; l < z; l++) {
                        C[i][l] += (B[j][l] == 0) ? 0 : A[i][j]*B[j][l];
                    }
                }
            }
        }
        return C;
    }
}
