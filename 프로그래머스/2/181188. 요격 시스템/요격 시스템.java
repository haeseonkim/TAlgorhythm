import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> { 
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int end = targets[0][1];
        answer++;
        
        for(int[] target: targets){
            // end가 구간에 들어가지 않는다면 end 재설정 , 요격수 증가
            if(target[0] >= end){   // 개구간이기때문에 =도 포함
                end = target[1];
                answer++;
            }
        }
    
        return answer;
    }
}