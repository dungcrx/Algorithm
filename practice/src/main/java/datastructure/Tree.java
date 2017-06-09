package datastructure;

/**
 * Created by phandung on 5/23/17.
 */
public interface Tree<T> {
    void insert(T data);
    void delete(T data);
    void traversal();
     T getMax();
     T getMin();
}
