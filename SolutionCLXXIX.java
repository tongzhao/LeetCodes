import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class SolutionCLXXIX {
    public String largestNumber(int[] num) {
        int len = num.length;
        String array[] = new String[len];
        for (int i = 0; i < len; i++) {
            array[i] = String.valueOf(num[i]);
        }
        Arrays.sort(array, new MySort());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            sb.append(array[i]);
        }
        String result = sb.toString();
        // check for empty string result
        if ("".equals(result.replace("0",""))) {
            return "0";
        }
        return sb.toString();
    }

    public class MySort implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o2 + o1).compareTo(o1 + o2);
        }
    }
}
