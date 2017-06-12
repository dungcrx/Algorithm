package concurrency;

/**
 * Created by phandung on 5/30/17.
 */
public class Volatile implements Runnable {

    private  boolean  isTerminated = false;


    @Override
    public void run(){
        while(!isTerminated){
            System.out.println(" Hello from Volatile class ");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Volatile volatile1 = new Volatile();
        Thread t1 = new Thread(volatile1);
        t1.start();
        Thread.sleep(3000);
        volatile1.setTerminated(true);
        System.out.println(" Finished ");
    }


    public boolean getTerminated(){
        return this.isTerminated;
    }

    public void setTerminated(boolean isTerminated){
        this.isTerminated = isTerminated;
    }


}
