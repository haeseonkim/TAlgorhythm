import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> extMap = new HashMap<>();
        List<List<Integer>> dataList = new ArrayList<>();

        extMap.put("code", 0);
        extMap.put("date", 1);
        extMap.put("maximum", 2);
        extMap.put("remain", 3);
        
        int extKey = (int)extMap.get(ext);
        
        for(int i = 0; i < data.length; i++){
            if(data[i][extKey] < val_ext){
                dataList.add(Arrays.stream(data[i]).boxed().collect(Collectors.toList()));
            }
        }
        
        int[][] answer = new int[dataList.size()][];
        for(int i = 0; i < answer.length; i++){
            answer[i] = dataList.get(i).stream().mapToInt(k->k).toArray();
        }
    
        Arrays.sort(answer, Comparator.comparingInt((int[] o) -> o[extMap.get(sort_by)]));
        
        return answer;
    }
}