package TestOnline.pyco;

/**
 * Created by dungphan on 9/3/17.
 */
public class Test {

    public static void main(String[] args) {
        int a = 1;
        double b = 2.0;
        float c = 30;
        long d = 40;
        double xxx = (a + d) * (c + b);
        System.out.println(xxx);

    }

    public void test(){

    }

    public synchronized void methodA(int i, String msg){
        System.out.println(Integer.toString(i));
        System.out.println(msg);
    }
    public void methodB(int i, String msg){
        synchronized(this){
            System.out.println(Integer.toString(i));
            System.out.println(msg);
        }
    }
}
