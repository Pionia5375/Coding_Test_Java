class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int big = (a > b) ? a : b;
        int small = (b > a) ? a : b;
        int len = big - small;
        
        for (int i = 0; i < len + 1; i++) {
            answer += small;
            small++;
        }
        
        return answer;
    }
}