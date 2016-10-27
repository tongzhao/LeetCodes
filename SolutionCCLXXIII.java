import java.util.ArrayList;
import java.util.List;

/**
 * Integer to English Word:
 *
 * Convert a non-negative integer to its english words representation.
 * Given input is guaranteed to be less than 2^31 - 1.

 For example,
 123 -> "One Hundred Twenty Three"
 12345 -> "Twelve Thousand Three Hundred Forty Five"
 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class SolutionCCLXXIII {
    public static String numberToWords(int num) {
        if (num==0) return "Zero";
        String[] units = {"", "Thousand", "Million", "Billion"};
        String valid = String.valueOf(num);
        int len = valid.length();
        String chunk = "";
        String res = "";
        List<String> list = new ArrayList<String>();
        for (int i = len-1; i >= 0; i--) {
            chunk = valid.charAt(i) + chunk;
            if (chunk.length()==3 || i==0) {
                String chunkNumber = chunkNumber(chunk).trim();
                list.add(chunkNumber);
                chunk = "";
            }
        }
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i).length()==0) continue;
            res += list.get(i) + " " + units[i] + " ";
        }
        return res.trim();
    }
    public static String chunkNumber(String s) {
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] teners = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        if (s.length()==0 || s.equals("0") || s.equals("00") || s.equals("000")) return "";
        String valid = String.valueOf(Integer.parseInt(s));
        int len = valid.length(); // avoid "020"
        if (len==1) return ones[valid.charAt(0)-'0'];
        if (len==2) {
            String res;
            // 302 ? below
            int c1 = valid.charAt(0)-'0';
            int c2 = valid.charAt(1)-'0';
            res = (c1==1) ? teners[c2] : tens[c1] + " " + ones[c2];
            return res.trim();
        }
        else {
            return ones[valid.charAt(0)-'0'] + " Hundred " + chunkNumber(s.substring(1)).trim();
        }
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(12345));
        System.out.println(chunkNumber("00")+"Hello");
        System.out.println(numberToWords(3000));
        System.out.println(numberToWords(300));
        System.out.println(numberToWords(302));
        System.out.println(numberToWords(10000));
        System.out.println(numberToWords(100000));
        System.out.println(numberToWords(1000000));
        System.out.println(numberToWords(10000000));
    }
}
