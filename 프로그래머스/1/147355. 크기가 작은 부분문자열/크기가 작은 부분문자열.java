class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String sub = t.substring(i, i + p.length());
            long num1 = Long.parseLong(sub);
            long num2 = Long.parseLong(p);
            if (num2 >= num1) answer++;
        }
        
        return answer;
    }
}