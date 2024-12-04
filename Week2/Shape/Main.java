package Week2.Shape;

public class Main {

    public static void main(String[] args) {
        Shape randomShape = new Shape();
        System.out.println(randomShape);
        Rectangle myBook = new Rectangle(7.5,20.0);
        System.out.println(myBook);
        Square myTissue = new Square(2.5);
        System.out.println(myTissue);
        Circle s = new Circle(10);
        System.out.println(s+" with area: "+s.getArea()+"cm sq.");

    }
}
