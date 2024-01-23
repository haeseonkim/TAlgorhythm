import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        List<String> nameList = new ArrayList<String>(Arrays.asList(name));
        for(int i=0; i<photo.length; i++){
            int miss = 0; 
            for(int j=0; j<photo[i].length; j++){
                System.out.println(photo[i][j]);
                miss += nameList.indexOf(photo[i][j]) == -1 ? 
                    0 : yearning[nameList.indexOf(photo[i][j])];
            }    
            answer[i] = miss;
        }
        
        return answer;
    }
}