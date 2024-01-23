import java.util.*;
import java.util.stream.*;

class Solution {
    
    private static Map<String, Integer> playerInfo = new HashMap<>();
    
    public String[] solution(String[] players, String[] callings) {
        makeInfo(players);
        
        Arrays.stream(callings).forEach(player -> {
            int idx = playerInfo.get(player);
            String frontPlayer = players[idx-1];
            players[idx] = frontPlayer;
            players[idx-1] = player;
            
            playerInfo.put(player, idx-1);
            playerInfo.put(frontPlayer, idx);
        });
        
        return players;
    }
    
    private void makeInfo(String[] players){
        // 인덱스를 함께 뽑아내려고 IntStream을 사용 
        IntStream.range(0, players.length).forEach(index -> playerInfo.put(players[index], index));
    }
}