public class SolutionXLIII {
    public String multiply(String s1, String s2) {
        /**
         * 3 4 5
         *   6 7
         */
        String res = "";
        if (s1==null || s2==null || s1.length()==0 || s2.length()==0) return res;
        boolean sign = true;
        if (s1.charAt(0)=='-') {
            sign = !sign;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0)=='-') {
            sign = !sign;
            s2 = s2.substring(1);
        }
        int len1 = s1.length();
        int len2 = s2.length();
        char[] result = new char[len1+len2];

        for (int i = len1-1; i>=0; i--) {
            int n1 = s1.charAt(i) - '0';
            int carry = 0;
            for (int j = len2-1; j>=0; j--) {
                int n2 = s2.charAt(j) - '0';
                int val = n1 * n2 + carry + (result[i+j+1] - '0' > 0 ? result[i+j+1] - '0' : 0);
                carry = val / 10;
                val = val % 10;
                result[i+j+1] = (char)('0'+val);
            }
            if(carry>0) result[i] = (char)('0'+carry);
        }
        String str = new String(result).trim();
        return (str.charAt(0)=='0') ? "0" : str;

    }
}
