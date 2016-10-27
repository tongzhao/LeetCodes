/**
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */
public class SolutionLXVII {
    public String addBinary(String a, String b) {
        String res = "";
        if ((a==null || a.length()==0) && (b==null || b.length()==0)) return res;
        int carry = 0;
        int ia = a.length()-1;
        int ib = b.length()-1;
        while (ia >= 0 && ib >= 0) {
            int va = a.charAt(ia) - '0';
            int vb = b.charAt(ib) - '0';
            int val = va + vb + carry;
            carry = val / 2;
            val = val % 2;
            res = (val+'0') + res;
            ia--;
            ib--;
        }
        if (carry==0) {
            res = ia >= 0 ? a.substring(0, ia+1) : b.substring(0, ib+1) + res;
        }
        else {
            while (ia >= 0) {
                int va = a.charAt(ia) - '0';
                int val = va + carry;
                carry = val / 2;
                val = val % 2;
                res = (val+'0') + res;
                ia--;
            }
            while (ib >= 0) {
                int vb = a.charAt(ib) - '0';
                int val = vb + carry;
                carry = val / 2;
                val = val % 2;
                res = (val+'0') + res;
                ib--;
            }
        }
        return res;
    }
}
