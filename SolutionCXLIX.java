import java.awt.Point;
import java.util.HashMap;

/**
 * Max point in a line
 */
public class SolutionCXLIX {
    public int maxPoints(Point[] points){
        if(points.length==0) return 0;
        int len = points.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<len; i++){
            int linemax = 0;
            int same = 0;
            int vertical = 0;
            HashMap<Float, Integer> slope = new HashMap<Float, Integer>();
            for(int j=0; j<len; j++){ // from 0! count itself
                // 1. same point
                if(points[i].x==points[j].x && points[i].y==points[j].y) {
                    same++;
                    continue;
                }
                // 2. vertical, no slope, no same
                if(points[i].x==points[j].x && points[i].y!=points[j].y) {
                    vertical++;
                    if(vertical>linemax){
                        linemax = vertical;
                    }
                }
                // 3. slope
                float k = ((float) (points[i].y - points[j].y))/(points[i].x - points[j].x); // !!! type cast!!!
                if(slope.containsKey(k)){
                    slope.put(k, slope.get(k)+1);
                }
                else{
                    slope.put(k,1);
                }
                if(slope.get(k)>linemax){
                    linemax = slope.get(k);
                }
            }
            if(same+linemax>max)
                max = same+linemax;
        }
        return max;
    }
}
