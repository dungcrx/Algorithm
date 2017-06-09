package datastructure;

/**
 * Created by phandung on 5/22/17.
 */
public class Node<T extends Comparable> {
    private T data;
    private Node<T> nextNode;

    public Node(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node setData(T data) {
        this.data = data;
        return this;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public Node setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
        return this;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", nextNode=" + nextNode +
                '}';
    }
}
