public class SolutionV {
    public String longestPalindrome(String s) {
        String res = "";
        if (s==null || s.length()==0) return res;
        int i = 0;
        while (i < s.length()) {
            String tmp = getPalin(s, i, i);
            res = res.length() > tmp.length() ? res : tmp;
            tmp = getPalin(s, i, i+1);
            res = res.length() > tmp.length() ? res : tmp;
            i++;
        }
        return res;
    }
    public String getPalin(String s, int i, int j) {
        while (i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}
