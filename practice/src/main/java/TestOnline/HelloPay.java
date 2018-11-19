package TestOnline;


import java.util.Scanner;

/**
 * Created by dungphan on 31/07/17.
 */
public class HelloPay {

    private static String input = "aba/bab/";

    private static int aCost = 4;

    private static int bCost = 6;

    private static char a = 'a';

    private static char b = 'b';

    private static char preFix = '/';

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int k = 0; k < t; k++) {
            input = scan.next();
            aCost = Integer.parseInt(scan.next());
            bCost = Integer.parseInt(scan.next());
            int result = calculateSum();
            System.out.println(result);
        }
    }

    public static int calculateSum(){
        int result = -1;
        int sum = 0;
        char[] arrayChar = input.toCharArray();
        if(arrayChar.length %2 == 1) return result;
        for(int i = 0 ; i < arrayChar.length; i++){
            if(arrayChar[i] == preFix){
                Palindrome palinDrome = new Palindrome(sum, arrayChar, i).doReplace(preFix,a,b,aCost,bCost);
                if (palinDrome.ifNot()) {
                    return result;
                }
                sum = palinDrome.getSum();
            } else if(arrayChar[i] != arrayChar[arrayChar.length - i -1] && arrayChar[arrayChar.length - i -1] != preFix){
                return result;
            }
        }
        result = sum;
        return result;
    }

    private static class Palindrome {
        private boolean isNotPalindrome;

        private int sum;

        private char[] arrayChar;

        private int i;

        public Palindrome(int sum, char[] arrayChar, int i) {
            this.sum = sum;
            this.arrayChar = arrayChar;
            this.i = i;
        }

        boolean ifNot() {
            return isNotPalindrome;
        }

        public int getSum() {
            return sum;
        }

        public Palindrome doReplace(final char preFix, final char a, final char b, final int aCost, final int bCost) {
            if (arrayChar[arrayChar.length - i - 1] == preFix) { // case both a[i] and a[length -i -1] are preFix ('/')
                arrayChar[i] = a;
                arrayChar[arrayChar.length - i - 1] = a;
                sum = sum + 2 * Math.min(aCost,bCost);
            } else if (arrayChar[arrayChar.length - i - 1] == a) { // case a[length -i -1] = a
                arrayChar[i] = a;
                sum = sum + aCost;
            } else if (arrayChar[arrayChar.length - i - 1] == b) { //  case a[length -i -1] = b
                arrayChar[i] = b;
                sum = sum + bCost;
            } else {
                isNotPalindrome = true;
                return this;
            }
            isNotPalindrome = false;
            return this;
        }
    }
}