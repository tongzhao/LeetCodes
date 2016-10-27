import java.util.Arrays;

public class SolutionIII {
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0) return 0;
        // to record the index and easy to set
        boolean[] set = new boolean[256];
        Arrays.fill(set, false);
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int hash = s.charAt(right);
            while (set[hash] && left < right) {
                int temp = s.charAt(left);
                set[temp] = false;
                left++;
            }
            set[hash] = true;
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}
