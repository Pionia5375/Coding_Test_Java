class Solution {
    
    public int maxCount = 0;
    public boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
        
        return maxCount;
    }
    
    public void dfs(int count, int currentFatigue, int[][] dungeons) {
        maxCount = Math.max(maxCount, count);
        
        for (int i = 0 ; i < dungeons.length; i++) {
            if (!visited[i] && currentFatigue >= dungeons[i][0]) {
                visited[i] = true;
                
                dfs(count + 1, currentFatigue - dungeons[i][1], dungeons);
                
                visited[i] = false;
            }
        }
    }
    
}

// 최소 필요 피로도, 소모 필요도
// 던전은 하루 한 번씩
// 최대한 많이 탐험하는 방법
// 필요 피로도는 항상 소모 피로도보다 높음

// 던전 전체 길이는 8이하. -> 순열로 모든 경우의 수를 구하고 맥스값 도출?
// 어떻게 매번 순서를 바꿔갈 것인가?
// 중단 조건은 무엇인가?
// 매 경우의 수에서, 중간에 내 피로도 보다 소모 피로도가 높을 경우, 다음 루프로 넘어감
// 루프마다 카운트 변수를 선언해서, 매 던전 클리어시 + 1
// 루프가 끝날 때 max와 비교, 더 높으면 갱신