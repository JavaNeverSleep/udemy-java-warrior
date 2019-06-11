package chapter3;

class Wall extends GameObject {
    Wall(int x, int y) {
        super(x, y);
    }

    @Override
    void show() {
        System.out.println("A Wall Here!");
    }

    public static void main(String[] args) {
        Wall wall = new Wall(10, 10);
        wall.show();
        // 无法访问Missile类私有构造方法
        // Missile missile = new Missile(50, 50);
        Tank tank = new Tank(0, 0);
        // tank.fire()无法于此处访问
        tank.show();
    }
}
