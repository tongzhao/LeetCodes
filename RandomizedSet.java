import java.util.ArrayList;
import java.util.HashMap;

/**
 * 380. Insert Delete GetRandom O(1)
 *
 * Design a data structure that supports all following operations in average O(1) time.

 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */
public class RandomizedSet {

    public ArrayList<Integer> numbers;
    public HashMap<Integer, Integer> locations;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        numbers = new ArrayList<Integer>();
        locations = new HashMap<Integer, Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locations.containsKey(val)) return false;
        locations.put(val, numbers.size());
        numbers.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locations.containsKey(val)) return false;
        int loc = locations.get(val);
        if (loc != numbers.size()-1) {
            // swap this not end item with the ended one
            int lastOne = numbers.get(numbers.size()-1);
            numbers.set(loc, lastOne);
            locations.put(lastOne, loc);
        }
        locations.remove(val);
        numbers.remove(numbers.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        java.util.Random random = new java.util.Random();
        return numbers.get(random.nextInt(numbers.size()));
    }
}
