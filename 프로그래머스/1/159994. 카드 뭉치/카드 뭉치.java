class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0, idx2 = 0;
        
       for (int i = 0; i < goal.length; i++) {
            if (idx1 < cards1.length && cards1[idx1].equals(goal[i])) {
                idx1++;
            } 
            else if (idx2 < cards2.length && cards2[idx2].equals(goal[i])) {
                idx2++;
            } 
            else {
                return "No";
            }
        }
        
        return "Yes";
    }
}


// goal에 있는 문자열들을 순회
// goal의 인덱스마다, 해당 인덱스 요소가 card1과, card2의 현재 인덱스에 있는지 확인.
// 있다면 해당 배열의 인덱스와 goal의 인덱스 + 1, 없다면 "No" 반환
//