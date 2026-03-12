class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int num = left; num <= right; num++) {
            int limit = (int) Math.sqrt(num);
            int count = 0;
            for (int i = 1; i < limit + 1; i++) {
                if (num % i == 0) {
                    int partner = num / i;
                    if (partner == i)
                        count += 1;
                    else
                        count += 2;
                }
            }
            if (count % 2 == 0)
                answer += num;
            else
                answer -= num;
        }
        
        return answer;
    }
}