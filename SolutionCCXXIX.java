import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 */
public class SolutionCCXXIX {
    public List<Integer> majorityElement(int[] nums) {
        int vote1=0, vote2=0, num1=0, num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (vote1!=0 && num1==nums[i]) {vote1++; continue;}
            if (vote2!=0 && num2==nums[i]) {vote2++; continue;}
            if (vote1==0) {num1=nums[i]; vote1++; continue;}
            if (vote2==0) {num2=nums[i]; vote2++; continue;}
            vote1--;
            vote2--;
        }
        int c1=0, c2=0;
        for (int i = 0; i < nums.length; i++) {
            if (vote1 > 0) {
                if (nums[i]==num1) c1++;
            }
            if (vote2 > 0) {
                if (nums[i]==num2) c2++;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        if (c1 > nums.length/3) res.add(num1);
        if (c2 > nums.length/3) res.add(num2);
        return res;
    }
}
