class Solution {
    public int[] solution(String[] wallpaper) {
        
        // x_min, x_max, y_min, y_max를 설정
        int x_min = 50;
        int x_max = 0;
        int y_min = 50;
        int y_max = 0;
        
        // 이차원 배열을 순회하면서, 각 값을 갱신
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                char index = wallpaper[i].charAt(j);
                if (index == '#') {
                    if (i < x_min) x_min = i;
                    if (i > x_max) x_max = i;
                    if (j < y_min) y_min = j;
                    if (j > y_max) y_max = j;
                }
            }
        }
        
        // x_min, y_min을 왼쪽 위 커서, x_max, y_max를 오른쪽 아래 커서로 하고 거리 구하고 리턴
        int[] result = {x_min, y_min, x_max + 1, y_max + 1};
        
        return result;
    }
}

// 파일의 위치는 이차원 배열에서 .과 #로 표현됨
// lux, luy가 처음 커서 위치, rdx, rdy가 드래그 후 커서 위치
// 드래그한 거리 -> |rdx - lux| + |rdy - luy|
// 왼쪽 위 커서 = 모든 파일의 위치에서의 x 최소값과, y 최소값
// 오른쪽 아래 커서 = 모든 파일 위치에서의 x 최대값과, y 최대값

// 모든 파일들로부터 x,y각각의 최소값과 최대값을 어떻게 구할 것인가?
// 배열을 순회하면서,
// 파일이 등장했을 때의 i, j값을 각각 x, y라고 하고, 각각을 최대, 최소와 비교하고, 업데이트
// x_min, x_max, y_min, y_max를 설정하고, 각각 비교해서 구하기. 

