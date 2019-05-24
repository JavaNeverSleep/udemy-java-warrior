package chapter4;

import java.util.Arrays;

/**
 * Given a set of strings, find the longest common prefix
 */
public class LongestCommonPrefix {

    /**
     * Using word by word matching approach: LCP(w1, w2, w3) = LCP(LCP(w1, w2), w3)
     */
    private String resolveWordByWord(String[] words) {
        String ret = words[0];
        for (int i = 1; i < words.length; i++) {
            ret = findCommonPrefix(ret, words[i]);
        }
        return ret;
    }

    private String findCommonPrefix(String w1, String w2) {
        int i = 0;
        for (; i < w1.length() && i < w2.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                break;
            }
        }
        return w1.substring(0, i);
    }

    /**
     * Using char by char matching approach:
     * Scan from left to right and terminate when different char found
     */
    private String resolveCharByChar(String[] words) {
        int i = 0;
        outer:
        while (true) {
            char c = words[0].charAt(i);
            for (int j = 1; j < words.length; j++) {
                if (words[j].charAt(i) != c) {
                    break outer;
                }
            }
            i++;
        }
        return words[0].substring(0, i);
    }

    /**
     * A quick and "dirty" approach: sorting the words first
     * Then find common prefix of the first and last word
     */
    private String resolveBySorting(String[] words) {
        Arrays.sort(words);
        return findCommonPrefix(words[0], words[words.length - 1]);
    }

    /**
     * Using divider and conquer approach, similar as merge sort
     */
    private String resolveByDC(String[] words) {
        return resolveByDC(words, 0, words.length - 1);
    }

    private String resolveByDC(String[] words, int low, int high) {
        if (low == high) return words[low];

        int mid = low + (high - low) / 2;
        return findCommonPrefix(resolveByDC(words, low, mid), resolveByDC(words, mid + 1, high));
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        assert lcp.resolveWordByWord(new String[]{"geeksforgeeks", "geeks", "geek", "geezer"}).equals("gee");
        assert lcp.resolveWordByWord(new String[]{"geeksforgeeks", "apple", "hello", "ok"}).equals("");

        assert lcp.resolveCharByChar(new String[]{"geeksforgeeks", "geeks", "geek", "geezer"}).equals("gee");
        assert lcp.resolveCharByChar(new String[]{"geeksforgeeks", "apple", "hello", "ok"}).equals("");

        assert lcp.resolveBySorting(new String[]{"geeksforgeeks", "geeks", "geek", "geezer"}).equals("gee");
        assert lcp.resolveBySorting(new String[]{"geeksforgeeks", "apple", "hello", "ok"}).equals("");

        assert lcp.resolveByDC(new String[]{"geeksforgeeks", "geeks", "geek", "geezer"}).equals("gee");
        assert lcp.resolveByDC(new String[]{"geeksforgeeks", "apple", "hello", "ok"}).equals("");
    }

}
