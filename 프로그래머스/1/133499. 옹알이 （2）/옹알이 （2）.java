class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String word : babbling){
            boolean flag = isValidWord(word);
            if(flag) answer++;
        }
        
        return answer;
    }
    
    private boolean isValidWord(String word){
        String[] validSounds = {"aya", "ye", "woo", "ma"};
        for(String sound : validSounds){
            word = word.replace(sound, "-");
            if(word.contains("--")) break;
            else{
                word = word.replace("-"," ");
            }
        }
        return word.isBlank();
    }
}