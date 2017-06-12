package concurrency;

/**
 * Created by phandung on 5/31/17.
 */
public class WaitAndNotify {

    private void produce() throws InterruptedException {

        synchronized(this){
            System.out.println(" Produce Thread is running ");
            wait(100);
            System.out.println(" Produce re-run again ");
        }
    }

    private void consume() throws InterruptedException{
        synchronized(this){
            Thread.sleep(2000);
            System.out.println(" Starting Consume method ");

            notifyAll();
            Thread.sleep(2000);
            System.out.println(" Consume After Notify");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify waitAndNotify = new WaitAndNotify();
        Thread t1 = new Thread( () ->{
            try {
                waitAndNotify.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                waitAndNotify.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }




}
