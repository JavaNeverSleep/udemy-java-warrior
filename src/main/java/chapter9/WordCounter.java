package chapter9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * <pre>
 * 样例数据版权属于普林斯顿大学Robert Sedgewick和Kevin Wayne：
 * https://algs4.cs.princeton.edu/31elementary/tinyTale.txt
 * https://algs4.cs.princeton.edu/31elementary/tale.txt
 *
 * 完整版本双城记、英王钦定本圣经、繁体版本三国志演义来自
 * <a href="https://www.gutenberg.org">Project Gutenberg</a>
 *
 * 数据结构视觉效果演示：https://visualgo.net/en/list
 * </pre>
 */
public class WordCounter {

    private void countWordsUsingArray(String filePath) {
        final long now = System.currentTimeMillis();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            String[] words = new String[50];
            int i = 0;
            while (scanner.hasNext()) {
                if (i == words.length) {
                    // 对数组扩容
                    String[] expanded = new String[words.length * 2];
                    System.arraycopy(words, 0, expanded, 0, words.length);
                    words = expanded;
                }
                words[i++] = scanner.next();
            }
            System.out.printf("文件%s基于数组扫描完毕，内含%d个单词，扫描耗时%.2f秒%n",
                file.getAbsolutePath(), i, (System.currentTimeMillis() - now) / 1000.0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void countWordsUsingArrayList(String filePath) {
        final long now = System.currentTimeMillis();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            List<String> words = new ArrayList<>();
            while (scanner.hasNext()) {
                // 内部封装了扩容操作
                words.add(scanner.next());
            }
            System.out.printf("文件%s基于ArrayList扫描完毕，内含%d个单词，扫描耗时%.2f秒%n",
                file.getAbsolutePath(), words.size(), (System.currentTimeMillis() - now) / 1000.0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void countWordsUsingLinkedList(String filePath) {
        final long now = System.currentTimeMillis();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            List<String> words = new LinkedList<>();
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
            System.out.printf("文件%s基于链表扫描完毕，内含%d个单词，扫描耗时%.2f秒%n",
                file.getAbsolutePath(), words.size(), (System.currentTimeMillis() - now) / 1000.0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length < 1)
            throw new IllegalArgumentException("请输入有效的文件路径继续");

        String filePath = "data/chapter9/" + args[0];
        String strategy = args.length > 1 ? args[1] : "Array";
        WordCounter counter = new WordCounter();
        if ("Array".equalsIgnoreCase(strategy)) {
            counter.countWordsUsingArray(filePath);
        } else if ("ArrayList".equalsIgnoreCase(strategy)) {
            counter.countWordsUsingArrayList(filePath);
        } else if ("LinkedList".equalsIgnoreCase(strategy)) {
            counter.countWordsUsingLinkedList(filePath);
        }
    }

}
