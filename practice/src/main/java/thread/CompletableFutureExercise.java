package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by dungphan on 2/24/18.
 */
public class CompletableFutureExercise {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("thread 1 .");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 65.0;
        });


        CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("thread 2 .");
                TimeUnit.SECONDS.sleep(1);
                throw new IllegalStateException();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }

        });

        CompletableFuture<Double> combinedFuture = weightInKgFuture
                .thenCombine(heightInCmFuture, (weightInKg, heightInCm) -> {
                    Double heightInMeter = heightInCm/100;
                    return weightInKg/(heightInMeter*heightInMeter);
                }).handle((res,ex) ->{
                    if(ex != null){
                        System.out.println("My exception "+ex.getMessage());
                        Double result3 = 100d;
                        return result3;
                      //  throw new IllegalStateException(ex);
                    }
                    return res;
                });
        System.out.println("Your BMI is - " + combinedFuture.get());


        CompletableFuture<Double> thread1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("thread 3 .");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return new Double(65.0);
        });

        CompletableFuture<Double> thread2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("thread 3 .");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return new Double(65.0);
        });
        thread1.whenComplete((result,ex)->{
            if(ex == null) {
                System.out.println("phan tien dung check ");
            }
            try {
                System.out.println(" My value "+thread2.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        } );
        System.out.println("Phan dung Thread "+thread1.get());
    }
}
