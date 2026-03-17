import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르 랭킹 집계용 해시맵
        HashMap<String, Integer> ranking = new HashMap<>();
        
        // 각 장르별 수록곡 리스트 정리용 해시맵
        HashMap<String, List<Song>> lists = new HashMap<>();
        
        // ranking 해시맵에 총 재생횟수 집계
        // lists 해시맵에 장르 ArrayList 생성 및 각 song 객체 삽입
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            ranking.put(genre, ranking.getOrDefault(genre, 0) + play);
            
            if (!lists.containsKey(genre))
                lists.put(genre, new ArrayList<>());
            
            lists.get(genre).add(new Song(i, play));
        }
        
        // ranking 키 목록을 기반으로 ArrayList 생성
        List<String> genreList = new ArrayList<>(ranking.keySet());
        
        // genreList key들의 재생횟수를 기준으로 정렬
        genreList.sort((a, b) -> ranking.get(b) - ranking.get(a)); // (a, b) -> 람다식: 결과 양수이면 b가 앞으로 옴. (내림차순)
        
        // 베스트 앨범 Arraylist 생성
        ArrayList<Integer> bestAlbum = new ArrayList<>();
        
        
        for (String genre : genreList) {
            List<Song> songs = lists.get(genre);
            Collections.sort(songs);
    
            for (int i = 0; i < songs.size() && i < 2; i++) {
                bestAlbum.add(songs.get(i).id);
            }
        }
        
        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }
}

class Song implements Comparable<Song>{
    int id;
    int play;
    
    public Song(int id, int play) {
        this.id = id;
        this.play = play;
    }
    
    @Override
    public int compareTo(Song other) {
        
        if (this.play == other.play) {
            return this.id - other.id;
        }
        
        return other.play - this.play;
    }
}