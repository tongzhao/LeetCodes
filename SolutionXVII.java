import java.util.ArrayList;
import java.util.List;

public class SolutionXVII {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length()==0) {
            res.add("");
            return res;
        }
        String[] d = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String s = digits.substring(0, 1);
        int val = Integer.parseInt(s);
        List<String> tmp = letterCombinations(digits.substring(1));
        for (int i = 0; i < d[val].length(); i++) {
            for(int j=0; j<tmp.size(); j++){
                res.add(d[val].charAt(i)+tmp.get(j));
            }
        }
        return res;
    }
}
