import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        
        // 카운트 변수 선언
        int count = 0;
        
        // 스택 선언
        Stack<Integer> stack = new Stack<>();
        
        // 재료 배열을 순회
        for (int i = 0; i < ingredient.length; i++) {
            // 나온 재료가 빵이 아니면 그냥 푸시
            if (ingredient[i] != 1) stack.push(ingredient[i]);
            else { // 빵이면 다음을 확인
                // 스택이 비어있거나, 스택 포인터 값이 고기가 아니면 빵 삽입
                if (stack.isEmpty() || stack.peek() != 3) stack.push(ingredient[i]);
                else {
                    // 고기라면 고기를 팝하고 스택의 다음 요소를 확인
                    int meat = stack.pop();
                    // 다음 요소가 비어있거나, 야채가 아니라면 고기를 다시 푸시하고 빵을 삽입
                    if (stack.isEmpty() || stack.peek() != 2) {
                        stack.push(meat);
                        stack.push(ingredient[i]);
                    }
                    else {
                        // 야채라면 야채를 팝하고 스택의 다음 요소를 확인
                        int vegitable = stack.pop();
                        // 다음 요소가 비어있거나, 빵이 아니라면 야채를 다시 푸시하고 고기를 푸시하고 빵을 푸시
                        if (stack.isEmpty() || stack.peek() != 1) {
                            stack.push(vegitable);
                            stack.push(meat);
                            stack.push(ingredient[i]);
                        }
                        else {
                            // 빵이라면 빵까지 팝한 뒤 카운트 증가
                            stack.pop();
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}

