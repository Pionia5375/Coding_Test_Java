import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }
        
        
        List<Integer> result = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int count = 1;
            int deployDay = queue.poll();
            
            while (!queue.isEmpty() && queue.peek() <= deployDay) {
                queue.poll();
                count++;
            }
            result.add(count);
        }
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}