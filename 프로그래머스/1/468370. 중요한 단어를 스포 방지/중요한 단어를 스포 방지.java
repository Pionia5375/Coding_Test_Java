import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        List<Word> words = new ArrayList<>();
        int curr = 0;
        String[] tokens = message.split(" ");
        
        for (String token : tokens) {
            words.add(new Word(token, curr, curr + token.length() - 1));
            curr += token.length() + 1;
        }

        Set<String> nonSpoilerTexts = new HashSet<>();

        for (Word w : words) {
            for (int i = 0; i < spoiler_ranges.length; i++) {
                int ss = spoiler_ranges[i][0];
                int se = spoiler_ranges[i][1];
                if (!(w.end < ss || w.start > se)) {
                    w.isSpoiler = true;
                    w.maxSpoilerIdx = Math.max(w.maxSpoilerIdx, i);
                }
            }
            if (!w.isSpoiler) {
                nonSpoilerTexts.add(w.text);
            }
        }

        Map<Integer, List<Word>> revealedByStep = new HashMap<>();
        for (Word w : words) {
            if (w.isSpoiler) {
                revealedByStep.computeIfAbsent(w.maxSpoilerIdx, k -> new ArrayList<>()).add(w);
            }
        }

        int importantCount = 0;
        Set<String> revealedSpoilerTexts = new HashSet<>();

        for (int step = 0; step < spoiler_ranges.length; step++) {
            if (revealedByStep.containsKey(step)) {
                List<Word> stepWords = revealedByStep.get(step);
                stepWords.sort(Comparator.comparingInt(w -> w.start));

                for (Word w : stepWords) {
                    String text = w.text;
                    if (!nonSpoilerTexts.contains(text) && !revealedSpoilerTexts.contains(text)) {
                        importantCount++;
                    }
                    revealedSpoilerTexts.add(text);
                }
            }
        }

        return importantCount;
    }
    
    class Word {
        String text;
        int start, end;
        boolean isSpoiler;
        int maxSpoilerIdx;

        Word(String text, int start, int end) {
            this.text = text;
            this.start = start;
            this.end = end;
            this.isSpoiler = false;
            this.maxSpoilerIdx = -1;
        }
    }
}