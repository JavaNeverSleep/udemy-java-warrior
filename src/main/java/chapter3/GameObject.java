package chapter3;

/**
 * 定义坦克大战游戏中游戏物体，为一抽象概念，使用抽象类进行模拟
 */
abstract class GameObject {

    private int x, y;

    GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    abstract void show();

}
