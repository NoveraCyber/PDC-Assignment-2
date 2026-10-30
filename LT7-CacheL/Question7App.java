public class Question7App {
    public static void main(String[] args) {
        System.out.println("=== Cache Access Pattern Analysis ===");
        System.out.println("1. Order (i -> j -> k):");
        System.out.println("   - Array B[k][j] is accessed column-wise in the innermost loop.");
        System.out.println("   - Causes frequent CACHE MISSES because elements are non-contiguous in memory.");
        System.out.println("\n2. Order (i -> k -> j):");
        System.out.println("   - Array C[i][j] and B[k][j] are accessed row-wise in the innermost loop.");
        System.out.println("   - Utilizes SPATIAL LOCALITY effectively; CPU prefetches adjacent cache lines.");
        System.out.println("   - Yields significantly higher CACHE HITS and faster runtime.");
    }
}