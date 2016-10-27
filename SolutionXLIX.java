import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionXLIX {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs==null || strs.length==0) return res;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s: strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String str = new String(c);
            if (!map.containsKey(str)) {
                List<String> tmp = new ArrayList<String>();
                tmp.add(s);
                map.put(str, tmp);
            } else {
                map.get(str).add(s);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
