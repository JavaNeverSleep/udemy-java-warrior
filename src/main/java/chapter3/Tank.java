package chapter3;

public class Tank extends GameObject implements Movable {

    private String direction = "South";

    private int speed = 5;

    private boolean isEnemy = false;

    Tank(int x, int y) {
        super(x, y);
    }

    @Override
    void show() {
        if (isEnemy) {
            System.err.println("An Enemy Tank Here!");
        } else {
            System.out.println("A Player Tank Here!");
        }
    }

    @Override
    public void move() {
        if ("South".equals(direction)) {
            this.setY(this.getY() + speed);
        } else if ("North".equals(direction)) {
            this.setY(this.getY() - speed);
        } else if ("West".equals(direction)) {
            this.setX(this.getX() - speed);
        } else {
            this.setX(this.getX() + speed);
        }
    }

    private void fire() {
        System.out.println("Ready? Fire!");
    }

    public static void main(String[] args) {
        // 注意下面三处变量定义之后导致的方法可见度差异
        Movable movable = new Tank(0, 0);
        movable.move();
        // 强制转换：一般不推荐
        ((Tank) movable).fire();

        GameObject object = new Tank(0, 0);
        object.show();

        Tank tank = new Tank(0, 0);
        tank.show();
        tank.fire();

        tank.isEnemy = true;
        tank.show();
    }
}
