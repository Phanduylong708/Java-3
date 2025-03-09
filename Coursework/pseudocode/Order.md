# Order.java Pseudocode Documentation

## Class Definition
```java
public class Order implements Comparable<Order>
```
- `public`: The class can be accessed from anywhere in the program
- `class Order`: Defines a class that represents an order in the bookstore
- `implements Comparable<Order>`: Allows orders to be compared and sorted

## Static Variables
```java
private static int orderCounter = 1;
public static int sortMode = 1;
```
- `private static int orderCounter`: Shared counter for generating unique order IDs
- `public static int sortMode`: Controls how orders are sorted (1 = by ID, 2 = by customer name)

## Instance Variables
```java
private int orderId;
private String customerName;
private String shippingAddress;
private Book[] books;
```
- `private int orderId`: Unique identifier for each order
- `private String customerName`: Name of the customer who placed the order
- `private String shippingAddress`: Delivery address for the order
- `private Book[] books`: Array of books included in the order

## Constructors
```java
public Order(String customerName, String shippingAddress, Book[] books) {
    this.orderId = orderCounter++;
    this.customerName = customerName;
    this.shippingAddress = shippingAddress;
    this.books = books;
}

public Order(int orderId) {
    this.orderId = orderId;
}
```
- Full Constructor:
  - Creates a complete order with all details
  - Automatically assigns a unique order ID
  - Increments the orderCounter for next order
- Search Constructor:
  - Creates a dummy order with just an ID
  - Used for searching orders by ID

## Getter Methods
```java
public int getOrderId() {
    return orderId;
}

public String getCustomerName() {
    return customerName;
}
```
- `getOrderId()`: Returns the unique ID of the order
- `getCustomerName()`: Returns the customer's name (needed for sorting)

## Equals Method
```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Order other = (Order) obj;
    return this.orderId == other.orderId;
}
```
- Overrides default equals method
- Checks if two orders are the same
- Returns true if:
  - Same object reference, or
  - Same order ID
- Used for searching and comparing orders

## Explanation:
// In the line:
//     Order other = (Order) obj;
// there are two parts:
// 1. 'Order other' declares a new variable named 'other' of type Order.
// 2. '(Order) obj' is a type cast that converts the generic Object 'obj' into an Order.
// This casting is necessary because the parameter 'obj' is of type Object, which is a very general type.
// By casting it to Order, we inform Java that we intend to treat 'obj' as an Order, so that we can access Order-specific fields (like orderId) for comparing equality.

## ToString Method
```java
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
```
- Creates a formatted string representation of the order
- Includes:
  - Order ID
  - Customer Name
  - Shipping Address
  - List of books (with quantities)
- Handles case where books array is null
- Uses StringBuilder for efficient string concatenation

## CompareTo Method
```java
@Override
public int compareTo(Order other) {
    if (sortMode == 1) {
        return this.orderId - other.orderId;
    } else if (sortMode == 2) {
        return this.customerName.compareTo(other.customerName);
    }
    return this.orderId - other.orderId;
}
```
- Defines how orders should be sorted
- Two sorting modes:
  - Mode 1: Sort by Order ID (numerical order)
  - Mode 2: Sort by Customer Name (alphabetical order)
- Returns:
  - Negative if this order should come before other
  - Zero if orders are equal
  - Positive if this order should come after other

## Overall Purpose
The Order class is a central component that:
1. Represents a customer's book order
2. Maintains unique order identification
3. Stores customer and shipping information
4. Manages list of ordered books
5. Supports flexible sorting options
6. Provides formatted string output
7. Enables order comparison and searching
8. Uses static counter to ensure unique IDs
9. Implements proper object comparison methods 