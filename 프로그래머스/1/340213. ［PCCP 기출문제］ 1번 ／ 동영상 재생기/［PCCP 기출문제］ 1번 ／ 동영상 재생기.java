class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 현재 구간 파악 및 전체 시간을 초단위로 변환
        int posSec = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        int video_lenSec = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        int op_startSec = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int op_endSec = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
        
        // 수정 명령어 수행 전, 최초 시작 위치가 오프닝 구간인지 검사
        if (posSec >= op_startSec && posSec <= op_endSec) {
            posSec = op_endSec;
        }
        
        // 커맨드를 수행하며 시간 변경
        for (int i = 0; i < commands.length; i++) {
            
            // 명령어 먼저 수행
            if (commands[i].equals("prev")) {
                posSec -= 10;
                // 시간 변경 시, 00:00 미만인지 검증
                if (posSec < 0) posSec = 0;
            }
            else { // 혹은 video_len 초과인지 검증 
                posSec += 10;
                if (posSec > video_lenSec) posSec = video_lenSec;
            }
            
            //명령어를 수행한 후 오프닝 구간에 떨어졌는지 확인
            if (posSec >= op_startSec && posSec <= op_endSec) {
                posSec = op_endSec;
            }
        }
        
        // 시간 전체를 정수로 변환하여 계산
        String min = String.valueOf(posSec / 60);
        if (posSec / 60 < 10) min = "0" + String.valueOf(posSec / 60);
        
        String sec = String.valueOf(posSec % 60);
        if (posSec % 60 < 10) sec = "0" + String.valueOf(posSec % 60);
        
        String result = min + ":" + sec;
        return result;
    }
}

// prev = 10초 전 이동, 현재 위치 < 10초이면, 0분 0초
// next = 10초 후 이동, 남은 시간 < 10초이면, 영상 길이
// op_start <= 현재 재생 위치 <= op_end이면, op_end
// 동영상의 길이를 나타내는 문자열 video_len
// 기능이 수행되기 직전의 재생위치를 나타내는 문자열 pos
// 오프닝 시작 시각을 나타내는 문자열 op_start
// 오프닝이 끝나는 시각을 나타내는 문자열 op_end
// 사용자의 입력을 나타내는 1차원 문자열 배열 commands
// 동영상 위치를 "mm:ss"로 반환, 한자리면 앞에 0

// 커맨드 입력 도중 op 구간이 되면, op_end로 이동


// 현재 구간 파악
// 매 변경 전에는 오프닝 구간 안에 있는지 확인
// 오프닝 구간 안에 있다면 op_end로 현재 시간 설정
// 커맨드를 수행하며 시간 변경
// 시간 변경 시, 00:00 미만인지 검증
// 00:00 미만이라면, 00:00으로 설정
// 혹은 video_len 초과인지 검증 
// video_len 초과라면, video_len으로 설정

// 시간 전체를 정수로 변환하여 계산