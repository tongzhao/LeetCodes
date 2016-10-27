import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 For example, given k = 3,
 Return [1,3,3,1].
 */
public class SolutionCXIX {
    public ArrayList<Integer> getRow(int rowIndex){
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] tmp = new int[rowIndex+1];
        for(int i=0; i<=rowIndex; i++){
            for(int j=i; j>=0; j--){
                if(j==i || j==0) tmp[j]=1;
                else{
                    tmp[j] = tmp[j-1]+tmp[j];
                }
            }
        }
        for(int i=0; i<=rowIndex; i++){
            res.add(tmp[i]);
        }
        return res;
    }
}
