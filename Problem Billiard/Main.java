import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Input jumlah query
        int q = in.nextInt();

        for (int i = 0; i < q; i++) {

            // Input ukuran array
            int n = in.nextInt();
            int m = in.nextInt();

            // Input posisi array
            int x = in.nextInt();
            int y = in.nextInt();

            x -= 1;
            y -= 1;

            int[][] arr = new int[n][m];

            int xTemp = 0;
            int yTemp = 0;

            int color = 1;

            int xMove = 1;
            int yMove = 1;

            boolean b = true;
            boolean pertama = true;

            while (b) {
                arr[xTemp][yTemp] = color;

                if (!pertama) {
                    if ((xTemp == 0 && yTemp == 0) || (xTemp == n-1 && yTemp == 0) ||
                            (xTemp == 0 && yTemp == m-1) || (xTemp == n-1 && yTemp == m-1)) {
                        b = false;
                    }
                }

                pertama = false;

                xTemp += xMove;
                yTemp += yMove;

                if (xTemp == n || xTemp < 0) {
                    xMove *= -1;
                    if (color == 9) {
                        color = 1;
                    } else {
                        color++;
                    }
                    xTemp += xMove;
                }

                if (yTemp == m || yTemp < 0) {
                    yMove *= -1;
                    if (color == 9) {
                        color = 1;
                    } else {
                        color++;
                    }
                    yTemp += yMove;
                }

            }

//            for (int z = 0; z < n; z++) {
//                for (int zz = 0; zz < m; zz++) {
//                    System.out.print(arr[z][zz] + ", ");
//                }
//                System.out.println();
//            }
//
//            System.out.println();

            System.out.print("\n" + arr[x][y]);

        }

    }
}
