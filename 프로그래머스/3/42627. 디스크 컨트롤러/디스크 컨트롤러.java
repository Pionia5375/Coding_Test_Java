import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        PriorityQueue<Job> diskController = new PriorityQueue<>((job1, job2) -> job1.requestTime - job2.requestTime);
        
        // Job 객체를 요소로 하는 대기 큐 정의
        PriorityQueue<Job> waitingQueue = new PriorityQueue<>((job1, job2) -> {
            if (job1.requiredTime == job2.requiredTime) {
                if (job1.requestTime == job2.requestTime) {
                    return job1.jobNumber - job2.jobNumber;
                } return job1.requestTime - job2.requestTime;
            } return job1.requiredTime - job2.requiredTime;
        });
        
        // 우선순위 큐에 jobs의 모든 요소 삽입
        for (int i = 0; i < jobs.length; i++) {
            Job waitingJob = new Job(i, jobs[i][0], jobs[i][1]);
            diskController.add(waitingJob);
        }
        
        // 현재시간, 진입시간, 총 작업 개수, 총 소요시간 0으로 초기화
        int currentTime = 0;
        int enteredTime = 0;
        int totalJobCount = 0;
        int totalConsumedTime = 0;
        
        // Job 객체 하드디스크 null로 초기화
        Job harddisk = null;
        
        // 하드디스크와, 대기 큐와, 디스크 컨트롤러 큐에 아무것도 없게 될 때까지        
        while (harddisk != null || !waitingQueue.isEmpty() || !diskController.isEmpty()) {
            // 하드디스크에 작업 있고(null이 아니고), 소요시간 <= 현재시간 - 진입시간 이면,
            if (harddisk != null && harddisk.requiredTime <= currentTime - enteredTime) {
                // 총 소요시간 += 소요시간, 소요시간과 진입시간 0으로 초기화 하드디스크에서 작업 삭제(null로 설정) 
                totalConsumedTime += currentTime - harddisk.requestTime;
                enteredTime = 0;
                harddisk = null;
                
                // 총 작업 개수++
                totalJobCount++;
            }
            
            // 우선순위 큐 맨 앞의 요청시각 확인, 요청 시간 <= 현재시간이면 대기 큐에 add
            while (!diskController.isEmpty() && diskController.peek().requestTime <= currentTime) {
                waitingQueue.add(diskController.poll());
            }
            
            // 하드디스크에 작업이 없으면(null 이면) 큐에서 poll, 하드디스크에 삽입, 진입시간 기록
            if (harddisk == null && !waitingQueue.isEmpty()) {
                harddisk = waitingQueue.poll();
                enteredTime = currentTime;
            }
            // 시간++
            currentTime++;
        } 
        // 루프가 끝나면, 총 소요시간 / 작업개수 리턴
        return totalConsumedTime / totalJobCount;
    }
}

// Job 객체 정의: 멤버변수: 작업 번호, 요청 시각, 소요 시간 
class Job {
    int jobNumber;
    int requestTime;
    int requiredTime;
    
    public Job(int jobNumber, int requestTime, int requiredTime) {
        this.jobNumber = jobNumber;
        this.requestTime = requestTime;
        this.requiredTime = requiredTime;
    }
}


