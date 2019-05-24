package chapter2;

import java.util.Calendar;

public class Operators {

    public static void main(String[] args) {
        // 常规运算：加减乘除、求余
        int length = 10, width = 8;
        int perimeter = length * 2 + width * 2;
        int area = length * width;
        System.out.println("单位厘米，周长：" + perimeter + ", 面积：" + area);
        // 对比 area / 100结果
        double areaInDM = area / 100d;
        System.out.println("单位分米，周长：" + perimeter / 10d + ", 面积：" + areaInDM);
        // 求余：假定1900-1-1是周一，那么1900-1-31日是周几？
        int weekDay = 1 + 30 % 7;
        System.out.println("weekDay = " + weekDay);
        // 如何判定某个年份是闰年？
        int year = Calendar.getInstance().get(Calendar.YEAR);
        boolean isLeapYear = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
        System.out.println(year + (isLeapYear ? "是" : "不是") + "闰年");

        // 关系运算符：== != < > <= >= instanceof
        float rest = 1.0f - 0.9f;
        System.out.println(rest + " -> " + (rest == 0.1f));
        double left = 1.0 - 0.9;
        System.out.println(left + " -> " + (left == 0.1));
        left = 1.0 - 0.1;
        System.out.println(left + " -> " + (left == 0.9));

        boolean eq = Math.abs(rest - 0.1f) < 1e-7;
        System.out.println(rest + " == 0.1f: " + eq);

        // 条件运算符 && ||
        float balance = 300, price = 189.99f;
        // 注意！此时equals(f1, f2)不会执行
        if (weekDay == 3 || equals(balance - price, 10.01f)) {
            System.out.println("周三、或者余额等于$10.01时赶紧出手买下！");
        }
        // 此时equals(f1, f2)必须执行
        if (weekDay == 3 && equals(balance, 300.0f)) {
            System.out.println("日子是周三，纹银有三百两，这事能成！");
        }
        // 注意！此时equals(f1, f2)不会执行
        if (weekDay == 5 && equals(balance, 300.0f)) {
            System.out.println("今儿个是周五，纹银有三百两，去超市大采购！");
        }
    }

    private static boolean equals(float f1, float f2) {
        float minus = f1 - f2;
        System.out.printf("%f - %f = %f%n", f1, f2, minus);
        return Math.abs(minus) < 1e-7;
    }

}
