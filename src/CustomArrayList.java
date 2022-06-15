import java.util.Arrays;

/**
 * Resizable-array implementation of the CustomList interface.
 * Implements all optional list operations.
 * In addition to implementing the CustomList interface, this class provides methods to manipulate the size of the array that is used internally to store the list.
 * The size, get, set, operations run in constant time. The add operation runs in amortized constant time, that is, adding n elements requires O(n) time. All of the other operations run in linear time (roughly speaking). The constant factor is low compared to that for the LinkedList implementation.
 * Type parameters:
 * <T> – the type of elements in this list
 */
public class CustomArrayList<T> implements CustomList<T> {

    private T[] array;
    private int size = 0;

    public CustomArrayList() {
        this.array = (T[]) new Object[10];
    }

    public CustomArrayList(int arraySize) {
        if (arraySize < 0) {
            throw new IllegalArgumentException();
        }
        this.array = (T[]) new Object[arraySize];
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void set(int index, T elem) {
        checkIndex(index);
        array[index]= elem;
    }

    @Override
    public void add(T elem) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = elem;
        size++;
    }

    @Override
    public boolean remove(T elem) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(elem)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
            array[i + 1] = null;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.array = (T[]) new Object[10];
        this.size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}
