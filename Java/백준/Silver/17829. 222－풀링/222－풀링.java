import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int maxLength = stdIn.nextInt();
        int[][] array = new int[maxLength][maxLength];
        
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < maxLength; j++) {
                array[i][j] = stdIn.nextInt();
            }
        }
       
        System.out.println(pulling(array, maxLength));
    }
    
    static int secondMax(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);
        return arr[2];
    }
    
    static int pulling(int[][] array, int length) {
        if (length == 1) {
            return array[0][0];
        }
        
        int half = length / 2;
        int[][] newArray = new int[half][half];
        
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                int a = array[i * 2][j * 2];
                int b = array[i * 2][j * 2 + 1];
                int c = array[i * 2 + 1][j * 2];
                int d = array[i * 2 + 1][j * 2 + 1];
                newArray[i][j] = secondMax(a, b, c, d);
            }
        }
        
        return pulling(newArray, half);
    }
}