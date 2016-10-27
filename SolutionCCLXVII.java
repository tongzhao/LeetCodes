import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Palindrome Permutation II:
 Given a string s, return all the palindromic permutations (without duplicates) of it.
 Return an empty list if no palindromic permutation could be form.
 For example:
 Given s = "aabb", return ["abba", "baab"].
 Given s = "abc", return [].
 */
public class SolutionCCLXVII {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<String>();
        if (!canPermutePalindrome(s)) return res;
        List<Character> list = new ArrayList<Character>();
        // add half count of chars
        String mid = "";
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 != 0) mid += key;
            for (int i = 0; i < val/2; i++) list.add(key);
        }
        // generate perms
        generatePerms(list, mid, new boolean[list.size()], new StringBuilder(), res);
        return res;
    }

    // permutation
    public void generatePerms(List<Character> list, String mid, boolean[] visited, StringBuilder tmp, List<String> res) {
        if (tmp.length() == visited.length) {
            res.add(tmp.toString() + mid + tmp.reverse().toString());
            tmp.reverse();
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            // IMPORTANT!!! As permutation
            // IN-ORDER, when list.get(i), i-1 should be visited;
            // if visited[i-1] == false, which means go on next round of picking i,
            // so if pick the same char, will lead to repetition, then just skip.
            if (i>0 && list.get(i) == list.get(i-1) && !visited[i-1]) continue;
            if (!visited[i]) {
                visited[i] = true;
                tmp.append(list.get(i));
                generatePerms(list, mid, visited, tmp, res);
                visited[i] = false;
                tmp.deleteCharAt(tmp.length()-1);
                // or just update here:
                // while(i+1<list.size() && list.get(i)==list.get(i+1)) i++; // as permutations
            }
        }
    }

    public boolean canPermutePalindrome(String s) {
        if (s==null || s.length()<=1) return true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }
        int count = 0;
        for (int i: map.values()) {
            if (i % 2==1) count++;
        }
        return count <= 1;
    }
}
