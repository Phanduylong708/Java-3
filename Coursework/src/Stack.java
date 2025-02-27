public class Stack<T> {
    private Object[] elements;
    private int top;
    private static final int INITIAL_CAPACITY = 10;

    public Stack() {
        elements = new Object[INITIAL_CAPACITY];
        top = 0;
    }
    
    public void push(T item) {
        if (top == elements.length) {
            resize();
        }
        elements[top++] = item;
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T item = (T) elements[--top];
        elements[top] = null; // Avoid memory leak
        return item;
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return (T) elements[top - 1];
    }
    
    public boolean isEmpty() {
        return top == 0;
    }
    
    public int size() {
        return top;
    }
    
    private void resize() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
}
