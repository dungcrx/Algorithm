package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phandung on 5/29/17.
 */
public class BoundedParameter {
    public static void main(String[] args) {
        System.out.println(showItem(100,99));
        List<Bucket<String>> result  = addData("dungphan",new ArrayList<Bucket<String>>());

        for (Bucket<String> bucket : result){
            System.out.println(" bucket is :: " + bucket.getItem());
        }

        List result2 = BoundedParameter.<Integer>addData(104,new ArrayList<>());
        for(Object aa : result2){
            System.out.println( " check my result is :: " +((Bucket<Integer>)aa).getItem());
        }

    }

    public static <T extends Comparable<T>>  T showItem(T t1, T t2){
       if(t1.compareTo(t2) > 0) return t1;
        return t2;
    }


    public static <T> List<Bucket<T>> addData(T t , List<Bucket<T>> list){
        Bucket<T> item = new Bucket<>(t);
        list.add(item);
        return list;
    }

}

class Bucket<T>{
        private T item;
        Bucket(T item){
            this.item = item;
        }
        public T getItem(){
            return this.item;
        }
        public void setItem(T item){
            this.item = item;
        }

}