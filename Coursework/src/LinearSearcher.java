public class LinearSearcher {
    /**
     * Searches for a key in the array using linear search algorithm.
     * @param arr the array to search in
     * @param key the element to search for
     * @param <T> the type of elements
     * @return the index of the key if found; otherwise, -1
     */
    public static <T> int search(T[] arr, T key) {
        if (arr == null) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
} 