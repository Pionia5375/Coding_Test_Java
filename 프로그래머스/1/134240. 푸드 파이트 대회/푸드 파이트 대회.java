import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        StringBuilder str = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++)
                str.append(i);
        }
        
        String str1 = str.toString();
        String str2 = str.reverse().toString();
        
        answer = str1 + "0" + str2;
        
        return answer;
    }
}

// 리턴값 = 오름차순 문자열 + 0 + 내림차순 문자열
// 오름차순 문자열은 food 배열을 순회하며 인덱스를 (인덱스번째 요소 / 2) 번 반복하여 추가함.
// 내림차순 문자열은 오름차순 문자열을 거꾸로 정렬함
