# ConsoleUI.java Pseudocode Documentation

## Class Definition
```java
public class ConsoleUI
```
- `public`: The class can be accessed from anywhere in the program
- `class ConsoleUI`: A utility class that handles all console-based user interface operations

## Screen Clearing
```java
public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
}
```
- `public static`: Method can be called without creating a ConsoleUI object
- Clears the console screen
- Uses ANSI escape codes:
  - `\033[H`: Moves cursor to home position (top-left)
  - `\033[2J`: Clears entire screen
- `System.out.flush()`: Ensures all output is displayed

## Menu Display Methods
```java
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
```
- Three different menu displays:
  1. Main Menu: Primary system options
  2. Order Management Menu: Order-related operations
  3. View/Search Menu: Order viewing and searching options
- Each menu:
  - Shows a header with the menu name
  - Lists numbered options
  - Shows a separator line at bottom
- Consistent format across all menus

## Header and Separator Methods
```java
public static void printHeader(String title) {
    String border = "=".repeat(50);
    System.out.println(border);
    System.out.println(" ".repeat((50 - title.length()) / 2) + title);
    System.out.println(border);
}

public static void printSeparator() {
    System.out.println("-".repeat(50));
}
```
- `printHeader`: Creates formatted header
  - Takes title as parameter
  - Creates border line of 50 '=' characters
  - Centers title between borders
  - Example output:
    ```
    ==================================================
                  ORDER MANAGEMENT
    ==================================================
    ```
- `printSeparator`: Creates divider line
  - Uses 50 '-' characters
  - Visual separation between sections

## User Interaction Methods
```java
public static void waitForEnter(Scanner scanner) {
    System.out.println("\nPress Enter to continue...");
    scanner.nextLine();
}
```
- Pauses program execution
- Displays prompt for user
- Waits for user to press Enter
- Helps control information flow
- Prevents screen from clearing too quickly

## Order Display Methods
```java
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
```
- Displays list of orders
- Handles empty order list
- Formats each order with:
  - Header line
  - Order details (uses Order's toString)
  - Separator between orders
- Example output:
  ```
  ----- All Orders -----
  Order ID: 1
  Customer: John Doe
  Books: Java Book (2)
  ----------------------
  ```

## Message Display Methods
```java
public static void displayError(String message) {
    System.out.println("Error: " + message);
}

public static void displaySuccess(String message) {
    System.out.println("Success: " + message);
}
```
- Two types of status messages:
  1. Error messages (for problems)
  2. Success messages (for confirmations)
- Consistent format:
  - Error: Prefixed with "Error: "
  - Success: Prefixed with "Success: "
- Examples:
  - "Error: Invalid customer name"
  - "Success: Order placed successfully"

## Overall Purpose
The ConsoleUI class:
1. Manages all user interface aspects
2. Provides consistent look and feel
3. Implements clear screen management
4. Shows hierarchical menu system
5. Formats output for readability
6. Handles user interaction pauses
7. Displays formatted orders
8. Shows status messages
9. Uses static methods for easy access
10. Maintains consistent visual style throughout application 