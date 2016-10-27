public class SolutionVIII {
    public int myAtoi(String str) {
        str = str.trim();
        long res = 0;
        if (str.length()==0) return (int)res;
        int sign = 1;
        long min = -(long)Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int i = 0;
        while(i< str.length()) {
            char c = str.charAt(i);
            if(i==0) {
                if (c=='+') sign = 1;
                else if (c=='-') sign = -1;
                else if (c>'9' || c<'0') break;
                else res = 10 * res + (c - '0');
                i++;
                continue;
            }
            if (c < '0' || c > '9') break;
            int val = (int)(c - '0');
            res = 10 * res + val;
            i++;
            if (sign > 0 && res > max) return Integer.MAX_VALUE;
            if (sign < 0 && res > min) return Integer.MIN_VALUE;
        }
        return sign > 0 ? (int)res : -(int)res;
    }
}
