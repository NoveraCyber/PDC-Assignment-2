import java.util.Random;

public class Question6App {
    public static void main(String[] args) {
        int[] sizes = {128, 256, 512, 1024};
        Random rand = new Random();

        System.out.println("----------------------------------------");
        System.out.printf("%-15s | %-15s%n", "Matrix Size", "Execution Time (s)");
        System.out.println("----------------------------------------");

        for (int n : sizes) {
            int[][] A = new int[n][n];
            int[][] B = new int[n][n];
            int[][] C = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = rand.nextInt(10);
                    B[i][j] = rand.nextInt(10);
                }
            }

            long start = System.nanoTime();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            long end = System.nanoTime();
            System.out.printf("%-15s | %-15.4f%n", n + "x" + n, (end - start) / 1e9);
        }
        System.out.println("----------------------------------------");
    }
}