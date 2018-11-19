package TestOnline;

import java.util.*;

/**
 * Created by phandung on 5/29/17.
 */
public class Structure<E> {

    private ArrayList<E> myCon;

    public Structure() {
        myCon = new ArrayList<E>();
    }
    public void add( E obj ) {
        myCon.add( obj );
    }

    public E peek() {
        return myCon.get( myCon.size() - 1 );
    }

    public boolean isEmpty() {
        return myCon.size() == 0;
    }

    public E remove() {
        return myCon.remove(myCon.size() - 1);
    }

    int value = 42;


    ///////// Client Code /////////
    public static void second() {
        Structure<String> s = new Structure<String>();
        s.add( "A" );
        s.add( "B" );
        s.add( "C" );
        while( !s.isEmpty() ) {
            System.out.print( s.remove() );
        }
    }


    public static void main(String[] args) {
        int[] data =  {1 };
        int[] result = sortSearch(data,4);
        for (int i = 0 ; i < result.length ; i ++){
            System.out.println(" CHeck "+result[i]);
        }

    }

    private static Set<Integer> getSetInt(int[] data ){
        Arrays.sort(data);
        Set<Integer> setInt = new TreeSet<>();
        for(int i = 0 ; i < data.length ; i++) {
            setInt.add(data[i]);
        }
        return setInt;
    }

    public static int[] sortSearch(int[] data , int lessthan){
        Set<Integer> setInteget = getSetInt(data);
        List<Integer> result = new ArrayList<>();
        setInteget.forEach(i ->{
            if(i< lessthan){
                result.add(i);
            }
        });
        Collections.reverse(result);
        return result.stream().mapToInt(i->i).toArray();
    }

}

