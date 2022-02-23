import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Input jumlah buku
        int jBuku = in.nextInt();

        // Input jumlah pesanan
        int jPerintah = in.nextInt();

        // Input urutan buku
        int[] arBuku = new int[jBuku];
        for (int i = 0; i < jBuku; i++) {
            arBuku[i] = in.nextInt();
        }

        int[] arPerintah = new int[jPerintah];
        for (int i = 0; i < jPerintah; i++) {
            arPerintah[i] = in.nextInt();
        }

        System.out.println("\n" + Pelayan.Perintah(jBuku, jPerintah, arBuku, arPerintah) );

    }
}


class Pelayan {

    public static int Perintah(int jBuku, int jPerintah, int[] arBuku, int[] arPerintah) {

        // Input urutan perintah
        int waktu = 0;
        for (int i : arPerintah) {

            // Mindahin buku
            for (int j = 0; j < jBuku; j++) {
                if (arBuku[j] == i) {

                    // Tambah waktu
                    waktu += j*2;

                    // Geser Buku
                    for (int k = j; k > 0; k--) {
                        arBuku[k] = arBuku[k-1];
                    }

                    // Mindahin buku terpilih ke depan
                    arBuku[0] = i;
                }
            }
        }

        return waktu;
    }

}
