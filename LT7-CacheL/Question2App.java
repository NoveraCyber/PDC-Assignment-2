import java.util.Random;

public class Question2App {
    public static void main(String[] args) {
        int n = 1024; // Performance comparison ke liye 1024x1024 (2048 bohot time leta hai)
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = rand.nextInt(10);
                B[i][j] = rand.nextInt(10);
            }
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-15s | %-15s%n", "Loop Order", "Execution Time (s)");
        System.out.println("----------------------------------------");

        // 1. i -> j -> k
        runAndMeasure("i -> j -> k", A, B, n, 1);
        // 2. i -> k -> j
        runAndMeasure("i -> k -> j", A, B, n, 2);
        // 3. j -> i -> k
        runAndMeasure("j -> i -> k", A, B, n, 3);
        // 4. j -> k -> i
        runAndMeasure("j -> k -> i", A, B, n, 4);
        // 5. k -> i -> j
        runAndMeasure("k -> i -> j", A, B, n, 5);
        // 6. k -> j -> i
        runAndMeasure("k -> j -> i", A, B, n, 6);

        System.out.println("----------------------------------------");
    }

    public static void runAndMeasure(String label, int[][] A, int[][] B, int n, int order) {
        int[][] C = new int[n][n];
        long start = System.nanoTime();

        switch (order) {
            case 1: // i -> j -> k
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        for (int k = 0; k < n; k++) C[i][j] += A[i][k] * B[k][j];
                break;
            case 2: // i -> k -> j (Fastest due to spatial locality)
                for (int i = 0; i < n; i++)
                    for (int k = 0; k < n; k++)
                        for (int j = 0; j < n; j++) C[i][j] += A[i][k] * B[k][j];
                break;
            case 3: // j -> i -> k
                for (int j = 0; j < n; j++)
                    for (int i = 0; i < n; i++)
                        for (int k = 0; k < n; k++) C[i][j] += A[i][k] * B[k][j];
                break;
            case 4: // j -> k -> i
                for (int j = 0; j < n; j++)
                    for (int k = 0; k < n; k++)
                        for (int i = 0; i < n; i++) C[i][j] += A[i][k] * B[k][j];
                break;
            case 5: // k -> i -> j
                for (int k = 0; k < n; k++)
                    for (int i = 0; i < n; i++)
                        for (int j = 0; j < n; j++) C[i][j] += A[i][k] * B[k][j];
                break;
            case 6: // k -> j -> i (Slowest due to column strides)
                for (int k = 0; k < n; k++)
                    for (int j = 0; j < n; j++)
                        for (int i = 0; i < n; i++) C[i][j] += A[i][k] * B[k][j];
                break;
        }

        long end = System.nanoTime();
        System.out.printf("%-15s | %-15.4f%n", label, (end - start) / 1e9);
    }
}