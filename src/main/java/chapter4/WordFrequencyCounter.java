package chapter4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * <pre>
 * 样例数据版权属于普林斯顿大学Robert Sedgewick和Kevin Wayne：
 * https://algs4.cs.princeton.edu/31elementary/tinyTale.txt
 * https://algs4.cs.princeton.edu/31elementary/tale.txt
 *
 * 完整版本双城记、英王钦定本圣经、繁体版本三国志演义来自
 * <a href="https://www.gutenberg.org">Project Gutenberg</a>
 * </pre>
 */
public class WordFrequencyCounter {

    private void execUsingHashSet(String filePath) {
        final long now = System.currentTimeMillis();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            Set<String> distinctWords = new HashSet<>();
            while (scanner.hasNext()) {
                distinctWords.add(scanner.next());
            }
            System.out.printf("文件%s基于HashSet扫描完毕，内含%d个不重复单词，扫描耗时%.2f秒%n",
                file.getAbsolutePath(), distinctWords.size(), (System.currentTimeMillis() - now) / 1000.0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void execUsingHashMap(String filePath) {
        final long now = System.currentTimeMillis();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            Map<String, Integer> map = new HashMap<>();
            while (scanner.hasNext()) {
                String word = scanner.next();
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            System.out.printf("文件%s基于HashMap扫描完毕，内含%d个不重复单词，扫描耗时%.2f秒%n",
                file.getAbsolutePath(), map.size(), (System.currentTimeMillis() - now) / 1000.0);

            for (Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "出现" + entry.getValue() + "次");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void execViaStream(String filePath) {
        final long now = System.currentTimeMillis();
        try {
            Path path = Paths.get(filePath);
            long count = Files.lines(path)
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .distinct().count();
            System.out.printf("文件%s基于Stream扫描完毕，内含%d个不重复单词，扫描耗时%.2f秒%n",
                path.toString(), count, (System.currentTimeMillis() - now) / 1000.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length < 1)
            throw new IllegalArgumentException("请输入有效的文件路径继续");

        String filePath = "data/chapter4/" + args[0];
        WordFrequencyCounter counter = new WordFrequencyCounter();
        counter.execUsingHashSet(filePath);
        counter.execUsingHashMap(filePath);
        counter.execViaStream(filePath);
    }

}
