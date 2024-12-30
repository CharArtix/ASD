package Week2.Author;

public class Book {
    private String Isbn;
    private String name;
    private Author author;
    private double price;
    private int qty;

    public Book(String Isbn, String name, Author author, double price, int qty) {
        this.Isbn = Isbn;
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getIsbn() {
        return Isbn;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthorName() {
        return author.getName();
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString() {
        return "'" + name + "' by " + author;  // author.toString()
    }
}
