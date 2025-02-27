public class Book implements Comparable<Book> {
    private String title;
    private int quantity;

    public Book(String title, int quantity) {
        this.title = title;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return title + " (Qty: " + quantity + ")";
    }
    
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
} 