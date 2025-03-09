# BookstoreUI.java Pseudocode Documentation

## Class Definition and Static Variables
```java
public class BookstoreUI {
    private static Queue<Order> orderQueue = new Queue<>();
    private static Stack<Order> orderStack = new Stack<>();
}
```
- `public class BookstoreUI`: Main class that runs the bookstore system
- Static variables:
  - `orderQueue`: Stores orders in processing order (FIFO)
  - `orderStack`: Stores orders for undo functionality (LIFO)

## Main Method
```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    while (!exit) {
        ConsoleUI.clearScreen();
        ConsoleUI.showMainMenu();
        System.out.print("\nEnter your choice (1-6): ");
        String input = scanner.nextLine();
        ConsoleUI.clearScreen();
        switch (input) {
            case "1":
                showOrderManagementMenu(scanner);
                break;
            case "2":
                showViewSearchMenu(scanner);
                break;
            case "3":
                exit = true;
                System.out.println("Thank you for using the Bookstore Order Processing System. Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                ConsoleUI.waitForEnter(scanner);
        }
    }
    scanner.close();
}
```
- Program entry point
- Creates scanner for user input
- Main program loop:
  1. Clears screen
  2. Shows main menu
  3. Gets user choice
  4. Processes choice:
     - 1: Order Management
     - 2: View and Search
     - 3: Exit Program
  5. Handles invalid input
- Closes scanner when done

## Order Management Menu
```java
private static void showOrderManagementMenu(Scanner scanner) {
    boolean back = false;
    while (!back) {
        ConsoleUI.clearScreen();
        ConsoleUI.showOrderManagementMenu();
        System.out.print("\nEnter your choice (1-3): ");
        String input = scanner.nextLine();
        ConsoleUI.clearScreen();
        
        switch (input) {
            case "1":
                placeOrder(scanner);
                break;
            case "2":
                undoLastOrder();
                break;
            case "3":
                back = true;
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
        if (!back) {
            ConsoleUI.waitForEnter(scanner);
        }
    }
}
```
- Handles order management operations
- Menu options:
  1. Place new order
  2. Undo last order
  3. Return to main menu
- Loops until user chooses to go back
- Waits for user confirmation after each action

## View and Search Menu
```java
private static void showViewSearchMenu(Scanner scanner) {
    boolean back = false;
    while (!back) {
        ConsoleUI.clearScreen();
        ConsoleUI.showViewSearchMenu();
        System.out.print("\nEnter your choice (1-3): ");
        String input = scanner.nextLine();
        ConsoleUI.clearScreen();
        
        switch (input) {
            case "1":
                viewOrders();
                break;
            case "2":
                searchOrder(scanner);
                break;
            case "3":
                back = true;
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
        if (!back) {
            ConsoleUI.waitForEnter(scanner);
        }
    }
}
```
- Handles order viewing and searching
- Menu options:
  1. View all orders
  2. Search for specific order
  3. Return to main menu
- Loops until user chooses to go back
- Waits for user confirmation after each action

## Place Order Method
```java
private static void placeOrder(Scanner scanner) {
    try {
        // Get customer information
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        if (!Validator.isValidCustomerName(customerName)) {
            ConsoleUI.displayError("Invalid customer name. Please use only letters and spaces.");
            return;
        }
        
        System.out.print("Enter shipping address: ");
        String shippingAddress = scanner.nextLine();
        if (!Validator.isValidShippingAddress(shippingAddress)) {
            ConsoleUI.displayError("Invalid shipping address. Please use only letters, digits, and spaces.");
            return;
        }
        
        // Get book information
        System.out.print("Enter number of books in the order: ");
        int numBooks = Integer.parseInt(scanner.nextLine());
        if (numBooks <= 0) {
            ConsoleUI.displayError("Number of books should be at least 1.");
            return;
        }
        
        // Create books array
        Book[] books = new Book[numBooks];
        for (int i = 0; i < numBooks; i++) {
            System.out.print("Enter title for book " + (i + 1) + ": ");
            String title = scanner.nextLine();
            if (title.trim().isEmpty()) {
                ConsoleUI.displayError("Book title cannot be empty.");
                return;
            }
            System.out.print("Enter quantity for book " + (i + 1) + ": ");
            int quantity = Integer.parseInt(scanner.nextLine());
            if (quantity <= 0) {
                ConsoleUI.displayError("Book quantity must be a positive integer.");
                return;
            }
            books[i] = new Book(title, quantity);
        }
        
        // Sort books and create order
        InsertionSorter.sort(books);
        Order newOrder = new Order(customerName, shippingAddress, books);
        orderQueue.enqueue(newOrder);
        orderStack.push(newOrder);
        ConsoleUI.displaySuccess("Order placed successfully! Order ID: " + newOrder.getOrderId());
    } catch (NumberFormatException e) {
        ConsoleUI.displayError("Input format error: " + e.getMessage());
    } catch (Exception e) {
        ConsoleUI.displayError("Error placing order: " + e.getMessage());
    }
}
```
- Complex method for creating new orders
- Steps:
  1. Get and validate customer name
  2. Get and validate shipping address
  3. Get number of books
  4. For each book:
     - Get and validate title
     - Get and validate quantity
  5. Sort books alphabetically
  6. Create new order
  7. Add to queue and stack
- Extensive error handling:
  - Input validation
  - Format checking
  - Quantity verification
- Success confirmation with order ID

## View Orders Method
```java
private static void viewOrders() {
    Object[] orderObjs = orderQueue.toArray();
    if (orderObjs.length == 0) {
        ConsoleUI.displayError("No orders available.");
        return;
    }
    Order[] orders = new Order[orderObjs.length];
    for (int i = 0; i < orderObjs.length; i++) {
        orders[i] = (Order) orderObjs[i];
    }
    InsertionSorter.sort(orders);
    ConsoleUI.displayOrders(orders);
}
```
- Displays all orders in system
- Steps:
  1. Get array of orders from queue
  2. Check if any orders exist
  3. Convert to Order array
  4. Sort orders
  5. Display formatted list
- Handles empty queue case

## Search Order Method
```java
private static void searchOrder(Scanner scanner) {
    try {
        System.out.print("Enter Order ID to search: ");
        int orderId = Integer.parseInt(scanner.nextLine());
        Order searchDummy = new Order(orderId);
        Object[] orders = orderQueue.toArray();
        int index = LinearSearcher.search(orders, searchDummy);
        if (index != -1) {
            Order foundOrder = (Order) orders[index];
            System.out.println("Order found:");
            System.out.println(foundOrder);
        } else {
            ConsoleUI.displayError("Order with ID " + orderId + " not found.");
        }
    } catch (Exception e) {
        ConsoleUI.displayError("Error searching for order: " + e.getMessage());
    }
}
```
- Searches for order by ID
- Steps:
  1. Get order ID from user
  2. Create dummy order for comparison
  3. Search through orders
  4. Display result or error
- Handles:
  - Invalid input
  - Order not found
  - Other errors

## Undo Last Order Method
```java
private static void undoLastOrder() {
    if (orderStack.isEmpty()) {
        ConsoleUI.displayError("No orders to undo.");
        return;
    }
    Order undoneOrder = orderStack.pop();

    Object[] ordersArray = orderQueue.toArray();
    Queue<Order> newQueue = new Queue<>();
    boolean found = false;
    for (Object obj : ordersArray) {
        Order order = (Order) obj;
        if (!found && order.equals(undoneOrder)) {
            found = true;
            continue;
        }
        newQueue.enqueue(order);
    }
    orderQueue = newQueue;
    ConsoleUI.displaySuccess("Undid order with ID: " + undoneOrder.getOrderId());
}
```
- Removes most recently added order
- Steps:
  1. Check if orders exist
  2. Remove from stack
  3. Create new queue without undone order
  4. Replace old queue
  5. Confirm undo
- Maintains order consistency between stack and queue

## Overall Purpose
The BookstoreUI class:
1. Provides main program interface
2. Manages order lifecycle:
   - Creation
   - Storage
   - Viewing
   - Searching
   - Undoing
3. Implements menu system
4. Handles user input
5. Validates all data
6. Manages data structures:
   - Queue for order processing
   - Stack for undo functionality
7. Provides error handling
8. Ensures data consistency
9. Creates user-friendly interface
10. Coordinates all system components 