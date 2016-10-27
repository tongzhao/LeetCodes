import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.
 */
public class SolutionCCXV {
    public int findKthLargest(int[] nums, int k) {
        // maintain a min heap, peek is the smallest in the heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int num: nums) {
            if (pq.size() < k) {
                pq.add(num);
            } else if (pq.peek() < num) {
                pq.remove();
                pq.add(num);
            }
        }
        return pq.peek();
    }
}
