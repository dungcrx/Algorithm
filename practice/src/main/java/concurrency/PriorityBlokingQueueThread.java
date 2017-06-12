package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by phandung on 6/9/17.
 */
public class PriorityBlokingQueueThread {

    public static void main(String[] args) {
        BlockingQueue<Person> queue = new PriorityBlockingQueue<>();
        new Thread(new FirstPriorityQueue(queue)).start();
        new Thread(new SecondPriorityQueue(queue)).start();
    }
}


class Person implements Comparable<Person>{

    private int age;
    private String name;

    public Person(int age , String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }
    @Override
    public String toString(){
        return  "The Person is : name = "+ this.name + " age = "+this.age;
    }

}


class FirstPriorityQueue implements Runnable{
    private BlockingQueue<Person> blockingQueue;
    public FirstPriorityQueue(BlockingQueue<Person> blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run(){
        try {
            blockingQueue.put(new Person(10,"x"));
            blockingQueue.put(new Person(10,"e"));
            blockingQueue.put(new Person(10,"b"));
            Thread.sleep(10000);
            blockingQueue.put(new Person(10,"a"));
            Thread.sleep(1000);
            blockingQueue.put(new Person(10,"c"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class SecondPriorityQueue implements Runnable{
    private BlockingQueue<Person> blockingQueue;
    public SecondPriorityQueue(BlockingQueue<Person> blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run(){
        try {
            Thread.sleep(1000);
            System.out.println(blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            Thread.sleep(5000);
            System.out.println(blockingQueue.take());
            Thread.sleep(8000);
            System.out.println(blockingQueue.take());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
