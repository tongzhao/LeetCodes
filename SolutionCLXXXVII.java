import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class SolutionCLXXXVII {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        if (s == null || s.length() < 10) return list;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        for (int i = 0; i + 10 <= s.length(); i++) {
            int hash = stringToHash(s.substring(i, i + 10));
            if (map.containsKey(hash)) {
                if (!map.get(hash)) {
                    list.add(s.substring(i, i + 10));
                    map.put(hash, true);
                }
            } else {
                map.put(hash, false);
            }
        }
        return list;
    }

    private int stringToHash (String s) {
        String numberBuilder = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') numberBuilder += "0";
            if (s.charAt(i) == 'C') numberBuilder += "1";
            if (s.charAt(i) == 'G') numberBuilder += "2";
            if (s.charAt(i) == 'T') numberBuilder += "3";
        }
        return Integer.parseInt(numberBuilder, 4);
    }
}
