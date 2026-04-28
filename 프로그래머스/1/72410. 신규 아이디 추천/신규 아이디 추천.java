import java.util.*;

class Solution {
    public String solution(String new_id) {
    
        // 1. 소문자 치환
        String phase1 = new_id.toLowerCase();
        
        // 2. 특수문자 제거
        String phase2 = phase1.replaceAll("[^a-z0-9\\-_.]", "");
        
        // 3. .. 연속 확인 -> .하나로 만들기
        String phase3 = phase2.replaceAll("\\.{2,}", ".");
        
        // 4. . 처음이나 끝이면 제거
        if (phase3.startsWith("."))
            phase3 = phase3.substring(1);
        if (phase3.endsWith("."))
            phase3 = phase3.substring(0, phase3.length() - 1);
        
        // 5. 빈 문자열이면, a 대입
        if (phase3.equals(""))
            phase3 = phase3 + "a";
        
        // 6. 15자 이상이면, 나머지 문자 모두 제거. 제거 후 마지막 .이면 제거
        if (phase3.length() > 15) 
            phase3 = phase3.substring(0, 15);
        if (phase3.endsWith("."))
            phase3 = phase3.substring(0, phase3.length() - 1);
        
        // 7. 2자 이하라면, 길이가 3이 될때까지 마지막 문자를 더함
        while (phase3.length() < 3) {
            phase3 = phase3 + phase3.charAt(phase3.length() - 1);
        }
        
        return phase3;
    }
}


