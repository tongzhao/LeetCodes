/**
 * 338. Counting Bits
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].

 Follow up:

 It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 Space complexity should be O(n).
 */
public class SolutionCCCXXXVIII {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        int pow = 1;
        for (int i = 1, t = 0; i <= num; i++, t++) {
            if (i==pow) {
                pow *= 2;
                t = 0;
            }
            res[i] = res[t] + 1;
        }
        return res;
    }
}
