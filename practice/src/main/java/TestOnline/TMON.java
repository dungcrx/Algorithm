package TestOnline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by dungphan on 8/20/17.
 */
public class TMON {


    public static List<Stack<Integer>> doFinction() {
        final List<Integer> elements = Arrays.asList(9, 7, 6, 6, 4, 3, 4, 5, 3, 4, 3, 4, 1, 2);
        Stack<Integer> stack = new Stack<>();
        List<Stack<Integer>> result = new ArrayList<>();
        int sum = 0;
        for(Integer integer : elements){
            int temp = sum + integer;
            if(temp >= 20){
                result.add(stack);
                sum = integer;
                stack = new Stack<>();
                stack.add(integer);
            } else {
                stack.add(integer);
                sum = sum + integer;
            }
        }
        result.add(stack);
        return result;
    }

    public static void main(String[] args) {
        List<Stack<Integer>> result = doFinction();
        result.forEach(stack ->{
            System.out.println(stack.toString());
            stack.forEach(integer -> System.out.println(" number == "+integer));
        });
    }
}
