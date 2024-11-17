class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 문자열을 첨부터 끝까지 돌면서 사전의 단어와 일치하는지 비교한다.
        // 일치할때, 그 전의 문자열도 일치했었는지가 중요하다. 
        // 그래서 이를 저장해서 확인할 수 있는 문자열과 비슷한 길이의 배열이 필요하다. 
        // => dp의 중요 개념 중 하나! 저장!
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        // substring 할때 해당 인덱스 전까지 자르므로 1부터 시작!
        for(int i = 1; i <= s.length(); i++){
            for(String word: wordDict){
                // 사전의 단어와 일치하는지 보려면 사전의 단어별로 시작점을 각각 잡아야함! 단어별로 길이가 다르기때문.
                int start = i - word.length();
                // 사전의 단어와 일치하고, 
                // 지금 일치하는 단어 전 문자열도 사전에 있었는지(dp[start]의 값이 true) 확인!
                if(start >= 0 && dp[start] && s.substring(start,i).equals(word)){
                    // 사전에 있었다고 표시
                    dp[i] = true;
                    break;
                }
            }
        }

        // dp[]의 true 체크 조건이, 직전 것들이 모두 사전에 있었다(true)라는 조건이기에
        // 맨 마지막 요소가 그 결과임.
        return dp[s.length()];
    }
}