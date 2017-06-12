package concurrency;

/**
 * Created by phandung on 5/30/17.
 */
public class Join {

    public static void main(String[] args){
        Runner1 run1 = new Runner1();
        Runner2 run2 = new Runner2();

        run1.start();
        run2.start();


        try {
            run1.join();
         //   run2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" Main thread is Running ");

    }



}

class Runner1 extends Thread{

    @Override
    public void run() {
        for(int i = 0 ; i < 10 ; i ++){
            System.out.println(" RUNNER 1 is running " +i);
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Runner2 extends Thread{

    @Override
    public void run(){

        for (int i = 0 ; i < 1000 ; i++){
            System.out.println(" RUNNER 2 IS running "+i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
