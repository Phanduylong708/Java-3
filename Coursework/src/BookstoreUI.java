import java.util.Scanner;

public class BookstoreUI {

    private static Queue<Order> orderQueue = new Queue<>();
    private static Stack<Order> orderStack = new Stack<>();

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

    private static void placeOrder(Scanner scanner) {
        try {
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
            
            System.out.print("Enter number of books in the order: ");
            int numBooks = Integer.parseInt(scanner.nextLine());
            if (numBooks <= 0) {
                ConsoleUI.displayError("Number of books should be at least 1.");
                return;
            }
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
}

