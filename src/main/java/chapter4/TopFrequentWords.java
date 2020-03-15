package chapter4;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Showcase of PriorityQueue: Get most frequent n words from given text file
 */
public class TopFrequentWords {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> freqencies = new HashMap<>();
        // Use 'A Tale of Two cities' by default, or from arguments passed
        String path = args.length > 0 ? args[0] : "data/chapter4/tale.txt";
        try (Scanner sc = new Scanner(new File(path), StandardCharsets.UTF_8)) {
            while (sc.hasNext()) {
                String word = sc.next();
                freqencies.put(word, freqencies.getOrDefault(word, 0) + 1);
            }
        }

        Comparator<Entry<String, Integer>> comp = (a, b) -> a.getValue() - b.getValue();
        PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue<>(comp);
        int size = args.length > 1 ? Integer.parseInt(args[1]) : 12;
        for (Entry<String, Integer> entry : freqencies.entrySet()) {
            if (pq.size() < size) {
                pq.offer(entry);
            } else if (comp.compare(entry, pq.peek()) > 0) {
                pq.poll();
                pq.offer(entry);
            }
        }

        System.out.println("Top " + pq.size() + " frequent words in " + path + ":");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

}