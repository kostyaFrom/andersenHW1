/**
 * The CustomList interface provides seven methods
 * The CustomList interface provides one method to search by index
 * The CustomList interface provides two methods to insert and remove elements at an arbitrary point in the list.
 *  * Type parameters:
 *  * <T> – the type of elements in this list
 */
public interface CustomList<T> {
    T get(int index);

    void set(int index, T elem);

    void add(T elem);

    boolean remove(T elem);

    boolean removeAt(int index);

    int size();

    void clear();
}
