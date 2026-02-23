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

    static int[][] extract(int[][] array, int rowStart, int rowEnd, int colStart, int colEnd) {
        int[][] result = new int[rowEnd - rowStart][colEnd - colStart];
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                result[i - rowStart][j - colStart] = array[i][j];
            }
        }
        return result;
    }

    static int pulling(int[][] array, int length) {
        if (length == 2) {
            return secondMax(array[0][0], array[0][1], array[1][0], array[1][1]);
        }

        int half = length / 2;

        int[][] array1 = extract(array, 0,    half,   0,    half); 
        int[][] array2 = extract(array, 0,    half,   half, length); 
        int[][] array3 = extract(array, half, length, 0,    half);
        int[][] array4 = extract(array, half, length, half, length); 

        int v1 = pulling(array1, half);
        int v2 = pulling(array2, half);
        int v3 = pulling(array3, half);
        int v4 = pulling(array4, half);

        return secondMax(v1, v2, v3, v4);
    }
}

}
