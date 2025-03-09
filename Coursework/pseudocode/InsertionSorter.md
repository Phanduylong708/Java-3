# InsertionSorter.java Pseudocode Documentation

## Class Definition
```java
public class InsertionSorter
```
- `public`: The class can be accessed from anywhere in the program
- `class InsertionSorter`: A utility class that implements the insertion sort algorithm

## Sort Method
```java
public static <T extends Comparable<T>> void sort(T[] arr)
```
- Method Declaration Breakdown:
  - `public static`: Method can be called without creating an InsertionSorter object
  - `<T extends Comparable<T>>`: Generic type T must implement Comparable interface
  - `void`: Method doesn't return anything
  - `sort(T[] arr)`: Takes an array of type T as parameter

```java
if (arr == null || arr.length < 2) return;
```
- Early return conditions:
  - If array is null (doesn't exist)
  - If array has 0 or 1 elements (already sorted)
- Optimization to avoid unnecessary processing

```java
for (int i = 1; i < arr.length; i++) {
```
- Main loop starts from second element (index 1)
- Continues until end of array
- `i` represents the current element being sorted

```java
    T key = arr[i];
```
- Stores current element in temporary variable
- This is the element we want to insert in correct position
- Example: If array is [3,1,4] and i=1, key=1

```java
    int j = i - 1;
```
- `j` points to element before current element
- Will be used to find insertion point
- Example: If i=1, j=0 (points to first element)

```java
    while (j >= 0 && arr[j].compareTo(key) > 0) {
```
- Continue while:
  - Not at start of array (j >= 0)
  - Current element (arr[j]) is greater than key
- Uses compareTo method to compare elements
- Example: If arr[0]=3 and key=1, 3.compareTo(1) > 0 is true

```java
        arr[j + 1] = arr[j];
        j--;
```
- Shifts larger element one position ahead
- Moves j backwards to check next element
- Creates space for inserting key
- Example: [3,1,4] becomes [3,3,4] temporarily

```java
    arr[j + 1] = key;
```
- Inserts key in its correct position
- j + 1 is the insertion point after shifting
- Example: [3,3,4] becomes [1,3,4]

## Complete Example
Starting with array: [5, 2, 8, 1, 9]

1. First Pass (i=1):
   - key = 2
   - Compares with 5
   - Shifts 5 right
   - Inserts 2: [2, 5, 8, 1, 9]

2. Second Pass (i=2):
   - key = 8
   - 8 > 5, no shifts needed
   - Array unchanged: [2, 5, 8, 1, 9]

3. Third Pass (i=3):
   - key = 1
   - Shifts 8, 5, 2 right
   - Inserts 1: [1, 2, 5, 8, 9]

4. Fourth Pass (i=4):
   - key = 9
   - 9 > 8, no shifts needed
   - Final array: [1, 2, 5, 8, 9]

## Overall Purpose
The InsertionSorter class:
1. Implements generic insertion sort algorithm
2. Works with any type that implements Comparable
3. Sorts array in ascending order
4. Modifies array in place (no extra array needed)
5. Handles edge cases (null, small arrays)
6. Provides stable sorting (maintains relative order of equal elements)
7. Efficient for small arrays and nearly sorted arrays
8. Time Complexity:
   - Best Case: O(n) when array is already sorted
   - Average Case: O(n²)
   - Worst Case: O(n²) when array is reverse sorted 