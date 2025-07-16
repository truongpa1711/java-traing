package Collection_Algorithm;

import java.util.*;

//Đếm top K từ xuất hiện nhiều nhất
public class B3 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        List<String> uniqueWords = new ArrayList<>(wordCount.keySet());
        uniqueWords.sort((a, b) -> {
            if (wordCount.get(a).equals(wordCount.get(b))) {
                return a.compareTo(b); // Sort alphabetically if counts are equal
            }
            return wordCount.get(b) - wordCount.get(a); // Sort by frequency in descending order
        });
        return uniqueWords.subList(0, Math.min(k, uniqueWords.size()));
    }
    public static void main(String[] args) {

    }


}
