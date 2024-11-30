import java.util.HashMap;
import java.util.Map;

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();  // 문자 빈도를 저장하는 맵
        int maxCount = 0;  // 윈도우 내에서 가장 많이 등장한 문자 수
        int start = 0;     // 슬라이딩 윈도우의 시작점
        int maxLength = 0; // 가장 긴 동일 문자로 이루어진 문자열의 길이

        // 슬라이딩 윈도우를 확장
        for (int end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1); // 문자 빈도 업데이트

            // 현재 윈도우에서 가장 많이 등장한 문자의 수 갱신
            maxCount = Math.max(maxCount, map.get(currChar));

            // (윈도우 크기) - (가장 많이 등장한 문자 수) > k 인 경우 윈도우 축소
            if (end - start + 1 - maxCount > k) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1); // 시작 문자의 빈도 감소
                start++;  // 윈도우 시작점 이동

                // // 윈도우 축소 후, 다시 `maxCount`를 정확하게 갱신
                // maxCount = 0;
                // for (int value : map.values()) {
                //     maxCount = Math.max(maxCount, value);
                // }
            }

            // 최대 길이 갱신
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
