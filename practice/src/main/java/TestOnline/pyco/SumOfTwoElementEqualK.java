package TestOnline.pyco;

import java.util.HashMap;
import java.util.*;

/**
 * Created by dungphan on 9/2/17.
 */
public class SumOfTwoElementEqualK {

    public static void main(String[] args) {
     //   numberOfPairs(new int[]{1,2, 3,3,4,12,3,12, 14, 17, 15, 19, 20, -11}, 9);

        System.out.println( numberOfPairs( new int[]{1, 3, 46, 1, 3, 9},47));
        System.out.println( numberOfPairs( new int[]{6, 6, 3, 9, 3, 5, 1},12));

    }


    public static int numberOfPairs(int[] arrays, long k) {
        if(arrays.length < 2) return 0;
        Arrays.sort(arrays);
        int left = 0 ; int right = arrays.length - 1;
        int count = 0;
        Map<Integer , Integer > map = new HashMap<>();

        while(left < right){
            if(arrays[left] + arrays[right] == k){
                if(!map.containsKey(arrays[left]) && !map.containsKey(arrays[right])){
                    map.put(arrays[left],left);
                    map.put(arrays[right],right);
                    count = count + 1;
                    left++;
                    right --;
                } else {
                    left++;
                    right --;
                }

            } else if(arrays[left] + arrays[right] < k) {
                left++;
            } else {
                right--;
            }

        }
        return count;
    }
}
