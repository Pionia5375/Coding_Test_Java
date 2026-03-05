class Solution {
    public long solution(long n) {
        long answer = 0;
        
        long sqrt = (long) Math.sqrt(n); // Math.sqrt() 는 doubl을 반환
        
        if (sqrt * sqrt == n)
            answer = (sqrt + 1) * (sqrt + 1);
        else
            answer = -1;
            
        
        return answer;
    }
}