package TestOnline;

import java.util.ArrayList;

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
            ArrayList<String> strings = new ArrayList<String>();
            strings.add("Hello, World!");
            strings.add("Welcome to CoderPad.");
            strings.add("This pad is running Java 8.");

            for (String string : strings) {
                System.out.println(string);
            }
    }
}

