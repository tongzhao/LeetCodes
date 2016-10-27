/**
 * 408. Valid Word Abbreviation
 *
 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

 A string such as "word" contains only the following valid abbreviations:

 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

 Note:
 Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

 Example 1:
 Given s = "internationalization", abbr = "i12iz4n":

 Return true.
 Example 2:
 Given s = "apple", abbr = "a2e":

 Return false.
 */
public class SolutionCDVIII {
    public static boolean validWordAbbreviation(String word, String abbr) {
        if (word==null || word.length()==0) return abbr.equals("");
        if (word.length() > 0 && abbr.length()==0) return false;
        if (Character.isDigit(abbr.charAt(0))) {
            int i = 0;
            int count = 0;
            while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
                int val = Integer.parseInt(abbr.substring(i, i+1));
                if (val==0 && i==0) return false;
                count = 10 * count + val;
                i++;
            }
            if (word.length() < count) return false;
            return validWordAbbreviation(word.substring(count), abbr.substring(i));
        }
        return word.charAt(0) == abbr.charAt(0) && validWordAbbreviation(word.substring(1), abbr.substring(1));
    }
    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("apple", "a3e"));
        System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(validWordAbbreviation("apple", "a2e"));
        System.out.println(validWordAbbreviation("hi", "1"));
        System.out.println(validWordAbbreviation("a", "01"));
    }
}
