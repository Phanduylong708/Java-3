# Stack.java Pseudocode Documentation

## Class Definition
```java
public class Stack<T>
```
- `public`: The class can be accessed from anywhere in the program
- `class Stack<T>`: Defines a generic stack class where T is the type of elements it can store
- `<T>`: Type parameter that allows the stack to store any type of object

## Instance Variables
```java
private Object[] elements;
private int top;
private static final int INITIAL_CAPACITY = 10;
```
- `private Object[] elements`: Array that stores the stack's elements
- `private int top`: Index pointing to the position where next element will be pushed (also represents size)
- `private static final int INITIAL_CAPACITY`: Fixed starting size of the array (10)

## Constructor
```java
public Stack() {
    elements = new Object[INITIAL_CAPACITY];
    top = 0;
}
```
- Creates a new empty stack
- Initializes the elements array with initial capacity
- Sets top to 0 (empty stack)

## Push Method
```java
public void push(T item) {
    if (top == elements.length) {
        resize();
    }
    elements[top++] = item;
}
```
- `public void push(T item)`: Method to add an item to the top of the stack
- Checks if array is full and resizes if needed
- Places new item at top position and increments top
- `top++`: Uses post-increment, so item is placed at current top, then top is increased
- Example: If stack is [1,2,3] and we push(4), it becomes [1,2,3,4]

## Pop Method
```java
public T pop() {
    if (isEmpty()) {
        throw new RuntimeException("Stack is empty");
    }
    T item = (T) elements[--top];
    elements[top] = null;
    return item;
}
```
- Removes and returns the top element of the stack
- Throws exception if stack is empty
- `--top`: Uses pre-decrement to decrease top first, then access element
- Clears the reference to avoid memory leak
- Returns the removed element
- Example: If stack is [1,2,3] and we pop(), it returns 3 and stack becomes [1,2]

## Peek Method
```java
public T peek() {
    if (isEmpty()) {
        throw new RuntimeException("Stack is empty");
    }
    return (T) elements[top - 1];
}
```
- Returns the top element without removing it
- Throws exception if stack is empty
- Returns element at (top - 1) position
- Example: If stack is [1,2,3], peek() returns 3 but stack remains [1,2,3]

## Utility Methods
```java
public boolean isEmpty() {
    return top == 0;
}

public int size() {
    return top;
}
```
- `isEmpty()`: Checks if stack has no elements (top is 0)
- `size()`: Returns number of elements in stack (same as top)

## Resize Method
```java
private void resize() {
    int newCapacity = elements.length * 2;
    Object[] newElements = new Object[newCapacity];
    for (int i = 0; i < elements.length; i++) {
        newElements[i] = elements[i];
    }
    elements = newElements;
}
```
- Private helper method to increase array capacity
- Doubles the array size
- Creates new array with double capacity
- Copies all elements from old array to new array
- Replaces old array with new array
- Example: If array is [1,2,3,4] (capacity 4), after resize it becomes [1,2,3,4,null,null,null,null] (capacity 8)

## Overall Purpose
The Stack class implements an array-based stack that:
1. Provides Last-In-First-Out (LIFO) operations
2. Automatically grows when needed
3. Maintains efficient memory usage
4. Handles edge cases (empty stack, full array)
5. Provides utility methods for checking state
6. Uses a simple top pointer for tracking size and next insertion position 