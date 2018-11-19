package TestOnline.pyco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by dungphan on 8/31/17.
 */
public class BaracesBalance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfList = scanner.nextInt();
        if(numberOfList <=0 || numberOfList > 15) {
            System.out.println("Please input number from 0 to 15");
            numberOfList = scanner.nextInt();
        }

        List<String> inpupts = new ArrayList<>();
        scanner.nextLine();
        for(int i = 0 ; i < numberOfList ; i++){
            System.out.println(" print check i ="+i);
            inpupts.add(scanner.nextLine());
        }

        braces(inpupts.toArray(new String[inpupts.size()]));

    }


    public static void checkBraces(List<String> inpupts){
        for (int i = 0 ; i < inpupts.size() ; i++)
            System.out.println(checkBalance(inpupts.get(i)));
    }
    public static String[] braces(String[] values) {
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < values.length; i++) {
            list.add(checkBalance(values[i]));
        }
        return (list.toArray(new String[list.size()]));
    }

    public static String checkBalance(String string){
        Stack<Character> stackBucket = new Stack();
        if(string == null || string.length() <2 || string.length() > 100) return "NO";
        int i;
        for(i = 0 ;i< string.length();i++) {
            if(string.charAt(i) =='(' || string.charAt(i) == '{' || string.charAt(i) == '[') {
                stackBucket.push(string.charAt(i));
            } else if(string.charAt(i) ==')' || string.charAt(i) == '}' || string.charAt(i) == ']'){
                if(stackBucket.isEmpty()) return "NO";
                char charIndex = stackBucket.pop();
                switch (charIndex){
                    case '(' :
                        if(string.charAt(i) ==')') break;
                        else return "NO";
                    case '{' :
                        if(string.charAt(i) =='}') break;
                        return "NO";
                    case '[' :
                        if(string.charAt(i) ==']') break;
                        return "NO";
                    default:
                        return "NO";
                }
            }
        }
        if(!stackBucket.isEmpty()){ return "NO";}
        return "YES";
    }


}

//{}[]()
//{[}]}
// {} (( ( ))