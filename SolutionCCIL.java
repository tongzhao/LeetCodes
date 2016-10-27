import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string, we can “shift” each of its letter to its successive letter,
 * for example: “abc” -> “bcd”. We can keep “shifting” which forms the sequence:

 1
 "abc" -> "bcd" -> ... -> "xyz"
 Given a list of strings which contains only lowercase alphabets,
 group all strings that belong to the same shifting sequence.

 For example,

 given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], Return:

 1
 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]
 Note: For the return value, each inner list’s elements must follow the lexicographic order.
 */
public class SolutionCCIL {
    public List<List<String>> groupStrings(String[] strings) {

        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(String word : strings){
            String key = "";
            int offset = word.charAt(0) - 'a';
            for(int i = 1; i < word.length(); i++){
                key += (word.charAt(i) - offset + 26) % 26;
            }

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(word);
        }

        for(List<String> list : map.values()){
            Collections.sort(list);
            res.add(list);
        }

        return res;

    }
}
