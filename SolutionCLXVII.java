/**
 * Two Sum II – Input array is sorted (Java)
 */
public class SolutionCLXVII {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers==null || numbers.length < 2) return null;
        int i = 0;
        int j = numbers.length-1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        return null;
    }
}
