public class SolutionXXXVIII {
    public String countAndSay(int n){
        if(n<=0) return null;
        String res = "1";
        for(int i=1; i<n; i++){
            res = sayIt(res);
        }
        return res;
    }
    public String sayIt(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            int count = 1;
            while((i+1)<s.length() && s.charAt(i)==s.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(String.valueOf(count)+String.valueOf(s.charAt(i)));
        }
        return sb.toString();
    }
}
