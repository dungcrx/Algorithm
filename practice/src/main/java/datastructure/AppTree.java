package datastructure;

/**
 * Created by phandung on 5/25/17.
 */
public class AppTree {
    public static void main(String[] args) {
         Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(1);
        tree.insert(12);
        tree.insert(4);
        tree.insert(1000);
        tree.insert(-7);
        tree.insert(3);
        tree.insert(5);
        System.out.println(tree.getMax());
        System.out.println(tree.getMin());
        tree.traversal();

        tree.delete(5);
        tree.traversal();

    }
}
