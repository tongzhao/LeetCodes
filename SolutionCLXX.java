import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.

 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.
 */
public class SolutionCLXX {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public void add(int x) {
        if (map.containsKey(x)) map.put(x, map.get(x)+1);
        else map.put(x, 1);
    }
    public boolean find(int x) {
        for (int i : map.keySet()) {
            if (map.containsKey(x-i)) {
                if (i == x-i && map.get(i) < 2) continue;
                return true;
            }
        }
        return false;
    }
}
