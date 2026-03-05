class Solution {
    public int[] solution(long n) {
        
        String StringN = String.valueOf(n);
        char[] charArrN = StringN.toCharArray();
        
        int[] answer = new int[charArrN.length];
        
        for (int i = 0; i < charArrN.length; i++) {
            answer[i] = charArrN[charArrN.length - 1 - i] - '0';
        }
        
        return answer;
    }
}