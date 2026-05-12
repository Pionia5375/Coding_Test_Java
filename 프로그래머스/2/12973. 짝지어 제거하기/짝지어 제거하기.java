import java.util.*;

class Solution
{
    public int solution(String s)
    {
        // 스택 선언
        Stack<Character> stack = new Stack<>();
        
        // 결과 반환
        for (int i = 0; i < s.length(); i++) {
            
            char current = s.charAt(i);
            
            // 안에 아무것도 없거나, top의 문자가 들어가는 문자랑 다를 경우 push        
            if (stack.isEmpty() || stack.peek() != current) stack.push(current);
            else stack.pop();
        }
        
        if (stack.isEmpty()) return 1;
        else return 0;
    }
}

// 전부 제거할 수 있는지 물어보는 문제
// 같은 문자 2개가 연속해서 등장하면 지우기

