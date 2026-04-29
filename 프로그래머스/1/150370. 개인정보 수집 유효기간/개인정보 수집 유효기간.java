import java.util.*;

// 보관기간 지난 개인정보들만 인덱스를 뽑아서, 오름차순으로 정렬하는 문제
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        // 해시맵 생성
        HashMap<String, Integer> map = new HashMap<>();
        
        // 오늘 연도, 달, 일 저장
        String[] todayArr = today.split("\\.");
        int dueYear = Integer.parseInt(todayArr[0]);
        int dueMonth = Integer.parseInt(todayArr[1]);
        int dueDay = Integer.parseInt(todayArr[2]);
        
        // 정답 배열 생성
        List<Integer> list = new ArrayList<>();
        
        // 약관의 종류를 파악 -> 기간과 개인정보 문자열을 " "을 기준으로 스플릿
        for (int i = 0; i < terms.length; i++) {
            String[] tmp = terms[i].split(" ");
            // 기간들을 각각 해시맵에 저장
            String type = tmp[0];
            int term = Integer.parseInt(tmp[1]);
            
            map.put(type, term);
        }
        
        // 문자열 배열을 순회
        for (int i = 0; i < privacies.length; i++) {
            
            // 유형과 수집일을 분리
            String[] tmp = privacies[i].split(" ");
            String date = tmp[0];
            
            // .을 기준으로 연도, 달, 일자를 분리하고 각각 저장
            String[] yearMonthDate = date.split("\\.");
            int year = Integer.parseInt(yearMonthDate[0]);
            int month = Integer.parseInt(yearMonthDate[1]);
            int day = Integer.parseInt(yearMonthDate[2]);
            
            // 유형과 해시맵을 대조하여, 기간을 저장
            int term = map.get(tmp[1]);
            
            // 연도, 달 구하기
            int totalMonth = month + term;

            year += totalMonth / 12; // 몫만큼 연도 증가
            month = totalMonth % 12; // 12로 나눈 나머지가 새로운 달
            
            // 예외 처리
            if (month == 0) {
                year -= 1;
                month = 12;
            }
            
            // 일수에 -1 하기 -> 만약 1이었다면 28로 만들고, 달 -1하기
            if (day - 1 == 0) {
                day = 28;
                month -= 1;
                if (month == 0) {
                    year -= 1;
                    month = 12;
                }
            }
            else day -= 1;
            
            // 오늘 연도, 달, 일과 비교
            if (dueYear > year) list.add(i + 1);
            else if (dueYear == year){
                if (dueMonth > month) list.add(i + 1);
                else if (dueMonth == month){
                    if (dueDay > day) list.add(i + 1);
                }
            }
        }
        
        // 배열 전환
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}



