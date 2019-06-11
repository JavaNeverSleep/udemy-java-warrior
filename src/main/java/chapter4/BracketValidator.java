package chapter4;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 基于Stack对表达式开闭合法性进行检测
 */
public class BracketValidator {

    public static void main(String[] args) {
        assert isValid("[1, 2]");
        assert isValid("<[1, 2]>");
        assert isValid("[1, [2, 3], 4]");
        assert isValid("[{}, {{}}, (())]");
        assert !isValid("[1, 2] + }");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您要校验的表达式：");
        while (scanner.hasNextLine()) {
            String expression = scanner.nextLine();
            if ("/EXIT".equalsIgnoreCase(expression))
                break;
            if (isValid(expression))
                System.out.println(expression + "是有效表达式");
            else
                System.out.println(expression + "不是有效表达式！");
        }
    }

    private static Map<Character, Character> MAPPINGS = Map.of(
        ']', '[', '}', '{', ')', '(' , '>', '<'
    );

    private static boolean isValid(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '[' || c == '{' || c == '(' || c == '<') {
                stack.push(i);
            } else if (MAPPINGS.containsKey(c)) {
                if (stack.isEmpty() || expression.charAt(stack.peek()) != MAPPINGS.get(c)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

}
