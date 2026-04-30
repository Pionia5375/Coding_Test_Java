class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        // 스케쥴의 각 요소에 10분을 더함
        for (int i = 0; i < schedules.length; i++) {
            int hour = schedules[i] / 100;
            int min = schedules[i] % 100 + 10;
            
            if (min >= 60) {
                min %= 60;
                hour = hour % 24 + 1;
            }
            
            schedules[i] = hour * 100 + min;
        }
        
        // 선물을 받을 직원 수
        int count = 0;
        
        // 타임로그 배열을 순회
        for (int i = 0; i < timelogs.length; i++) {
            int day = startday;
            for (int j = 0; j < timelogs[i].length; j++) {
                
                // 시작 요일은 1 ~ 7이고, 요소 한 검사할 때마단 + 1 % 8, 0이면 + 1
                if (day % 8 == 0) day = 1;
                else day %= 8;
                
                // 요일이 6 혹은 7이면 상관 x continue.
                if (day == 6 || day == 7) {
                    if (j == 6) count++; // 모든 요일 검사 종료 시 카운트 ++
                    else {
                        day++;
                        continue;
                    };
                } else if (schedules[i] < timelogs[i][j]) { // 그 외 요일인데, 타임로그의 정수가 스케쥴보다 크면 해당 루프 break
                    break;
                } else if (j == 6) {
                    count++;
                } else {
                    day++;
                    continue;
                }
            }
        }
        
        return count;
    }
}

