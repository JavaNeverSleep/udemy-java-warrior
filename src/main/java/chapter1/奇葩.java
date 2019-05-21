package chapter1;

/**
 * <pre>
 * 奇葩 means a super weird man in Chinese, some says Donald Trump is a 奇葩
 * This file is just created to demonstrate UTF-16 support of Java
 * Write code like this, you would probably be fired soon! Don't do it, man.
 * </pre>
 */
public class 奇葩 {
    /**
     * Age of the weird guy, field name in traditional Chinese
     */
    private int 年齡;

    /**
     * Name of the weird guy, field name in Korean
     */
    private String 이름;

    public 奇葩(int 年齡, String 이름) {
        this.年齡 = 年齡;
        this.이름 = 이름;
    }

    /**
     * When a weird man begins to talk, method name in Japanese
     */
    private void 話す() {
        System.out.printf("大家好！在下%s，今年%d。总有些人说我奇葩，可您倒是说说，我哪里奇葩啦？", this.이름, this.年齡);
    }

    public static void main(String[] args) {
        奇葩 老罗 = new 奇葩(47, "罗永浩");
        老罗.話す();
    }

}
