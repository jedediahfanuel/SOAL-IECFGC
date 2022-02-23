import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input banyak query
        int q = in.nextInt();
        int n1 = 0;
        int n2 = 0;

        for (int i = 0; i < q; i++) {

            // Input nomor favorite
            int n = in.nextInt();
            int s1 = in.nextInt();
            int s2 = in.nextInt();

            // Kalau Angka Favorite sama
            // Pastikan ga akan ada yang dapet
            if (s1 != s2) {
                n1 = n / s1;
                n2 = n / s2;

                // Kalau s2 MOD s1, artinya s2 > s1
                // Jadi pasti hanya s1 yang dapat maju
                if ((s2 % s1) == 0) {
                    n1 = n1 - n2;
                    n2 = 0;
                }
                // Kalau s1 MOD s2, artinya s1 > s2
                // Jadi pasti hanya s2 yang dapat maju
                else if ((s1 % s2) == 0) {
                    n2 = n2 - n1;
                    n1 = 0;
                }
                // Selain itu
                // Kelipatan perkalian keduanya
                // Bakal dijadiin pengurangan
                else {
                    // Kelipatan yg sama
                    int x = s1 * s2;
                    x = n / x;

                    // Jumlah dikurangi tabrakan
                    n1 = n1 - x;
                    n2 = n2 - x;
                }
            }
            // Kalau s1 == s2
            // langsung return default value n1 = 0 ; n2 = 0

            System.out.println(n1 + " " + n2);
        }
    }
}
