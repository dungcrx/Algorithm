package concurrency;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by phandung on 6/7/17.
 */

class Worker implements Runnable{

    private int id;
    private java.util.concurrent.CyclicBarrier cyclicBarrier;
    private Random random;

    public Worker(int id , java.util.concurrent.CyclicBarrier cyclicBarrier){
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
        this.random = new Random();
    }

    @Override
    public void run(){
        System.out.println(" Thread with id " + id + " Start the task.... ");
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Thread with id " + id + " Finished the task ");


        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println( " errors ::: " +e.getMessage());
        }
        System.out.println(" The Task id = " +this.id + " is wakeup");


    }

}

public class CyclicBarrier  {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(5,() ->{
            System.out.println( "  All Task is Done");
        });

        for(int i = 0 ; i < 5 ;  i++)
            executorService.execute(new Worker(i+1 , barrier));

        executorService.shutdown();
    }


}
