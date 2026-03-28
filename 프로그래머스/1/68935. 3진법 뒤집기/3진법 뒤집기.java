import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        
        while (n > 0) {
            int r = n % 3;
            n /= 3;
            list.add(r);
        }
        
        for (int i = 0; i < list.size(); i++) {
            int power = list.size() - 1 - i;
            answer += list.get(i) * (int) Math.pow(3, power);
        }

        return answer;
    }
}

// n < 3일 때까지 나누어서, 몫과 나머지를 구하기를 반복.