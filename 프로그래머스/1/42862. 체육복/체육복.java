class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int count = 0;
        
        // 처음에 다 가져왔다고 가정: 1로 초기화
        int[] students = new int[n];
        for (int i = 0; i < n; i++) students[i] = 1;
        
        // reserve 배열의 학생들에게 1 추가
        for (int i = 0; i < reserve.length; i++) students[reserve[i] - 1]++;
        
        // lost 배열의 학생들에게 1 감소
        for (int i = 0; i < lost.length; i++) students[lost[i] - 1]--;
        
        // 배열을 순회하며, 자신의 인덱스 +- 1의 학생이 2일 경우, 자신에 1 할당, 빌려준 학생은 1 감소.
        for (int i = 0; i < n; i++) {
            if (students[i] > 0) continue;
            else {
                if (i > 0 && students[i - 1] == 2) {
                    students[i] = 1;
                    students[i - 1]--;
                }
                else if (i < n - 1 && students[i + 1] == 2) {
                    students[i] = 1;
                    students[i + 1]--;
                }
                else continue;
            }
        }
        
        // 배열을 다시 순회하며, 0이 아닌 요소의 개수를 세고, 리턴
        for (int i = 0; i < n; i++) {
            if (students[i] > 0) count++;
        }

        return count;

    }
}

// 앞 / 뒷번호 학생에게만 빌려줄 수 있음
// 체육복이 없음녀 수업을 들을 수 없음.
// 여벌의 체육복을 가져온 학생이 체육복을 도난당했을 경우가 있음. -> 다른 학생에게 빌려줄 수 없음. 
// 

// n: 전체 학생 수, lost: 도난당한 학생 배열, reserve: 여벌이 있는 학생 배열

