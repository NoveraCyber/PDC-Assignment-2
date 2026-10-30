public class Question4App {
    public static void main(String[] args) {
        int rows = 8000;
        int cols = 8000;
        int[][] arr = new int[rows][cols];

        // 1. Row-Wise Traversal (Spatial Locality - Fast)
        long startRow = System.nanoTime();
        long rowSum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rowSum += arr[i][j];
            }
        }
        long endRow = System.nanoTime();
        double rowTime = (endRow - startRow) / 1e9;

        // 2. Column-Wise Traversal (Cache Misses - Slow)
        long startCol = System.nanoTime();
        long colSum = 0;
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                colSum += arr[i][j];
            }
        }
        long endCol = System.nanoTime();
        double colTime = (endCol - startCol) / 1e9;

        System.out.printf("Row-Wise Traversal Time: %.4f seconds%n", rowTime);
        System.out.printf("Column-Wise Traversal Time: %.4f seconds%n", colTime);
        System.out.printf("Speed Difference: Column-wise was %.2fx slower%n", colTime / rowTime);
    }
}