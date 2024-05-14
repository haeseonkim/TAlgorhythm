import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        HashMap<Integer, Integer> xmap = new HashMap<>();
        HashMap<Integer, Integer> ymap = new HashMap<>();
        
        for(String xx : X.split("")){
            int cur = Integer.parseInt(xx);
            xmap.put(cur, xmap.getOrDefault(cur, 0) + 1);
        }
        
        for(String yy : Y.split("")){
            int cur = Integer.parseInt(yy);
            ymap.put(cur, ymap.getOrDefault(cur, 0) + 1);
        }
        
        StringBuilder s = new StringBuilder();
        
        for(int i = 9; i >= 0; i--){
            if(xmap.containsKey(i) && ymap.containsKey(i)){
                int cnt = Math.min(xmap.get(i), ymap.get(i));
                for(int j = 0; j < cnt; j++){
                    s.append(i);
                }
            }
        }
        
        if(s.toString().startsWith("0")) return "0";
        else if(s.toString().equals("")) return "-1";
        
        return s.toString();
    }
    

}