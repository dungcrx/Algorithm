/**
 * Created by phandung on 5/19/17.
 */
public class LinearAndBinarySearch {

    private int[] array;

    public LinearAndBinarySearch(int[] array){
        this.array = array;
    }


    public static void main(String[] args) {
        int[] test = {5,6,10,30,100,200,203,400,900};

        LinearAndBinarySearch linearAndBinarySearch = new LinearAndBinarySearch(test);
        System.out.println(linearAndBinarySearch.searchLinear(test,200));

        System.out.println(linearAndBinarySearch.binarySeach(test,0,test.length-1,200));

    }


    private  int searchLinear(int[] array , int item){
        for(int i = 0 ; i < array.length ; i++)
            if(array[i] == item) return i;
        return -1;
    }

    private  int binarySeach(int[] array ,int begin , int theEnd , int item){

        if(begin > theEnd) return -1;
        int middle =  (begin + theEnd ) / 2;
        if(array[middle] == item) return middle;
        else if(item < array[middle]){
            return binarySeach(array,begin,middle-1,item);
        } else return binarySeach(array,middle+1, theEnd,item);

    }



}
