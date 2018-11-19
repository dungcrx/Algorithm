package TestOnline.pyco;

import java.util.*;

/**
 * Created by dungphan on 9/3/17.
 */
public class Question4 {
    public static void main(String[] args) {
        Integer array[] = new Integer[]{1, 2, 9, 1, 2, 3, 1, 4,1, 5, 7};
        Set<Integer> set = new HashSet<>(Arrays.asList(array));
        List<Integer> list = new ArrayList<>(set);
        list.forEach(item -> System.out.println(item)); // --> A

        // Question 3
        /*
            * SELECT e.Name as NAME ,
            *    Case When s.SalePrice = 0 then NULL ELSE   s.SalePrice  END as MONEY
            *
            *
            * FROM EMPLOYEES as e INNER JOIN SALES as s ON e.EmployeeId = s.EmployeeId;
            *
            * */


        // QUESTION 5

        /*
        *
        * Checked exception is required to be handled at compile time.
        * */
        // QUESTION 7 is double

        // QUESTION 8 is null

        // QUESTION 6 # methodB is more efficient than methodA


    }
}
