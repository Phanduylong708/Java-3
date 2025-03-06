public class Order implements Comparable<Order> {
    private static int orderCounter = 1;
    
    //1 for sorting by Order ID, 2 for sorting by Customer Name
    public static int sortMode = 1;
    
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
    
    // New getter for customerName required for sorting by customer name
    public String getCustomerName() {
        return customerName;
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
    
    // Implement compareTo for dynamic sorting based on sortMode
    @Override
    public int compareTo(Order other) {
        if (sortMode == 1) { // sort by Order ID
            return this.orderId - other.orderId;
        } else if (sortMode == 2) { // sort by Customer Name
            return this.customerName.compareTo(other.customerName);
        }
        // Default: sort by Order ID
        return this.orderId - other.orderId;
    }
} 