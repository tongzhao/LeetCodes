import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators,
 * return all possible results from computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.


 Example 1
 Input: "2-1-1".

 ((2-1)-1) = 0
 (2-(1-1)) = 2
 Output: [0, 2]


 Example 2
 Input: "2*3-4*5"

 (2*(3-(4*5))) = -34
 ((2*3)-(4*5)) = -14
 ((2*(3-4))*5) = -10
 (2*((3-4)*5)) = -10
 (((2*3)-4)*5) = 10
 Output: [-34, -14, -10, -10, 10]
 */
public class SolutionCCXLI {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c=='+' || c=='-' || c=='*') {
                String s1 = input.substring(0, i);
                String s2 = input.substring(i+1);
                List<Integer> part1 = diffWaysToCompute(s1);
                List<Integer> part2 = diffWaysToCompute(s2);
                for (int i1: part1) {
                    for (int i2: part2) {
                        int result = 0;
                        switch (c) {
                            case '+': result = i1 + i2; break;
                            case '-': result = i1 - i2; break;
                            case '*': result = i1 * i2; break;
                        }
                        res.add(result);
                    }
                }
            }
        }
        if (res.size()==0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
