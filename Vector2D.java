import java.util.Iterator;
import java.util.List;

/**
 * Flatten a 2D array:
 *
 * Implement an iterator to flatten a 2d vector.

 For example,

 Given 2d vector =

 [
 [1,2],
 [3],
 [4,5,6]
 ]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 */
public class Vector2D {

    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public int next() {
        hasNext(); // same logic to check
        return j.next();
    }

    public boolean hasNext() {
        // change another line
        while ((j==null || !j.hasNext()) && i.hasNext()) {
            j = i.next().iterator();
        }
        return j!=null && j.hasNext();
    }
}
