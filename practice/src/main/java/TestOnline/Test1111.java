package TestOnline;

import java.util.Comparator;

/**
 * Created by dungphan on 8/24/17.
 */
public class Test1111 {

    public static void main(String[] args) {
        String[] a = {"ad","dsf"};
        MySort ms = new MySort();
    }

    static class MySort implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }
}
