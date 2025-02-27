public class Order {
    private static int orderCounter = 1;
    
    private int orderId;
    private String customerName;
    private String shippingAddress;
    private Book[] books;
    
    // Full constructor: auto-assigns a unique orderId
    public Order(String customerName, String shippingAddress, Book[] books) {
        this.orderId = orderCounter++;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.books = books;
    }
    
    // Partial constructor for search purposes (only orderId is needed)
    public Order(int orderId) {
        this.orderId = orderId;
    }
    
    public int getOrderId() {
        return orderId;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order other = (Order) obj;
        return this.orderId == other.orderId;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Customer Name: ").append(customerName).append("\n");
        sb.append("Shipping Address: ").append(shippingAddress).append("\n");
        sb.append("Books:\n");
        if (books != null) {
            for (Book book : books) {
                sb.append(" - ").append(book.toString()).append("\n");
            }
        } else {
            sb.append(" No books in order.\n");
        }
        return sb.toString();
    }
} 