class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        answer[0] = -1;
        
        for (int i = 1; i < s.length(); i++) {
            int diff = -1;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == s.charAt(i)) diff = i - j;
            }
            answer[i] = diff;
        }
        
        return answer;
    }
}