import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        // 공격 종료 시점, 시전시간, 초당 회복량, 추가 회복량, 카운트, 현재체력 정의
        int end = 0;
        int duration = bandage[0];
        int healPerSec = bandage[1];
        int extraHeal = bandage[2];
        int count = 0;
        int currentHealth = health;
        
        // 공격 타이밍 해시맵 작성, 공격 종료 시점 저장
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < attacks.length; i++) {
            map.put(attacks[i][0], attacks[i][1]);
            if (attacks[i][0] > end) end = attacks[i][0];
        }
        
        // 전체 공격이 끝날 때까지 반복
        for (int i = 1; i < end + 1; i++) {
            // 공격이 들어오면 카운트 x, 카운트 초기화
            int damage = map.getOrDefault(i, 0);
                
            if (damage != 0) {
                // 만약 데미지를 입어 체력이 0 이하가 되면 -1 반환
                if (currentHealth - damage <= 0) {
                    return -1;
                }
                
                // 현재 체력 -= 데미지
                currentHealth -= damage;
                count = 0;
                
            } else { // 공격이 안들어오면 카운트 시작
                count++;
                
                // 현재 체력 < 최대체력이면 매 카운트마다 초당 회복, 
                if (currentHealth < health) {
                    int heal = healPerSec;
                    
                    // 시전시간 = 카운트이면, 카운트 초기화, 현재체력 += 추가 체력 + 초당 회복
                    if (count == duration) {
                        heal += extraHeal;
                        count = 0;
                    }
                    
                    // 이 때 회복 후 현재 체력 < 최대체력, 최대체력까지 채움   
                    if (currentHealth + heal > health) {
                        currentHealth = health;
                    } else {
                        currentHealth += heal;
                    }
                }
            }
        }
        return currentHealth;
    }
}

// 붕대감기: 시전시간, 초당 회복, 종료 시 추가 체력
// 총 체력
// 공격 2차원 배열: 공격 타이밍, 데미지
