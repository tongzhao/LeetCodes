import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Note: Each word is guaranteed not to exceed L in length.
 */
public class SolutionLXVIII {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if (words==null || words.length==0) return res;
        int length = 0;
        int count = 0;
        int start = 0;
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            length += s.length();
            count++;
            if (length + (count-1) > maxWidth) {
                List<String> tmp = new ArrayList<String>();
                count--;
                for (int j = start; j < start+count; j++) {
                    tmp.add(words[j]);
                }
                res.add(justify(tmp, maxWidth));
                length = 0;
                count = 0;
                start = i;
                i--;
            }
        }
        if (count > 0) {
            List<String> tmp = new ArrayList<String>();
            for (int j = start; j < start+count; j++) {
                tmp.add(words[j]);
            }
            res.add(justify(tmp, maxWidth));
        }
        return res;
    }
    public static String justify(List<String> list, int maxWidth) {
        int numWords = list.size();
        String res = "";
        if (numWords==0) {
            for (int i = 0; i < maxWidth; i++) {
                res += " ";
            }
            return res;
        }
        if (numWords==1) {
            res += list.get(0);
            while(res.length() < maxWidth) {
                res += " ";
            }
            return res;
        }
        int numChars = 0;
        for (String s: list) {
            numChars += s.length();
        }
        int space = (maxWidth-numChars)/(numWords-1);
        int remain = (maxWidth-numChars)%(numWords-1);
        String sp = "";
        for (int i = 0; i < space; i++) sp += " ";
        for (int i = 0; i < numWords-1; i++) {
            res += list.get(i);
            res += i < remain ? sp + " " : sp;
        }
        res += list.get(list.size()-1);
        return res;
    }
    public static void main(String[] args) {
        String[] test = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> res = fullJustify(test, 16);
        for (String s: res) System.out.println(s);

        List<String> test1 = new ArrayList<String>();
//        test1.add("example");
//        test1.add("of");
//        test1.add("text");
        test1.add("justification.");
        System.out.println(justify(test1, 16));
    }
}
