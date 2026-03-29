class Solution {
    public String solution(int a, int b) {
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totalDays = 0;
        
        for (int i = 0; i < a - 1; i++) {
            totalDays += daysInMonth[i];
        }
        
        totalDays += (b - 1);

        return week[totalDays % 7];
    }
}

// 기본값을 5로 설정.
// a가 홀수이면, 31일까지
// a가 짝수이면, 2월일 경우 29일까지, 나머지는 30일까지
// for문으로 순회하면서 값을 모두 더하고, 7로 나머지 구한 뒤에 요일과 매핑

// 31 * 6
// 30 * 5
// 29 * 1

// 186 + 150 + 29 = 365

// 1월은 31일까지
// 2월은 29일까지

// 31일인 달과 30일인 달, 29일인 달을 어떻게 나누나..?
// 5월 24일이면, 1월 -> 31일 + 29일 + 31일 + 30일 + 24일 % 7