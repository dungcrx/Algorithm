package TestOnline;

/**
 * Created by phandung on 6/13/17.
 */
public class LenderRate {

    private static int[][] input = {
            {0, 1, 2, 3, 4, 5, 6 },
            {7, 8, 9, 10,11,12,13},
            {14,15,16,17,18,19,20},
            {21,22,23,24,25,26,27},
            {28,29,30,31,32,33,34},
            {35,36,37,38,39,40,41},
            {42,43,44,45,46,47,48}
    };

    public static void main(String[] args) {
        int[][] rotate = getSubSquare(2,3,3 , input);
        displayArray(rotate);
        int[][] result = rotateMatrixInplace(rotate);
        System.out.println(" After rotate ");
        displayArray(result);
        System.out.println(" replace new rotate to input ");
        replaceRotatedToOriginal(2,3,result,input);
        displayArray(input);

    }


    private static void displayArray( int[][] array) {
        for(int i = 0; i < array.length ; i++){
            for(int j = 0; j< array[i].length; j++){
                System.out.print(" a["+i+"] [" + j +"] = " + array[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] rotateMatrixInplace(int[][] matrix) {
        int length = matrix.length-1;
        for (int i = 0; i <= (length)/2; i++) {
            for (int j = i; j < length-i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length-j][i];
                matrix[length-j][i] = matrix[length-i][length-j];
                matrix[length-i][length-j] = matrix[j][length-i];
                matrix[j][length-i] = temp;
            }
        }
        return matrix;
    }

    public static  int[][] getSubSquare(int a , int b , int d , int[][] input){
        int[][] resutl = new int[d+1][d+1];
        for(int i = 0 ; i <  d +1   ; i ++){
            for(int j = 0 ; j < d +1 ; j ++){
                resutl[i][j] = input[i+a-1][j+b-1];
            }
        }
        return resutl;
    }


    private static void replaceRotatedToOriginal(int a, int b, int[][] result, int[][] input) {
        for(int i = 0 ; i < result.length; i++){
            for(int j = 0 ; j < result[i].length ; j++)
                input[i+a-1][j+b -1] = result[i][j];
        }
    }

}
