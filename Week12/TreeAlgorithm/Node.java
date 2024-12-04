package Week12.TreeAlgorithm;

public class Node {
    private String value;
    private Node left;
    private Node right;

    Node(String v) {
        this.value = v;
    }

    Node(String v, Node l, Node r) {
        this.value = v;
        this.left = l;
        this.right = r;
    }

    public void setLeft(Node l) {
        this.left = l;
    }

    public void setRight(Node r) {
        this.right = r;
    }

    public void setValue(String v) {
        this.value = v;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public String getValue() {
        return this.value;
    }

    public void traverseIn(Node r) {
        if (r.left != null)
            traverseIn(r.left);
        System.out.print(r.value + " ");
        if (r.right != null)
            traverseIn(r.right);
    }

    public void traversePre(Node r) {
        if (r.left != null)
            traversePre(r.left);
        if (r.right != null)
            traversePre(r.right);
        System.out.print(r.value + " ");
    }
}
