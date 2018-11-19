package TestOnline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by dungphan on 8/20/17.
 */
public class Tmon3 {

    public static void main(String[] args) {
        System.out.println( " check gia tri "+countBits(7));
        System.out.println(reverserString("phan"));
        doSort(null);
    }

    public static int countBits(int number){
        int count = 0;
        while(number > 0){
            if(number %2 == 1){
                count = count + 1;
            }
            number = number/2;

        }
        return count;
    }


    public  static  String reverserString(String check){
        char[] cString = check.toCharArray();
        int i = 0;
        int j = cString.length -1;
        while (i < j){
            //swap(cString[i],cString[j]);
            char temp;
            temp = cString[i];
            cString[i]= cString[j];
            cString[j]= temp;
            i++;j--;
        }
        return String.valueOf(cString);
    }

    private static void swap(char c, char c1) {
        char temp;
        temp = c;
        c = c1;
        c1= temp;
    }

    public static void doSort(String[] list1){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        String[] stringArray = list.toArray(new String[0]);
        Collections.sort(list, ( s1,  s2) ->{
            return s1.compareTo(s2);
        });
        list.forEach(s -> System.out.println(s));

        List kk = Arrays.asList(stringArray);
    }
}
