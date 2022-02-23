import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();

        int sum;
        for (int i = 0; i < s; i++) {
            int n = in.nextInt();
            sum = (((((((((( (n * 1021) - 98 ) / 17 ) + 7582 ) * 209 ) / 37 ) * 11 ) + 9876 ) - 1 ) * 2 ) - 9876 );
            sum = Math.abs( ( sum / 10 ) % 10 );

            System.out.println(sum);
        }
    }
}
