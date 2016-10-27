import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class SolutionCXVIII {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0; i<numRows; i++){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                if(j==0||j==i) tmp.add(1);
                else tmp.add(0);
            }
            res.add(tmp);
        }
        for(int i=2; i<numRows; i++){
            for(int j=1; j<i; j++){
                res.get(i).set(j, res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
        }
        return res;
    }
}
