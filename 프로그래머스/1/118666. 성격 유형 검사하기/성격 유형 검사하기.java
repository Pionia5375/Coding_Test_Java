import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        // 문자들에 대한 배열 생성 
        char[] letters = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        
        // 해시맵<캐릭터, 정수> 생성
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < letters.length; i++) {
            map.put(letters[i], 0);
        }
        
        // 서베이의 기준에 따라, 초이스를 보고, 해당 점수를 산정하여 카운트에 추가
        // 서베이의 길이만큼 아래를 반복
        for (int i = 0; i < survey.length; i++) {
            
            // 서베이의 각 요소의 첫 번째 문자를 negative로 저장
            char negative = survey[i].charAt(0);
            
            // 서베이의 각 요소의 두 번째 문자를 positive로 저장
            char positive = survey[i].charAt(1);
            
            // 해당 인덱스의 초이스를 확인, 해당 지표에 따라 점수를 negative 혹은 positive에 저장.
            // 점수가 같다면 (0)이라면, continue
            // 다르다면, 해당 문자의 해시맵에 점수를 더해 push
            if (choices[i] != 4) {
                switch (choices[i]) {
                    case 1:
                        map.put(negative, map.get(negative) + 3);
                        break;
                    case 2:
                        map.put(negative, map.get(negative) + 2);
                        break;
                    case 3:
                        map.put(negative, map.get(negative) + 1);
                        break;
                    case 5:
                        map.put(positive, map.get(positive) + 1);
                        break;
                    case 6:
                        map.put(positive, map.get(positive) + 2);
                        break;
                    case 7:
                        map.put(positive, map.get(positive) + 3);
                        break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 추가가 끝나면 성격 유형에 따라 지표를 분배. 4자리 문자열로 조합
        for (int i = 0; i < 4; i++) {
            
            // 문자 찾기
            char first = letters[i * 2];
            char second = letters[i * 2 + 1];
            
            // 배열 할당
            if (map.get(first) >= map.get(second)) sb.append(first);
            else sb.append(second);
        }
        
        // 문자열 변환
        String answer = sb.toString();
        
        return answer;
     }
}

// mbti 각 지표별로 둘 중 하나
// n개의 질문, 7개의 선택지 -> 0 ~ 6 (베스트), 3이면 모르겠음
// 질문에 따라 점수 기분이 바뀜 -> 0 (베스트) ~ 6 (워스트)
// 매우 -> 3점, 동의 / 비동의 -> 2점, 약간 -> 1, 모르겠음 -> 점수 x
// 하나의 지표에서 점수가 같으면, 두 사전 순으로 앞인 녀석이 성격유형

// 입력: survey -> 성격 유형 기준 -> 첫번째: 비동의, 두번째: 동의
// choices = 답변: 1 매우 비동의 ~ 7 매우 동의


