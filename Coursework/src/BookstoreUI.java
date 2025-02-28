import java.util.Scanner;

public class BookstoreUI {

    private static Queue<Order> orderQueue = new Queue<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            showMenu();
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    placeOrder(scanner);
                    break;
                case "2":
                    viewOrders();
                    break;
                case "3":
                    searchOrder(scanner);
                    break;
                case "4":
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("========= Bookstore Order Processing System =========");
        System.out.println("1. Place a New Order");
        System.out.println("2. View All Orders");
        System.out.println("3. Search Order by Order ID");
        System.out.println("4. Exit");
        System.out.println("=======================================================");
    }

    private static void placeOrder(Scanner scanner) {
        try {
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();
            // Validate customer name using Validator
            if (!Validator.isValidCustomerName(customerName)) {
                System.out.println("Invalid customer name. Please use only letters and spaces.");
                return;
            }
            
            System.out.print("Enter shipping address: ");
            String shippingAddress = scanner.nextLine();
            // Validate shipping address using Validator (allowing letters, digits, and spaces)
            if (!Validator.isValidShippingAddress(shippingAddress)) {
                System.out.println("Invalid shipping address. Please use only letters, digits, and spaces.");
                return;
            }
            
            System.out.print("Enter number of books in the order: ");
            int numBooks = Integer.parseInt(scanner.nextLine());
            if (numBooks <= 0) {
                System.out.println("Number of books should be at least 1.");
                return;
            }
            Book[] books = new Book[numBooks];
            for (int i = 0; i < numBooks; i++) {
                System.out.print("Enter title for book " + (i + 1) + ": ");
                String title = scanner.nextLine();
                // We don't validate book title now (only non-empty check is required)
                if (title.trim().isEmpty()) {
                    System.out.println("Book title cannot be empty.");
                    return;
                }
                System.out.print("Enter quantity for book " + (i + 1) + ": ");
                int quantity = Integer.parseInt(scanner.nextLine());
                if (quantity <= 0) {
                    System.out.println("Book quantity must be a positive integer.");
                    return;
                }
                books[i] = new Book(title, quantity);
            }
            // Sort the books by title using Insertion Sort
            InsertionSorter.sort(books);
            
            Order newOrder = new Order(customerName, shippingAddress, books);
            orderQueue.enqueue(newOrder);
            System.out.println("Order placed successfully! Order ID: " + newOrder.getOrderId());
        } catch (NumberFormatException e) {
            System.out.println("Input format error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error placing order: " + e.getMessage());
        }
    }
    
    private static void viewOrders() {
        Object[] orders = orderQueue.toArray();
        if (orders.length == 0) {
            System.out.println("No orders available.");
            return;
        }
        System.out.println("----- All Orders -----");
        for (Object obj : orders) {
            Order order = (Order) obj;
            System.out.println(order);
            System.out.println("----------------------");
        }
    }
    
    private static void searchOrder(Scanner scanner) {
        try {
            System.out.print("Enter Order ID to search: ");
            int orderId = Integer.parseInt(scanner.nextLine());
            // Use a dummy Order with the given orderId for comparison
            Order searchDummy = new Order(orderId);
            Object[] orders = orderQueue.toArray();
            int index = LinearSearcher.search(orders, searchDummy);
            if (index != -1) {
                Order foundOrder = (Order) orders[index];
                System.out.println("Order found:");
                System.out.println(foundOrder);
            } else {
                System.out.println("Order with ID " + orderId + " not found.");
            }
        } catch (Exception e) {
            System.out.println("Error searching for order: " + e.getMessage());
        }
    }
}
