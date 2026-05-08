class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isFirst = true; // 현재 문자가 단어의 첫 글자인지 판별하는 플래그
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                isFirst = true; // 공백이 등장하면 다음 글자는 무조건 첫 글자
                answer.append(c);
            } else {
                if (isFirst) {
                    // 첫 글자면 대문자로 변환
                    answer.append(Character.toUpperCase(c));
                    isFirst = false; // 다음 글자부터는 첫 글자가 아님
                } else {
                    // 첫 글자가 아니면 소문자로 변환
                    answer.append(Character.toLowerCase(c));
                }
            }
        }
        
        return answer.toString();
    }
}