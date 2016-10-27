import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
 For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
 */
public class SolutionCLXIII {
    public static List<String> findMissingRanges(int[] vals, int start, int end) {
        List<String> res = new ArrayList<String>();
        if (vals==null || vals.length==0) {
            res.add(missingFormat(start, end));
            return res;
        }
        if (start != vals[0]) res.add(missingFormat(start, vals[0]-1));
        int i = 1;
        while (i < vals.length) {
            if (vals[i-1] + 1 != vals[i]) {
                res.add(missingFormat(vals[i-1]+1, vals[i]-1));
            }
            i++;
        }
        if (end != vals[vals.length-1]) res.add(missingFormat(vals[vals.length-1]+1, end));
        return res;
    }
    public static String missingFormat(int left, int right) {
        if (left==right) return Integer.toString(left);
        return Integer.toString(left) + "->" + Integer.toString(right);
    }
    public static void main(String[] args) {
        int[] vals = {0, 1, 3, 50, 75, 98};
        int[] vals1 = {};
        List<String> res = findMissingRanges(vals1, 1, 2);
        for (String s: res) {
            System.out.println(s);
        }
    }
}
