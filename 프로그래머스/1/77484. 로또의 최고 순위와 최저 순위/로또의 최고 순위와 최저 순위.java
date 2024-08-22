import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int zero = 0;
        for(int num : lottos){
            if(num == 0) zero ++;
        }
        
        int equals = 0;
    
        for(int num1 : win_nums){
            for(int num2 : lottos){
                if(num2 == num1) equals++;
            }
        }
        
        answer[0] = 6-(equals+zero) + 1 >= 6 ? 6 : 6-(equals+zero)+1;
        answer[1] = 6-(equals)+1 >= 6 ? 6 : 6-(equals)+1;
            
        return answer;
    }
}