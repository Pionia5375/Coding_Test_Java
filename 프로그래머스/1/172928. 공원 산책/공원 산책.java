class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        // 로봇 개의 인덱스 초기화
        int sX = 0;
        int sY = 0;
        
        // 공원 배열을 받아서, S의 인덱스를 구함
        for (int y = 0; y < park.length; y++) {
            for (int x = 0; x < park[y].length(); x++) {
                if (park[y].charAt(x) == 'S') {
                    sX = x;
                    sY = y;
                }
            }
        }
        
        // 루트 배열을 받아서 공백을 기준으로 분리한 뒤, 방향과 이동 칸 수를 구함
        for (int i = 0; i < routes.length; i++) {
            String direction = routes[i].split(" ")[0];
            int move = Integer.parseInt(routes[i].split(" ")[1]);
            
            // 북 / 서로 이동시 인덱스 반대
            if (direction.equals("N") || direction.equals("W")) {
                move *= -1;
            }
            
            // 루트 배열을 순회하면서, 다음 조건을 확인
            // 해당 방향으로 이동시 범위를 벗어나는지 확인
            // 임시 인덱스를 S의 값으로 부여한 뒤, 하나씩 더해가며 해당 칸에 X가 있는지 확인
            if (direction.equals("N") || direction.equals("S")) {
                if (sY + move >= park.length || sY + move < 0) continue;
                else {
                    int tmpY = sY; // 임시 인덱스 부여
                    while (tmpY != sY + move) { // 이동한 인덱스까지 하나씩 늘리거나 줄여가며,
                        if (direction.equals("N")) tmpY -= 1;
                        else tmpY += 1;
                        
                        if (park[tmpY].charAt(sX) == 'X') break; // 해당 경로에 X가 존재하면 루프 끊기
                    }
                    if (park[tmpY].charAt(sX) == 'X') continue; // 해당 경로에 X가 존재하면 다음 명령
                    else sY = tmpY; // 루프 정상 종료 시 y 인덱스 변경
                }
            }
            else {
                if (sX + move >= park[0].length() || sX + move < 0) continue;
                else {
                    int tmpX = sX;
                    while (tmpX != sX + move) {
                        if (direction.equals("W")) tmpX -= 1;
                        else tmpX += 1;
                        
                        if (park[sY].charAt(tmpX) == 'X') break;
                    }
                    if (park[sY].charAt(tmpX) == 'X') continue;
                    else sX = tmpX;
                }
            }
        }
        int[] result = {sY, sX};
        return result;
    }
}

// 로봇의 초기 인덱스는 랜덤으로 부여되고, 공원 배열은 가로줄 스트링의 요소로 구성됨 -> 정수형인덱스, charAt 활용
// 루트 배열은 공백을 기준으로 나뉘는 문자열로 제공됨 -> 스플릿으로 나눠서 각각 방향, 이동 거리로 저장
// 결과 배열은 정수형 인덱스 배열이어야 함 -> 최종 인덱스를 배열로 저장

// 문제의 핵심은 전체 루트 배열을 순회한 뒤, 로봇의 마지막 위치에 대한 인덱스를 반환하는 것.

// 명령 유효성 검증
// 명령을 무시하는 경우 1: 공원을 벗어나는 경우 -> 로봇의 현재 인덱스 + 이동 시 배열의 범위를 초과하는가?
// 명령을 무시하는 경우 2: 장애물을 만나는 경우 -> 로봇의 현재 인덱스로부터 해당 방향으로 인덱스를 순회하고 장애물을 발견할 경우

// 명령 실행 시: 로봇의 현재 위치는 해당 인덱스만큼 이동


