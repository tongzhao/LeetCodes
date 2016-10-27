import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

 If two nodes are in the same row and column, the order should be from left to right.

 Examples:
 Given binary tree [3,9,20,null,null,15,7],
   3
  / \
 9  20
   /  \
  15   7
 return its vertical order traversal as:
 [
 [9],
 [3,15],
 [20],
 [7]
 ]
 Given binary tree [3,9,20,4,5,2,7],
     _3_
    /   \
   9    20
  / \   / \
 4   5 2   7
 return its vertical order traversal as:
 [
 [4],
 [9],
 [3,5,2],
 [20],
 [7]
 ]
 */

public class SolutionCCCXIV {
    /** Cannot pass test case:
     *
     * Input:
     [5,1,6,null,3,null,null,2,4]
     Output:
     [[1,2],[5,3],[4,6]]
     Expected:
     [[1,2],[5,3],[6,4]]
     cause its order from top to bottom
     *
     */
    /**Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    int leftMostCol = Integer.MAX_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        vertical(root, 0);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int size = map.values().size();
        for (int i = leftMostCol; i < leftMostCol+size; i++) res.add(map.get(i));
        return res;
    }
    public void vertical(TreeNode root, int pos) {
        if (root==null) return;
        update(root, pos);
        leftMostCol = leftMostCol < pos ? leftMostCol : pos;
        vertical(root.left, pos-1);
        vertical(root.right, pos+1);
    }
    public void update(TreeNode node, int pos) {
        if (!map.containsKey(pos)) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.val);
            map.put(pos, list);
        } else {
            map.get(pos).add(node.val);
        }
    }*/

    // with counter level and pos, you can also use comparator for DFS, now using BFS
    class LevelValue implements Comparable<LevelValue> {
        int level;
        int value;
        public LevelValue(int level, int value) {
            this.level = level;
            this.value = value;
        }

        @Override
        public int compareTo(LevelValue o) {
            return this.level-o.level;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<LevelValue>> map = new TreeMap<Integer, List<LevelValue>>();
        helper(root, 0, 0, map);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (Integer key: map.keySet()) {
            List<LevelValue> valueList = map.get(key);
            Collections.sort(valueList);
            List<Integer> intList = new ArrayList<Integer>();
            for (LevelValue v:valueList) {
                intList.add(v.value);
            }
            result.add(intList);
        }
        return result;
    }

    public void helper(TreeNode root, int key, int level, Map<Integer, List<LevelValue>> map) {
        if (root == null) return;
        if (!map.containsKey(key)) map.put(key, new ArrayList<LevelValue>());
        List<LevelValue> theList = map.get(key);
        theList.add(new LevelValue(level, root.val));
        helper(root.left, key-1, level+1, map);
        helper(root.right, key+1, level+1, map);
    }

}


