package Week3.moveable;

/**
 * ES234317 - Algorithms and Data Structures
 * Gasal | 2024-2025
 * Coursework   : 02
 * Student ID   :
 * Full Name    :
 * Class        :
 */

public class Main {

    public static void main(String[] args) {
        Movable m1 = new MovablePoint(5, 6, 10, 15);     // upcast
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);

        Movable m2 = new MovableCircle(1, 2, 3, 4, 20);  // upcast
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);

        Movable m3 = new MovableRectangle(0, 0, 10, 10, 5, 10);  // upcast
        System.out.println(m3);
        m3.moveRight();
        System.out.println(m3);


    }
}
