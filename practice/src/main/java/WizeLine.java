/**
 * Created by phandung on 5/18/17.
 */
public class WizeLine {

    public static void main(String[] args) {

        for (int i = 0 ; i <= 100 ; i ++ ) {
            if(multipleThre(i) && !multipleFive(i)) {
                System.out.println(" Wize");
            } else if (multipleFive(i) && !multipleFiveAndThree(i)){
                System.out.println(" Line");
            } else if( multipleFiveAndThree(i)){
                System.out.println("Wize Line");
            } else {
                System.out.println(" Number is "+i);
            }


        }

    }

    private static boolean multipleThre(int x){
        if (x % 3 == 0) return true;
        return false;
    }
    private static boolean multipleFive(int x){
        if (x % 5 == 0) return true;
        return false;
    }

    private static boolean multipleFiveAndThree(int x){
        if (x % 15 == 0) return true;
        return false;
    }


}
