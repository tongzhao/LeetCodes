public class SolutionLVIII {
    public static int lengthOfLastWord(String s) {
        if (s==null || s.length()==0) return 0;
        s = s.trim();
        int i = s.length()-1;
        while (i>=0) {
            if (s.charAt(i) == ' ') return s.length()-1-i;
            i--;
        }
        return s.length();
    }

    public static void main(String[] args) {
        String s = "b a  ";
        s = s.trim();
        System.out.println(s.length());
        System.out.println(lengthOfLastWord(s));
    }
}
