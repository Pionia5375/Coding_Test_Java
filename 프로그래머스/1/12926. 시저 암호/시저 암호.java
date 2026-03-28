class Solution {
    public String solution(String s, int n) {
        
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer.append(' ');
                continue;
            }
            if (Character.isUpperCase(s.charAt(i))) {
                int index = upperAlphabet.indexOf(s.charAt(i));
                answer.append(upperAlphabet.charAt((index + n) % 26));
            } else if (Character.isLowerCase(s.charAt(i))){
                int index = lowerAlphabet.indexOf(s.charAt(i));
                answer.append(lowerAlphabet.charAt((index + n) % 26));
            }
        }
        
        return answer.toString();
    }
}