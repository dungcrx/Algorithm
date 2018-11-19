package algorithms;

import java.util.Random;

/**
 * Created by dungphan on 6/22/17.
 */
public class MergeSort {

    private static int[] temparary;
    private static int[] input;

    public static void main(String[] args) {
        int[] array = new int[30];
        for(int i = 0 ; i < array.length ; i++)
            array[i] = new Random().nextInt(1000) - 500;
        input = array;
        temparary = new int[array.length];
        mergeSort(0,input.length -1);
        showItem(input);
    }







    private static void mergeSort(int low , int high){
        if(low >= high) return;
        int middle = (low + high)/2;
        mergeSort(low,middle);
        mergeSort(middle+1,high);
        merge(low,middle,high);
    }

    private static void merge(int low, int middle, int high) {
        // copy input[i] to tem[i]
        for(int i = low ; i <= high ; i++){
            temparary[i] = input[i] ;
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        // get smallest from either Left or right put to temporary array
        while((i <= middle) && (j <= high)){
            if(temparary[i] < temparary[j]){
                input[k] = temparary[i];
                i++;
            } else {
                input[k] = temparary[j];
                j++;
            }
            k++;
        }
        // copy on the left
        while(i <= middle){
            input[k] = temparary[i];
            i++;
            k++;
        }
        // copy on the right
        while(j<= high){
            input[k] = temparary[j];
            j++;
            k++;
        }
    }


    private static void showItem(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(+input[i] +" ==>  ");
        }

    }

    public static int[] getInput() {
        return input;
    }

    public static void setInput(int[] input) {
        MergeSort.input = input;
    }

    public static int[] getTemparary() {
        return temparary;
    }

    public static void setTemparary(int[] temparary) {
        MergeSort.temparary = temparary;
    }
}
