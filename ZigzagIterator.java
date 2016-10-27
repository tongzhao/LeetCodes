import java.util.Iterator;
import java.util.List;

/**
 * ZigZag Iterator:
 *
 * Given 2 lists of integers
 */
public class ZigzagIterator {
    Iterator<Integer> iter1;
    Iterator<Integer> iter2;
    Iterator<Integer> tmp;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iter1 = v1.iterator();
        iter2 = v2.iterator();
    }

    public int next() throws Exception {
        if (!hasNext()) throw new Exception("No next int");
        if (iter1.hasNext()) {
            tmp = iter1;
            iter1 = iter2;
            iter2 = tmp;
        }
        return iter2.next();
    }

    public boolean hasNext() {
        return iter1.hasNext() || iter2.hasNext();
    }
}
