# Queue.java Pseudocode Documentation

## Class Definition
```java
public class Queue<T>
```
- `public`: The class can be accessed from anywhere in the program
- `class Queue<T>`: Defines a generic queue class where T is the type of elements it can store
- `<T>`: Type parameter that allows the queue to store any type of object

## Instance Variables
```java
private Object[] elements;
private int head;
private int tail;
private int size;
private static final int INITIAL_CAPACITY = 10;
```
- `private Object[] elements`: Array that stores the queue's elements
- `private int head`: Index pointing to the front element of the queue
- `private int tail`: Index where the next element will be added
- `private int size`: Current number of elements in the queue
- `private static final int INITIAL_CAPACITY`: Fixed starting size of the array (10)

## Constructor
```java
public Queue() {
    elements = new Object[INITIAL_CAPACITY];
    head = 0;
    tail = 0;
    size = 0;
}
```
- Creates a new empty queue
- Initializes the elements array with initial capacity
- Sets head and tail to 0 (empty queue)
- Sets size to 0 (no elements)

## Enqueue Method
```java
public void enqueue(T item) {
    if (size == elements.length) {
        resize();
    }
    elements[tail] = item;
    tail = (tail + 1) % elements.length;
    size++;
}
```
- `public void enqueue(T item)`: Method to add an item to the back of the queue
- Checks if array is full and resizes if needed
- Places new item at tail position
- Updates tail position using modulo to wrap around array
- Increases size counter
- Example: If queue is [1,2,3] and we enqueue(4), it becomes [1,2,3,4]

## Dequeue Method
```java
public T dequeue() {
    if (isEmpty()) {
        throw new RuntimeException("Queue is empty");
    }
    T item = (T) elements[head];
    elements[head] = null;
    head = (head + 1) % elements.length;
    size--;
    return item;
}
```
- Removes and returns the front element of the queue
- Throws exception if queue is empty
- Gets element at head position
- Clears the reference to avoid memory leak
- Updates head position using modulo
- Decreases size counter
- Example: If queue is [1,2,3] and we dequeue(), it returns 1 and queue becomes [2,3]

## Peek Method
```java
public T peek() {
    if (isEmpty()) {
        throw new RuntimeException("Queue is empty");
    }
    return (T) elements[head];
}
```
- Returns the front element without removing it
- Throws exception if queue is empty
- Returns element at head position
- Example: If queue is [1,2,3], peek() returns 1 but queue remains [1,2,3]

## Utility Methods
```java
public boolean isEmpty() {
    return size == 0;
}

public int size() {
    return size;
}
```
- `isEmpty()`: Checks if queue has no elements
- `size()`: Returns number of elements in queue

## Resize Method
```java
private void resize() {
    int newCapacity = elements.length * 2;
    Object[] newElements = new Object[newCapacity];
    for (int i = 0; i < size; i++) {
        newElements[i] = elements[(head + i) % elements.length];
    }
    elements = newElements;
    head = 0;
    tail = size;
}
```
- Private helper method to increase array capacity
- Doubles the array size
- Creates new array with double capacity
- Copies elements from old array to new array, starting from head
- Resets head to 0 and tail to size
- Example: If array is [3,4,1,2] with head=2, after resize it becomes [1,2,3,4,null,null,null,null]

## ToArray Method
```java
public Object[] toArray() {
    Object[] result = new Object[size];
    for (int i = 0; i < size; i++) {
        result[i] = elements[(head + i) % elements.length];
    }
    return result;
}
```
- Converts queue contents to a regular array
- Creates new array of exact size needed
- Copies elements in order starting from head
- Returns array containing all queue elements in order
- Example: If queue is [3,4,1,2] with head=2, toArray() returns [1,2,3,4]

## Overall Purpose
The Queue class implements a circular array-based queue that:
1. Provides First-In-First-Out (FIFO) operations
2. Automatically grows when needed
3. Maintains efficient memory usage
4. Handles edge cases (empty queue, full array)
5. Provides utility methods for checking state
6. Uses circular array implementation to avoid shifting elements 