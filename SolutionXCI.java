/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.
 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 The number of ways decoding "12" is 2.
 */
public class SolutionXCI {
    public int numDecodings(String s) {
        if (s.length()==0 || s.charAt(0)=='0') return 0;
        if (s.length()==1) return 1;
        int[] res = new int[s.length()];
        int[] code = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            code[i] = Integer.parseInt(s.substring(i, i+1));
            if (code[i]==0) {
                if (code[i-1]!=1 && code[i-1]!=2) return 0;
            }
        }
        res[0] = code[1]==0 ? 0 : 1;
        int first = 10*code[0]+code[1];
        res[1] = first%10==0 || first>26 ? 1 : 2;
        for (int i  = 2; i < s.length(); i++) {
            int num = 10*code[i-1]+code[i];
            if (num==10 || num==20) res[i] = res[i-2];
            else if (num>10 && num<=26) res[i] = res[i-1] + res[i-2];
            else res[i] = res[i-1];
        }
        return res[s.length()-1];
    }
}
