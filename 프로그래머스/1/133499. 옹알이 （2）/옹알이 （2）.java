class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        
        for (String babble : babbling) {
            if (babble.contains("ayaaya") || babble.contains("yeye") || 
                babble.contains("woowoo") || babble.contains("mama")) {
                continue;
            }
            
            babble = babble.replace("aya", " ");
            babble = babble.replace("ye", " ");
            babble = babble.replace("woo", " ");
            babble = babble.replace("ma", " ");
            
            babble = babble.replace(" ", "");
            
            if (babble.isEmpty()) {
                count++;
            }
        }
        
        return count;
    }
}

// aya, ye, woo, ma + 조합, 연속은 못함. 발음할 수 있는 단어의 수.
// 다른 발음이 포함되어있거나, 같은 발음이 반복된다면 실패

// 어떻게 하나의 문자열 안에 조건의 발음이 있는지를 확인할 것인가?
// -> contains? -> 1차 필터링
// -> 첫번째로 나온 해당 문자열을 삭제했을 때, 아무것도 남지 않거나, 제시된 다른 발음 중 다른 하나가 남은 경우? -> 발음 가능
// -> 반대로, 첫번째로 나온 해당 문자열을 삭제했을 때, 같은 문자열이 나오거나, 제시된 발음 중에 없다면, -> 발음 불가능

// aya, ye, woo, ma 배열 만들기
// 향상된 포문 사용
// 주어진 발음을 순회하고, 첫번째 같은 문자열을 삭제

// 결과 배열을 순회
// 아무것도 남지 않았다면 카운트 + 1, 
// 카운트 반환
