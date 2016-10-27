/**
 * 370. Range Addition
 *
 * Example:

 Given:

 length = 5,
 updates = [
 [1,  3,  2],
 [2,  4,  3],
 [0,  2, -2]
 ]

 Output:

 [-2, 0, 3, 5, 3]
 Explanation:

 Initial state:
 [ 0, 0, 0, 0, 0 ]

 After applying operation [1, 3, 2]:
 [ 0, 2, 2, 2, 0 ]
 ==> [0, 2, 0, 0, -2]

 After applying operation [2, 4, 3]:
 [ 0, 2, 5, 5, 3 ]
 ==> [0, 2, 3, 0, -2]

 After applying operation [0, 2, -2]:
 [-2, 0, 3, 5, 3 ]
 ==> [-2, 2, 3, 2, -2]

 ===> [-2, 0, 3, 5, 3]
 */
public class SolutionCCCLXX {
    // just add that value to the start index and minus it in the (end index + 1)
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] op: updates) {
            res[op[0]] += op[2];
            if (op[1] < length - 1) res[op[1]+1] -= op[2];
        }
        for (int i = 1; i < length; i++) {
            res[i] += res[i-1];
        }
        return res;
    }
}
