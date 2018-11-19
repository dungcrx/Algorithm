package algorithms;


import java.util.Random;

/**
 * Created by dungphan on 6/24/17.
 */
public class SumParaller {

    private Worker[] workers;
    private int numberOfThread;

    public SumParaller(int numberOfThread){
        this.numberOfThread = numberOfThread;
        this.workers = new Worker[numberOfThread];
    }



    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[100000000];
        for(int i = 0; i< nums.length;i++)
            nums[i] =  random.nextInt(100);
        int threadAvailable = Runtime.getRuntime().availableProcessors();
        System.out.println(" Thread available "+threadAvailable);
        long start = System.currentTimeMillis();
        SumParaller sumParaller = new SumParaller(threadAvailable);
        System.out.println(sumParaller.sum(nums));

        System.out.println(" Finish execute time "+(System.currentTimeMillis() - start));





    }

    private  int sum(int[] nums){

        int divide = (int)Math.ceil(nums.length * 1.0 / numberOfThread);
        for(int i = 0 ; i < numberOfThread; i++) {
            workers[i] = new Worker(nums, i * divide, (i + 1) * divide);
            workers[i].start();
        }

        try {
            for (Worker worker : workers)
                worker.join();
        } catch (InterruptedException in){

        }
        int sum = 0;
        for (Worker worker : workers)
            sum = sum + worker.getSumPartial();
        return sum;
    }




    private class Worker extends Thread {
        private int[] nums;
        private int low;
        private int high;
        private int sumPartial;

        public Worker(int[] nums , int low , int high){
            this.low = low;
            this.nums = nums;
            this.high = high;
        }

        @Override
        public void run(){
            for (int i= low ; i< high ; i++)
                sumPartial = sumPartial + nums[i];
        }

        public int[] getNums() {
            return nums;
        }

        public void setNums(int[] nums) {
            this.nums = nums;
        }

        public int getLow() {
            return low;
        }

        public void setLow(int low) {
            this.low = low;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }

        public int getSumPartial() {
            return sumPartial;
        }

        public Worker setSumPartial(int sumPartial) {
            this.sumPartial = sumPartial;
            return this;
        }
    }



}
