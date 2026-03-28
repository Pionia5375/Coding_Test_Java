class Solution {
    public int solution(int a, int b, int n) {
        int answer = getColaCount(a, b, n);
        
        return answer;
    }
    
    public int getColaCount(int a, int b, int n) {
        int sum = 0;
        
        if (n / a * b == 0) return 0;
        
        int count = n / a * b;
        int remained = n % a;
        
        sum += count + getColaCount(a, b, count + remained);
        
        return sum;
    }
}

// 받을 수 있는 콜라의 수: n / a * b
// 한 번 가면 남는 콜라의 수: n % a
// 매번 받은 콜라의 수 + 남은 콜라의 수를 더해서 재귀 호출