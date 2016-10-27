import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits,
 * restore it by returning all possible valid IP address combinations.
 For example:
 Given "25525511135",
 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class SolutionXCIII {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        String tmp = "";
        find(s, res, tmp, 4);
        return res;
    }
    public void find(String s, List<String> res, String tmp, int count) {
        if (count==1) {
            if (isValidIp(s)) {
                res.add(tmp+s);
            }
            return;
        }
        for (int i = 1; i < s.length() && i < 4; i++) {
            String ss = s.substring(0, i);
            if (isValidIp(ss)) find(s.substring(i), res, tmp+ss+".", count-1);
        }
    }
    public boolean isValidIp(String s){
        if(s.charAt(0)=='0') return s.length()==1;
        try{
            int valid = Integer.parseInt(s);
            return (valid>=0 && valid<=255);
        }
        catch(Exception e){
            return false;
        }
    }
}
