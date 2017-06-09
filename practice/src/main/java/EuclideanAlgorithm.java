/**
 * Created by phandung on 5/19/17.
 */
public class EuclideanAlgorithm {

    public static void main(String[] args) {
        System.out.println(getIterative(6,2));

        System.out.println(getRecursive(6,2));

        System.out.println(sumRecursive(10));
        System.out.println(sumInterative(10));
    }

    private static int getIterative(int num1 , int num2){
        while(num2 != 0){
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    private static int getRecursive( int num1 , int num2){
        if(num2 == 0) return num1;
        return getRecursive(num2,num1 % num2);

    }

    private static int sumInterative(int n){
        int sum = 0;
        for(int i = 0 ; i<=n ; i ++){
            sum = sum + i;
        }
        return sum;
    }

    private static int sumRecursive(int n){
        if(n == 0 ) return 0;
        return n + sumRecursive(n-1);
    }

}
