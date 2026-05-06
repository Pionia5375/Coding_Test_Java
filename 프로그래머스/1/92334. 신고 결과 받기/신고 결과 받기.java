import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        
        // 중복 신고 제거를 위해 배열을 HashSet으로 변환
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        HashMap<String, List<String>> userAndReport = new HashMap<>();
        HashMap<String, Integer> reportAndCount = new HashMap<>();
        
        // id_list 순회, 리스트 초기화
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            List<String> reports = new ArrayList<>();
            userAndReport.put(user, reports);
        }
        
        // 중복이 제거된 reportSet을 순회
        for (String r : reportSet) {
            String user = r.split(" ")[0];
            String reportedUser = r.split(" ")[1];
            
            // 유저 - 신고자 리스트에 추가
            userAndReport.get(user).add(reportedUser);
            
            // 신고자 - 카운트 해시맵 업데이트 (오타 수정)
            reportAndCount.put(reportedUser, reportAndCount.getOrDefault(reportedUser, 0) + 1);
        }
        
        List<String> stoppedUsers = new ArrayList<>();
        
        // 향상된 for문으로 순회하면서 신고 횟수를 k와 비교
        for (String key : reportAndCount.keySet()) {
            if (reportAndCount.get(key) >= k) {
                stoppedUsers.add(key);
            }
        }
        
        // 유저 - 신고자 리스트 순회
        for (int i = 0; i < id_list.length; i++) {
            List<String> resultList = userAndReport.get(id_list[i]);
            
            for (int j = 0; j < resultList.size(); j++) {
                for (int p = 0; p < stoppedUsers.size(); p++) {
                    if (resultList.get(j).equals(stoppedUsers.get(p))) {
                        result[i]++;
                    }
                }
            }
        }
        return result;
    }
}

// 신고는 한 번에 한 명, 횟수 제한은 없음
// 중복 신청 가능, 단 1회만 유효 처리
// k번 이상 신고되면 정지, 신고한 유저들에게 정지 메일 발송
// 마지막에 한꺼번에 정지 및 메일 발송
// 각 유저별로 처리 결과를 받은 횟수를 배열로 리턴

// 리포트는 이용자, 신고자 이름으로 구성됨
// 신고자가 몇 번 신고됐는지 파악 필요
// 그게 k번 이상인지 비교해야됨
// 신고자를 신고한 유저 파악 필요.
// 신고자 - 유저 정보를 저장해둘 필요가 있음

// 유저 - 신고자 목록 매핑 -> 해시맵? (유저 - 신고자 리스트)
// 신고자 카운트 -> 배열 / 해시맵? (신고자 - 카운트)
// 신고자 카운트 키값들을 가지고 옴 -> 배열로 순회 -> 하나하나 k와 대조 -> 카운트가 k 이상인 신고자 목록을 추림
// 아이디 리스트 각각의 해시 맵 리스트 순회, 신고자 목록 있을 때마다 결과 요소 + 1;

// 결과 배열 초기화
// 유저 - 신고자 리스트 해시맵 초기회
// 신고자 - 카운트 해시맵 초기화
// id_list를 순회, id별 리스트 초기화
// 리포트를 순회
// 유저 - 신고자 리스트에 추가
// 신고자 - 카운트 해시맵 업데이트
// 리스트 다 돌면, 해시맵 키 값 리스트 받아오기
// 각 요소별로 해시맵 조회, 밸류값 > k 면 배열에 추가
// 유저 - 신고자 리스트 순회
// 신고자 리스트에 신고자 존재시, 정답 배열 + 1

