# Book.java Pseudocode Documentation

## Class Definition
```java
public class Book implements Comparable<Book>
```
- `public`: This keyword means the class can be accessed from anywhere in the program
- `class Book`: Defines a new class named Book that represents a book in our bookstore
- `implements Comparable<Book>`: This means the Book class promises to provide a way to compare one book with another book (using the compareTo method)

## Instance Variables
```java
private String title;
private int quantity;
```
- `private`: These variables can only be accessed within the Book class
- `String title`: Stores the title of the book as text
- `int quantity`: Stores how many copies of the book are available as a whole number

## Constructor
```java
public Book(String title, int quantity) {
    this.title = title;
    this.quantity = quantity;
}
```
- This is a special method that creates a new Book object
- `public`: The constructor can be called from anywhere
- `Book(String title, int quantity)`: Takes two parameters:
  - `title`: The title of the book to be created
  - `quantity`: The number of copies of the book
- `this.title = title`: Stores the provided title in the object's title variable
- `this.quantity = quantity`: Stores the provided quantity in the object's quantity variable

## Getter Methods
```java
public String getTitle() {
    return title;
}

public int getQuantity() {
    return quantity;
}
```
- These methods allow other parts of the program to read (but not modify) the book's title and quantity
- `public`: These methods can be called from anywhere
- `String getTitle()`: Returns the book's title
- `int getQuantity()`: Returns the book's quantity

## toString Method
```java
@Override
public String toString() {
    return title + " (Qty: " + quantity + ")";
}
```
- `@Override`: Indicates we're replacing the default toString method with our own version
- This method converts the Book object into a readable text format
- Returns a string in the format: "Title (Qty: X)" where X is the quantity

## compareTo Method
```java
@Override
public int compareTo(Book other) {
    return this.title.compareTo(other.title);
}
```
- `@Override`: Indicates we're implementing the promised compareTo method from Comparable interface
- This method defines how to compare two Book objects
- Compares books based on their titles alphabetically
- Returns:
  - A negative number if this book's title comes before the other book's title
  - Zero if the titles are the same
  - A positive number if this book's title comes after the other book's title

## Overall Purpose
The Book class is a fundamental building block of our bookstore system that:
1. Stores information about a single book (title and quantity)
2. Provides ways to access this information (getters)
3. Can be displayed in a readable format (toString)
4. Can be compared with other books for sorting (compareTo)
5. Ensures data protection by making variables private and only accessible through methods 