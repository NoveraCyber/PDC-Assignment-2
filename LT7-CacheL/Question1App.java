import java.util.Random;

public class Question1App {
    public static void main(String[] args) {
        int n = 2048;
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[][] C = new int[n][n];

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = rand.nextInt(10);
                B[i][j] = rand.nextInt(10);
            }
        }

        long startTime = System.nanoTime();

        // i -> j -> k order
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1e9;

        System.out.printf("Execution Time (i->j->k) for %dx%d: %.4f seconds%n", n, n, durationInSeconds);
    }
}