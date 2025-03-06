import java.util.Scanner;

public class ConsoleUI {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void showMainMenu() {
        printHeader("BOOKSTORE ORDER PROCESSING SYSTEM");
        System.out.println("1. Order Management");
        System.out.println("2. View and Search");
        System.out.println("3. Exit System");
        printSeparator();
    }

    public static void showOrderManagementMenu() {
        printHeader("ORDER MANAGEMENT");
        System.out.println("1. Place New Order");
        System.out.println("2. Undo Last Order");
        System.out.println("3. Back to Main Menu");
        printSeparator();
    }

    public static void showViewSearchMenu() {
        printHeader("VIEW AND SEARCH");
        System.out.println("1. View All Orders");
        System.out.println("2. Search Order by ID");
        System.out.println("3. Back to Main Menu");
        printSeparator();
    }

    public static void printHeader(String title) {
        String border = "=".repeat(50);
        System.out.println(border);
        System.out.println(" ".repeat((50 - title.length()) / 2) + title);
        System.out.println(border);
    }

    public static void printSeparator() {
        System.out.println("-".repeat(50));
    }

    public static void waitForEnter(Scanner scanner) {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public static void displayOrders(Order[] orders) {
        if (orders.length == 0) {
            System.out.println("No orders available.");
            return;
        }
        System.out.println("----- All Orders -----");
        for (Order order : orders) {
            System.out.println(order);
            System.out.println("----------------------");
        }
    }

    public static void displayError(String message) {
        System.out.println("Error: " + message);
    }

    public static void displaySuccess(String message) {
        System.out.println("Success: " + message);
    }
} 