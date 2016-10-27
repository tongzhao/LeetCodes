public class SolutionVI {
    public String convert(String s, int numRows) {
        if (s==null || s.length() <= numRows || numRows == 1) return s;
        int zigzag = 1;
        int count = 0;
        String[] strs = new String[numRows];
        for (int i=0; i<numRows; i++) {
            strs[i] = "";
        }
        for (int i=0; i<s.length(); i++) {
            if (count==0) zigzag = 1;
            else if (count==numRows-1) zigzag = -1;
            strs[count] += s.charAt(i);
            count += zigzag;
        }
        String result = "";
        for(String sb: strs) {
            result += sb;
        }
        return result;
    }
}
