import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int pastIndex = stack.pop();
                answer[pastIndex] = i - pastIndex; 
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int pastIndex = stack.pop();
            answer[pastIndex] = (prices.length - 1) - pastIndex;
        }
        
        return answer;
    }
}