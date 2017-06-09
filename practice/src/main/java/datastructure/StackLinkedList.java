package datastructure;

/**
 * Created by phandung on 5/22/17.
 */
public class StackLinkedList<T extends Comparable<T>> {

    public static void main(String[] args) {
        StackLinkedList<Integer> myStack = new StackLinkedList<>();

        myStack.push(10);
        myStack.push(1001);
        myStack.push(103);
        myStack.push(104);
        myStack.push(105);
        myStack.push(106);
        System.out.println(myStack.size());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.peek());
        System.out.println(myStack.peek());


    }

    private Node<T> root;
    private int count;

    public void push(T data){
        this.count++;
        if(root == null){
            this.root = new Node<>(data);
        } else {
            Node<T> oldroot = this.root;
            this.root = new Node<>(data);
            this.root.setNextNode(oldroot);

        }

    }

    public int size(){return count;}
    public boolean isEmpty(){return this.root ==null;}

    public T pop(){
        if(root == null){ return null;}
        T data = this.root.getData();
        this.root = this.root.getNextNode();
        this.count --;
        return data;
    }

    public T peek(){
        T data = this.root.getData();
        return data;
    }

}
