class Solution {
    public int solution(String s) {
        
        // 문자열을 첫 글자를 a로 설정.
        int firstLetter = s.charAt(0);
        
        // x = 1로 초기화, 다른 문자 = 0으로 초기화, count = 1으로 초기화
        int firstCount = 1;
        int othersCount = 0;
        int splitCount = 0;
        
        if (s.length() == 1) return 1;
        
        // 문자열의 두번째 인덱스부터 문자를 하나씩 순회
        for (int i = 1; i < s.length(); i++) {
            
            if (firstCount == 0) firstLetter = s.charAt(i);
            
            // 문자가 x이면 x++, 문자가 x가 아니면 다른문자++
            if (s.charAt(i) == firstLetter) firstCount++;
            else othersCount++;
            
            // x == 다른문자이면, count++, x = 0, 다른 문자 0으로 초기화
            if (firstCount == othersCount) {
                splitCount++;
                firstCount = 0;
                othersCount = 0;
            }
            
            // 마지막 인덱스에서, x != 다른문자 면, count++
            if (i == s.length() - 1 && firstCount != othersCount) splitCount++;
        }
        
        return splitCount;
    }
}






