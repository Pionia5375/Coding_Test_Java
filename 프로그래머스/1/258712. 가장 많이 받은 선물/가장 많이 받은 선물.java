import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        HashMap<String, Integer> friendIdx = new HashMap<>();
        
        // 이름-인덱스 매핑
        for (int i = 0; i < n; i++) {
            friendIdx.put(friends[i], i);
        }
        
        int[][] giftGraph = new int[n][n];
        int[] giftIndex = new int[n];
        
        // 선물 기록 처리
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int u = friendIdx.get(parts[0]);
            int v = friendIdx.get(parts[1]);
            
            giftGraph[u][v]++;
            giftIndex[u]++;
            giftIndex[v]--;
        }
        
        int[] nextMonthGifts = new int[n];
        int maxGifts = 0;
        
        // 다음 달 선물 계산
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int gaveToJ = giftGraph[i][j];
                int gaveToI = giftGraph[j][i];
                
                if (gaveToJ > gaveToI) {
                    nextMonthGifts[i]++;
                } else if (gaveToI > gaveToJ) {
                    nextMonthGifts[j]++;
                } else {
                    if (giftIndex[i] > giftIndex[j]) {
                        nextMonthGifts[i]++;
                    } else if (giftIndex[j] > giftIndex[i]) {
                        nextMonthGifts[j]++;
                    }
                }
            }
        }
        
        // 최댓값 찾기
        for (int count : nextMonthGifts) {
            if (count > maxGifts) {
                maxGifts = count;
            }
        }
        
        return maxGifts;
    }
}

// 선물을 가장 많이 받은 사람의 받은 선물 개수 구하기

// 본인 - 본인을 제외한 전체 멤버에게 준 선물의 개수를 담을 자료구조 필요
// 본인이 총 준 선물, 받은 선물, 선물지수를 보관
// 정답 배열을 참가자 수의 크기로 초기화
// 본인 - 상대, 상대 - 본인의 준 선물의 수를 비교 -> 더 큰쪽 + 1
// 선물의 수가 같다면, 선물 지수를 비교 -> 더 큰쪽 + 1

// 선물을 준 사람을 행으로 하고, 준 선물, 받은 선물, 선물 지수를 열로 하는 2차원 배열 생성
// friend 배열을 순회하며 본인 - 전체 멤버에게 준 선물 개수 해시맵 생성
// gift 배열을 순회하며, 선물을 준 사람의, 전체 멤버에게 준 선물 개수 조정

// 매 조정 시마다, 선물 준 사람의 준 선물 카운트 증가, 받은 사람의 받은 선물 카운트 증가
// 조정 종료시, 2차원 배열의 선물 지수 갱신
// 