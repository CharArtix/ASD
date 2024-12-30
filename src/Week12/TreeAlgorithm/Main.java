package Week12.TreeAlgorithm;

public class Main {
    public static void main(String[] args) {
        Node a = new Node("A", new Node("B", new Node("D"), new Node("E")),
                new Node("C", null, new Node("F", new Node("G"), new Node("H"))));
        
        System.out.println("In Order Traversal");
        a.traverseIn(a);
        System.out.println("");
        System.out.println("Post Order Traversal");
        a.traversePre(a);
    }
}
