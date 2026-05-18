import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            
            // i != 0 일 때 문자열 회전
            if (i != 0) {
                // 첫 번째 문자를 추출하고, 나머지 문자열 뒤에 붙임
                s = s.substring(1) + s.charAt(0);
            }
            
            // 스택 검증 로직
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                
                // 스택이 비어 있을 경우 push 
                if (stack.isEmpty()) {
                    stack.push(c);
                } else { // 본인 짝일 경우 pop
                    if (stack.peek() == '[' && c == ']') stack.pop();
                    else if (stack.peek() == '{' && c == '}') stack.pop();
                    else if (stack.peek() == '(' && c == ')') stack.pop();
                    // 본인 짝이 아닐 경우 push
                    else stack.push(c);
                }
            }
            
            // 다 돌았을 때 비어있으면 count++
            if (stack.isEmpty()) {
                count++;
            }
        }
        
        return count;
    }
}

// 그냥 스택 문자열 검증 문제에 회전 로직 추가한 문제.
// 길이가 1이상 1000 이하이므로, 시간 복잡도 구애 x