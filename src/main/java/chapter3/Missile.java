package chapter3;

public class Missile extends GameObject implements Movable {
    private Missile(int x, int y) {
        super(x, y);
    }

    @Override
    void show() {
        System.out.println("A Missile Here");
    }

    @Override
    public void move() {
        System.out.println("A Missile Flying!");
    }

    public static void main(String[] args) {
        Movable movable = new Missile(50, 50);
        movable.move();
    }
}
