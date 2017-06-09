package datastructure;

/**
 * Created by phandung on 5/23/17.
 */
public class TreeNode<T> {
    private T data;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public TreeNode setData(T data) {
        this.data = data;
        return this;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public TreeNode setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
        return this;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public TreeNode setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
        return this;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
