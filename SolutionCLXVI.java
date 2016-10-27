import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class SolutionCLXVI {
    public String fractionToDecimal(int numerator, int denominator) {
        // if 13.2869696969... then you know, 6 appears again after first 69, recursive happens
        if (numerator==0) return new String("0");
        StringBuffer res = new StringBuffer();
        boolean flag = (numerator<0) ^ (denominator<0);
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        if (flag) res.append("-");
        res.append(String.valueOf(num/den));
        num = num % den;
        if (num==0) return res.toString();
        res.append(".");
        // <Result, Index>
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        for (int i = res.length(); num!=0; i++) {
            if (map.get(num) != null) break;
            map.put(num, i);
            num = num * 10;
            res.append(String.valueOf(num/den));
            num = num % den;
        }
        if (num==0) return res.toString();
        res.insert(map.get(num), "(");
        res.append(")");
        return res.toString();
    }
}
