class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int gcd = gcd(n, m);
        int lcm = lcm(n, m, gcd);
        
        answer[0] = gcd;
        answer[1] = lcm;
        
        return answer;
    }
    
    public int gcd(int n, int m) {
        
        while (n % m != 0) {
            int r = n % m;
            n = m;
            m = r;
        }
        
        return m;
    }
    
    public int lcm(int n, int m, int gcd) {
        return n * m / gcd;
    }
    
}