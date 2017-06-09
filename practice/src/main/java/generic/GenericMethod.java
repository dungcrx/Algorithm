package generic;

/**
 * Created by phandung on 5/29/17.
 */
public class GenericMethod {

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5};
        String[] sArray = {"A","B","C"};
        showArray(array);
        showArray(sArray);
    }

    public static <T> void showArray(T[] t){
        for(T item : t){
            showItem(item);
            System.out.println(" show inside loops "+item);
        }
    }

    public static <T> T showItem(T t){
        System.out.println("The item is : " +t);
        return t;
    }
}
