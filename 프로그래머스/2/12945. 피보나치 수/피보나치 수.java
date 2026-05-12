class Solution {
    public int solution(int n) {
        int a = 0;
        int b = 1;
        
        int answer = fib(a, b, n - 2);
        
        return answer;
    }
    
    public int fib(int a, int b, int n) {
        
        int sum = (a + b) % 1234567;
        if (n > 0) return fib(b, sum, n - 1);
        else return sum;
    }
}



// n 번 반복
// 리턴 b + fib(b, a + b)