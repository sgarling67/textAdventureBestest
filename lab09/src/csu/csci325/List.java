package csu.csci325;

/**
 * Created by Kaitlyn on 12/1/2016.
 */
public interface List<T> {
    void add(int idx, T object);
    void addFront(T object);
    void addBack(T object);
    // Remove the object in the list.
    void remove(T object); // AKA cross out!
    // Remove an item at a specific location.
    void remove(int idx);
    T get(int idx); // Get based on index
    boolean isEmpty();
    int size();
    int contains(T object);
}
