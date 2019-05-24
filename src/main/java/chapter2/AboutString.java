package chapter2;

import java.util.Scanner;

/**
 * 基本的非基本类型：字符串
 */
public class AboutString {

    public static void main(String[] args) {
        System.out.println("请输入任意多个字符，敲回车结束：");
        String str = new Scanner(System.in).nextLine();
        System.out.println("您的输入结果是：");
        System.out.println(str);
        System.out.println("总计" + str.length() + "个字符");
        System.out.println("第一个字符：" + str.charAt(0));
        System.out.println("第二个字符：" + str.charAt(str.length() - 1));
        System.out.println("转为全部大写：" + str.toUpperCase());
        System.out.println("转为全部小写：" + str.toLowerCase());
        System.out.println("是否包含Hello World：" + str.contains("Hello World"));
        System.out.println("去掉首末两个字符之后：" + str.substring(1, str.length() - 1));
    }

}
