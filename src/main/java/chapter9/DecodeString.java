package chapter9;

import java.util.Stack;

public class DecodeString {

    String decodeString(String s) {
        int begin = s.indexOf('[');
        if (begin < 0) return s;

        int end = -1;
        int count = 1;
        for (int i = begin + 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                count++;
            } else if (c == ']') {
                if (count == 1) {
                    end = i;
                    break;
                } else {
                    count--;
                }
            }
        }

        int digitBegin = 0;
        while (!Character.isDigit(s.charAt(digitBegin))) {
            digitBegin++;
        }

        int times = Integer.parseInt(s.substring(digitBegin, begin));
        String str = s.substring(begin + 1, end);

        return decodeString(s.substring(0, digitBegin)) +
            repeat(decodeString(str), times) + decodeString(s.substring(end + 1));
    }

    private String repeat(String s, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    String decodeStringIteratively(String s) {
        if (s.indexOf('[') < 0) return s;

        Stack<Integer> times = new Stack<>();
        Stack<StringBuilder> content = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (Character.isDigit(s.charAt(++i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                }
                times.push(num);
                content.push(new StringBuilder());
            } else if (c != '[' && c != ']') {
                if (content.isEmpty())
                    content.push(new StringBuilder().append(c));
                else
                    content.peek().append(c);
            } else if (c == ']') {
                int repeatTimes = times.pop();
                String str = repeat(content.pop().toString(), repeatTimes);
                if (content.isEmpty())
                    content.push(new StringBuilder(str));
                else
                    content.peek().append(str);
            }
        }
        return content.pop().toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        assert solution.decodeStringIteratively("abc").equals("abc");
        assert solution.decodeStringIteratively("3[a]2[bc]").equals("aaabcbc");
        assert solution.decodeStringIteratively("3[a2[c]]").equals("accaccacc");
        assert solution.decodeStringIteratively("2[abc]3[cd]ef").equals("abcabccdcdcdef");

        assert solution.decodeString("abc").equals("abc");
        assert solution.decodeString("3[a]2[bc]").equals("aaabcbc");
        assert solution.decodeString("3[a2[c]]").equals("accaccacc");
        assert solution.decodeString("2[abc]3[cd]ef").equals("abcabccdcdcdef");
    }

}
