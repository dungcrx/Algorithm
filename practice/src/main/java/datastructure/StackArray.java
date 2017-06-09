package datastructure;

/**
 * Created by phandung on 5/22/17.
 */
public class StackArray<T> {
    private T[] stack;
    private int numberOfItem;

    public StackArray(){
        this.stack = (T[]) new Object[1];
    }

    public static void main(String[] args) {
        StackArray stackArray = new StackArray<>();
        stackArray.push(10);
        stackArray.push(20);
        stackArray.push(30);
        System.out.println(stackArray.pop());
        System.out.println(stackArray.size());
        System.out.println(stackArray.isEmpty());
    }
    public void push(T data){
        if(numberOfItem == this.stack.length){
            reSize(2*this.stack.length);
        }
        this.stack[numberOfItem++] = data;
    }

    public T pop(){
        T data = this.stack[--numberOfItem];
        if(numberOfItem  > 0 && (numberOfItem == this.stack.length/4)){
            reSize(this.stack.length/2);
        }
        return data;
    }

    private void reSize(int capacity){
        T[] coppy = (T[]) new Object[capacity];
        for(int i = 0 ; i < numberOfItem ; i ++){
            coppy[i] = this.stack[i];
        }
        this.stack = coppy;
    }

    public int size(){
        return this.numberOfItem;
    }

    public boolean isEmpty(){
        return numberOfItem ==0;
    }

}
