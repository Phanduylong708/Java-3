public class InsertionSorter {
    /**
     * Sorts the array in place using the insertion sort algorithm.
     * @param arr the array to be sorted
     * @param <T> the type of elements, which must be Comparable
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
} 