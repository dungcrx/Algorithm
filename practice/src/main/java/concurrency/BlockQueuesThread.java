package concurrency;

import java.util.concurrent.*;

/**
 * Created by phandung on 6/9/17.
 */



/*
* Put is put object to queue
* take is get out object from queue
* */

public class BlockQueuesThread {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(20);
        FirstWorker firstWorker = new FirstWorker(blockingQueue);
        SercondWorker sercondWorker = new SercondWorker(blockingQueue);
        new Thread(firstWorker).start();
        new Thread(sercondWorker).start();


    }

}


class FirstWorker implements Runnable{

    private BlockingQueue<Integer> blockingQueue;

    public FirstWorker(BlockingQueue<Integer> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run(){
        int count = 1;
        while(true){
            try {
                /*
                *  if  BlokingQueue is full it will wait  ( this case define is 20)
                *  after size is not full it will put immediately .
                *
                * */
                blockingQueue.put(count);
                System.out.println(" PUTTING item id = "+count);
                count++;
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

class SercondWorker implements Runnable{

    private BlockingQueue<Integer> blockingQueue;

    public SercondWorker(BlockingQueue<Integer> blockingQUeue){

        this.blockingQueue = blockingQUeue;
    }
    @Override
    public void run(){
        while(true){
            try {
                /*
                *  This Thread will wait when queue is empty
                *  it will turn back to take item immediately
                * */
                int count = blockingQueue.take();
                System.out.println(" TAKING the id = "+count);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


}