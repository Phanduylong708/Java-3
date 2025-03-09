# LinearSearcher.java Pseudocode Documentation

## Class Definition
```java
public class LinearSearcher
```
- `public`: The class can be accessed from anywhere in the program
- `class LinearSearcher`: A utility class that implements the linear search algorithm

## Search Method
```java
public static <T> int search(T[] arr, T key)
```
- Method Declaration Breakdown:
  - `public static`: Method can be called without creating a LinearSearcher object
  - `<T>`: Generic type parameter (can search for any type)
  - `int`: Returns the index where key is found (-1 if not found)
  - `search(T[] arr, T key)`: Takes array and search key as parameters

```java
if (arr == null) {
    return -1;
}
```
- Null check for input array
- Returns -1 if array doesn't exist
- Safety check to prevent null pointer exceptions

```java
for (int i = 0; i < arr.length; i++) {
```
- Main loop that searches through array
- Starts from first element (index 0)
- Continues until end of array
- `i` represents current position being checked

```java
    if (arr[i].equals(key)) {
```
- Compares current element with search key
- Uses equals method for comparison
- Works with any object type that implements equals
- Example: If searching for "apple" in ["banana", "apple", "orange"], checks each string

```java
        return i;
```
- Returns current index if match is found
- Search ends successfully
- Example: If key found at position 2, returns 2

```java
return -1;
```
- Returns -1 if key not found after checking all elements
- Indicates unsuccessful search
- Example: If searching for "grape" in ["banana", "apple", "orange"], returns -1

## Complete Example
Array: ["book1", "book2", "book3", "book4"]
Search for "book3":

1. Check arr[0]: "book1" ≠ "book3", continue
2. Check arr[1]: "book2" ≠ "book3", continue
3. Check arr[2]: "book3" = "book3", return 2
4. Search successful!

Search for "book5":
1. Check arr[0]: "book1" ≠ "book5", continue
2. Check arr[1]: "book2" ≠ "book5", continue
3. Check arr[2]: "book3" ≠ "book5", continue
4. Check arr[3]: "book4" ≠ "book5", continue
5. Reached end of array, return -1
6. Search unsuccessful!

## Overall Purpose
The LinearSearcher class:
1. Implements generic linear search algorithm
2. Works with any type that implements equals method
3. Searches array sequentially from start to end
4. Returns index of first matching element
5. Returns -1 if element not found
6. Handles null array input safely
7. Simple but reliable search method
8. Time Complexity:
   - Best Case: O(1) when element is at start
   - Average Case: O(n)
   - Worst Case: O(n) when element is at end or not found
9. Used in the system for:
   - Finding orders by ID
   - Searching through small datasets
   - When data is not sorted 