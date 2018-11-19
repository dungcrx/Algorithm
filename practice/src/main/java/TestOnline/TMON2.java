package TestOnline;

/**
 * Created by dungphan on 8/20/17.
 */
public class TMON2 {

    public static void main(String[] args) {
        int priceCount = 4000;
        int[] priceArray = new int[priceCount];
        for (int priceArrayIdx = 1; priceArrayIdx < priceCount; priceArrayIdx++) {
            priceArray[priceArrayIdx-1] = priceArrayIdx * 1000;
        }
        System.out.println("array index of price:" + getSearchPriceArrayIntex(priceArray, 691000));

    }
    public static int getSearchPriceArrayIntex(int[] priceArray, int searchPrice) {

        return getSearch(0,priceArray.length-1, priceArray, searchPrice);

    }
    private static int getSearch(int start, int end, int[] priceArray, int searchPrice){
        if(start == end ) return -1;
        int pivot = (end -start)/2 + start;
        if(priceArray[pivot] == searchPrice) return pivot;

        else if(priceArray[pivot] <  searchPrice){
            return getSearch( pivot + 1,  end, priceArray,  searchPrice);
        } else return getSearch(start,  pivot, priceArray,  searchPrice);
    }
}
