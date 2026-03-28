class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] charArr = s.toCharArray();
        int index = 0;
        
        for(int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ') {
                index = 0;
                continue;
            }
            if (index % 2 == 0) charArr[i] = Character.toUpperCase(charArr[i]);
            else charArr[i] = Character.toLowerCase(charArr[i]);
            index++;
        }
        
        answer = String.valueOf(charArr);
        
        return answer;
    }
}