public class Queue<T> {
    private Object[] elements;
    private int head; // index of the front element
    private int tail; // index for next insertion
    private int size; // current number of elements
    private static final int INITIAL_CAPACITY = 10;

    public Queue() {
        elements = new Object[INITIAL_CAPACITY];
        head = 0;
        tail = 0;
        size = 0;
    }

    public void enqueue(T item) {
        if (size == elements.length) {
            resize();
        }
        elements[tail] = item;
        tail = (tail + 1) % elements.length;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T item = (T) elements[head];
        elements[head] = null; // avoid memory leak
        head = (head + 1) % elements.length;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return (T) elements[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        // Copy elements in proper order starting from head
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(head + i) % elements.length];
        }
        elements = newElements;
        head = 0;
        tail = size;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = elements[(head + i) % elements.length];
        }
        return result;
    }
} 