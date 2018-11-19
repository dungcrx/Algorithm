package TestOnline;

import java.util.Scanner;

/**
 * Created by dungphan on 8/24/17.
 */
public class MissingWords {
    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();  //="I am a programmer am I";

        String str2 = scan.nextLine() ;                 //="am programmer";


        String words[]=str.split(" ");
        String words2[]=str2.split(" ");
        System.out.println("***Missed Words***");

        int k = 0;
        String[] result = new String[words.length];
        for(int i=0;i<words.length;i++){
            int flag=0;
            for(int j=0;j<words2.length;j++){

                if(words[i].equals(words2[j])){
                    flag=1;
                    words2[j]="";
                    break;
                }
            }
            if(flag==0){
                System.out.print(" "+words[i]);
                result[k] = words[i];
                k++;
            }
        }
        System.out.println();
    }
}
