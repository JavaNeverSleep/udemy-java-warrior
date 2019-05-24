package chapter2;

/**
 * 八种基本数据类型、变量定义、自JDK10引入的“var”
 * 建议您将对应代码自行编写、运行一遍，可自定义变量名、初始值
 */
public class PrimitiveDataTypes {

    public static void main(String[] args) {
        // 类型 变量名 赋值运算符 初始化值
        byte tom = 12;
        short nate = 36;
        int gordon = 61;
        long fib70 = 190392490709135L;
        // 工业标准：https://en.wikipedia.org/wiki/IEEE_754-1985
        float pie = 3.1415926f;
        double price = 19.99;
        char dollar = '$';
        boolean happy = true;

        System.out.println("Tom今年" + tom + "岁，半票：" + dollar + price * 0.5);
        System.out.println("Nate今年" + nate + "岁，全票：" + dollar + price);
        System.out.println("Gordon今年" + gordon + "岁，半票：" + dollar + price * 0.5);
        System.out.println("斐波那契数列第70号：" + fib70);
        System.out.println("祖冲之圆周率：" + pie + "~" + 3.1415927f);
        System.out.println("咱们老百姓啊嚯嘿今儿个真Happy：" + happy);

        var ageOfJoshua = 14;
        // 注意：var并非关键词，对比`double double = 0.8`会直接报错
        var var = price * 0.8;
        System.out.println("Joshua今年" + ageOfJoshua + "岁，八折票：" + var);
    }

}
