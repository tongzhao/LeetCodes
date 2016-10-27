import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class SolutionCXX {
    public int minimumTotal(List<List<Integer>> triangle){
        if(triangle.size()==0) return 0;
        int size = triangle.size();
        int[] res = new int[size];
        for(int i=0; i<size; i++){
            for(int j=i; j>=0; j--){
                if(j==0){
                    res[j] = res[0] + triangle.get(i).get(j);
                }
                else if(j==i){
                    res[j] = res[j-1] + triangle.get(i).get(j);
                }
                else{
                    res[j] = Math.min(res[j-1], res[j]) + triangle.get(i).get(j);
                }

            }
        }
        int val = Integer.MAX_VALUE;
        for(int i=0; i<size; i++){
            if(val>res[i]) val = res[i];
        }
        return val;
    }
}
