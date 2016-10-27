import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolutionXXX {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int numWords = words.length;
        if (numWords==0 || s==null || s.length()==0) return res;
        int wordLen = words[0].length();
        int totalLen = numWords * wordLen;
        if (totalLen > s.length()) return res;
        HashMap<String, Integer> target = new HashMap<String, Integer>();
        for (int i=0; i<numWords; i++) {
            if (!target.containsKey(words[i])) target.put(words[i], 1);
            else target.put(words[i], target.get(words[i])+1);
        }
        int i = 0;
        while (i<=s.length() - totalLen) {
            HashMap<String, Integer> tmp = new HashMap<String, Integer>(target);
            for (int j=0; j<numWords; j++) {
                String test = s.substring(i+j*wordLen, i+(j+1)*wordLen);
                if(tmp.containsKey(test)) {
                    if(tmp.get(test)==1) tmp.remove(test);
                    else tmp.put(test, tmp.get(test)-1);
                }
                else break;
            }
            if (tmp.size()==0) res.add(i);
            i++;
        }
        return res;
    }
}
