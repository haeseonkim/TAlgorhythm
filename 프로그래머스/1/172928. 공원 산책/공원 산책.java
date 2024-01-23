import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[] now = new int[2];
        Map<String, int[]> route = new HashMap<>();
        
        int[] N = {-1,0};
        int[] S = {1, 0};
        int[] W = {0, -1};
        int[] E = {0, 1};
        route.put("N", N);
        route.put("S", S);
        route.put("W", W);
        route.put("E", E);
        
        // 시작위치 now로 set하기
        for(int i=0; i<park.length; i++){
            for(int j = 0; j<park[0].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    now[0] = i;
                    now[1] = j;
                }
            }
        }
        
        // routes 돌기
        for(int i=0; i<routes.length; i++){
            String way = routes[i].split(" ")[0];
            int count = Integer.parseInt(routes[i].split(" ")[1]);
            boolean flag = false;
            int[] step = route.get(way);
            int[] move = new int[2];
            move[0] = now[0];
            move[1] = now[1];
            
            // park 넘어가는지 체크
            if(now[0] + step[0]*count >= park.length || now[0] + step[0]*count < 0
              || now[1] + step[1]*count >= park[0].length() || now[1] + step[1]*count < 0){
                flag = true;
            }else {
                // X 만나는지 체크
                for(int k = 1; k<=count; k++){
                    if(park[move[0] + step[0]].charAt(move[1] + step[1]) == 'X'){
                        flag = true;
                        break;
                    }
                    move[0] += step[0];
                    move[1] += step[1];
                }
            }
            
            
            if(!flag){
                now[0] = move[0];
                now[1] = move[1];
            }
        
        }
        
        answer[0] = now[0];
        answer[1] = now[1];
        
        
        return answer;
    }
}