package algorithms;

import java.util.Random;

/**
 * Created by dungphan on 6/24/17.
 */
public class SumSequential {

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[100000000];
        for(int i = 0; i< nums.length;i++)
            nums[i] =  random.nextInt(100);
        long sart = System.currentTimeMillis();
        System.out.println(sumSequential(nums));
        long end = System.currentTimeMillis();
        System.out.println(" Time for running is "+(end - sart));

    }

    private static int sumSequential(int[] nums){
        int total = 0;
        for(int i = 0 ; i < nums.length ; i++){
            total = total + nums[i];
        }
        return  total;
    }

}
