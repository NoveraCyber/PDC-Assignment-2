public class Question3App {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        int val = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = val++;
            }
        }

        System.out.println("--- 4x4 Matrix Output ---");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println("\n--- Java Array-of-Arrays Structure ---");
        System.out.println("Outer Array Reference: " + matrix);
        for (int i = 0; i < 4; i++) {
            System.out.println("Row " + i + " Object Reference: " + matrix[i]);
        }
    }
}
