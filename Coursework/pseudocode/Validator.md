# Validator.java Pseudocode Documentation

## Class Definition
```java
public class Validator
```
- `public`: The class can be accessed from anywhere in the program
- `class Validator`: A utility class that provides methods to validate different types of input

## Customer Name Validation
```java
public static boolean isValidCustomerName(String name) {
    if (name == null || name.trim().isEmpty()) return false;
    for (int i = 0; i < name.length(); i++) {
        char c = name.charAt(i);
        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
            return false;
        }
    }
    return true;
}
```
- `public static`: Method can be called without creating a Validator object
- `boolean`: Returns true if valid, false if invalid
- `isValidCustomerName(String name)`: Takes a name to validate
- Validation rules:
  - Cannot be null
  - Cannot be empty or just whitespace
  - Can only contain letters and spaces
  - No numbers or special characters allowed
- Examples:
  - "John Doe" → valid
  - "John123" → invalid
  - "" → invalid
  - "John@Doe" → invalid

## Book Title Validation
```java
public static boolean isValidBookTitle(String title) {
    if (title == null || title.trim().isEmpty()) return false;
    return true;
}
```
- `public static`: Method can be called without creating a Validator object
- `boolean`: Returns true if valid, false if invalid
- `isValidBookTitle(String title)`: Takes a title to validate
- Validation rules:
  - Cannot be null
  - Cannot be empty or just whitespace
  - All other characters are allowed
- Examples:
  - "Java Programming 101" → valid
  - "The Lord of the Rings: Part 1" → valid
  - "" → invalid
  - "   " → invalid

## Shipping Address Validation
```java
public static boolean isValidShippingAddress(String address) {
    if (address == null || address.trim().isEmpty()) return false;
    for (int i = 0; i < address.length(); i++) {
        char c = address.charAt(i);
        if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
            return false;
        }
    }
    return true;
}
```
- `public static`: Method can be called without creating a Validator object
- `boolean`: Returns true if valid, false if invalid
- `isValidShippingAddress(String address)`: Takes an address to validate
- Validation rules:
  - Cannot be null
  - Cannot be empty or just whitespace
  - Can contain letters, numbers, and spaces
  - No special characters allowed
- Examples:
  - "123 Main Street" → valid
  - "Apartment 4B 567 Oak Road" → valid
  - "123@Main St." → invalid
  - "" → invalid

## Overall Purpose
The Validator class is a utility class that:
1. Provides input validation for the bookstore system
2. Ensures data integrity before processing
3. Implements specific validation rules for:
   - Customer names (letters and spaces only)
   - Book titles (non-empty only)
   - Shipping addresses (alphanumeric and spaces)
4. Uses static methods for easy access
5. Returns boolean results for simple validation checks
6. Helps prevent invalid data from entering the system
7. Maintains consistent validation rules across the application 