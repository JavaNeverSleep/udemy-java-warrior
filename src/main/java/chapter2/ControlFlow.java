package chapter2;

import java.util.Scanner;

/**
 * if / else
 * switch / case
 * for while do-while
 * break continue return
 */
public class ControlFlow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户年龄：");
        double price = 19.99;
        int age = scanner.nextInt();
        if (age <= 12 || age >= 60) {
            price = price * 0.5;
        } else if (age < 18) {
            price = price * 0.8;
        }
        System.out.println("当前用户" + age + "岁，票价$" + price);

        // 定位Category：KID、ADULT、SENIOR，然后使用Switch Case
        int category = 2;
        if (age <= 12) {
            category = 1;
        } else if (age >= 60) {
            category = 3;
        }

        // 可以自动切换到enhanced switch
        switch (category) {
            case 1:
            case 3:
                price = 19.99 * 0.5;
                break;
            case 2:
                price = 19.99;
                break;
        }

        // 全家乐，先介绍for循环，再介绍while，再介绍do-while
        double cost = 0;
        while (scanner.hasNextInt()) {
            age = scanner.nextInt();
            if (age <= 12 || age >= 60) {
                cost += price * 0.5;
            } else if (age < 18) {
                cost += price * 0.8;
            }
        }
        System.out.println("全家乐，票价总计$" + cost);
    }

}
