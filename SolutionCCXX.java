import java.util.Arrays;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the difference between nums[i] and nums[j] is at most t
 * and the difference between i and j is at most k
 */
class ValPosPair implements Comparable<ValPosPair>{
    int val;
    int pos;
    public ValPosPair(int val, int pos){
        this.val = val;
        this.pos = pos;
    }
    public int compareTo(ValPosPair x) {
        return this.val - x.val;
    }
}
public class SolutionCCXX {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length<2 || k < 1 || t < 0) return false;
        ValPosPair[] valPosPairs = new ValPosPair[nums.length];
        for (int i = 0; i < valPosPairs.length; i++) valPosPairs[i] = new ValPosPair(nums[i], i);
        Arrays.sort(valPosPairs);
        for (int i = 0; i < valPosPairs.length; i++) {
            for (int j = i+1; j < valPosPairs.length &&
                              ((long)valPosPairs[j].val - (long)valPosPairs[i].val <= (long)t);
                 j++) {
                if (Math.abs(valPosPairs[j].pos - valPosPairs[i].pos) <= k) return true;
            }
        }
        return false;
    }
}
