public class SolutionXIV {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        for (String s: strs) {
            if (s.length()==0 || res.length()==0) return "";
            res = helper(res, s);
        }
        return res;
    }
    public String helper(String s, String t) {
        int i = 0;
        while (i<Math.min(s.length(), t.length())) {
            if (s.charAt(i) != t.charAt(i)) return s.substring(0, i);
            i++;
        }
        return s.substring(0, i);
    }
}
