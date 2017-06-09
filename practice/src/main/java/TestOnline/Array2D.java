package TestOnline;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by phandung on 6/6/17.
 */
public class Array2D {

   static int array2D[][] = {
            {0,1,1,0,1,1},
            {1,0,1,1,0,1},
            {1,1,1,1,1,1},
            {1,1,1,1,0,1},
            {1,1,1,1,1,0}
    };

    public static void main(String[] args) {


        Map<Character,String> hashMap = new HashMap<>();

        hashMap.put('a',"a");
        hashMap.put('b',"b");
        hashMap.put('c',"c");
        hashMap.put('d',"d");

        Set keys = hashMap.keySet();

        for(Map.Entry<Character, String>  entry : hashMap.entrySet())

        for(Object c : keys){
            if(c instanceof Character){

                System.out.println(c);
            }
        }


        System.out.println(array2D.length);

        for(int i = 0 ; i < array2D.length ; i ++){
           for (int j = 0 ; j < array2D[0].length; j++){
            //   System.out.println(" I = "+i + " j= "+j);
               System.out.println(array2D[i][j]);
           }
        }
    }



}
