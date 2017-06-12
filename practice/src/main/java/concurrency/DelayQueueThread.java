package concurrency;

import java.util.concurrent.*;

/**
 * Created by phandung on 6/9/17.
 */
public class DelayQueueThread {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<DelayQueueWorker> queue = new DelayQueue<>();
        try {
            queue.put(new DelayQueueWorker(1000," this is first message "));
            queue.put(new DelayQueueWorker(10000," this is second message "));
            queue.put(new DelayQueueWorker(4000," this is Third message "));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(!queue.isEmpty()){
            System.out.println( queue.take());
        }

    }

}

class DelayQueueWorker implements Delayed{
    private long duration;
    private String message;

    public DelayQueueWorker(long duration , String message){
        this.duration = System.currentTimeMillis() + duration;
        this.message = message;
    }
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed otherDelay) {
        if(this.getDuration() < ((DelayQueueWorker) otherDelay).getDuration()){
            return -1;
        }
        if(this.getDuration() > ((DelayQueueWorker) otherDelay).getDuration()){
            return 1;
        }
        return 0;
    }
    public long getDuration() {
        return duration;
    }

    public DelayQueueWorker setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public DelayQueueWorker setMessage(String message) {
        this.message = message;
        return this;
    }


    @Override
    public String toString(){
        return "The Queue "+ this.getMessage();
    }
}
