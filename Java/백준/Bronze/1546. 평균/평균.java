import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        
        Scanner stdIn = new Scanner(System.in);
        
        int len = stdIn.nextInt();
        int[] scores = new int[len];
        
        for (int i = 0; i < len; i++) {
            scores[i] = stdIn.nextInt();
        }
        
        long sum = 0;
        long max = 0;
        
        for (int i = 0; i < len; i++) {
            sum += scores[i];
            if (scores[i] > max)
                max = scores[i];
        }
        
        System.out.println(sum * 100.0 / max / len);
    }
}