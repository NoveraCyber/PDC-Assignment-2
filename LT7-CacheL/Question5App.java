public class Question5App {
    public static void main(String[] args) {
        int size = 10_000_000;
        int[] data = new int[size];

        // Temporal Locality: Repeatedly accessing the exact same variable/index
        long startTemporal = System.nanoTime();
        long sumTemporal = 0;
        for (int i = 0; i < 100_000_000; i++) {
            sumTemporal += data[0]; // Accessing index 0 repeatedly
        }
        long endTemporal = System.nanoTime();

        // Spatial Locality: Accessing contiguous/adjacent array elements
        long startSpatial = System.nanoTime();
        long sumSpatial = 0;
        for (int i = 0; i < size; i++) {
            sumSpatial += data[i]; // Accessing data[0], data[1], data[2]...
        }
        long endSpatial = System.nanoTime();

        System.out.printf("Temporal Locality Loop Time: %.4f seconds%n", (endTemporal - startTemporal) / 1e9);
        System.out.printf("Spatial Locality Loop Time: %.4f seconds%n", (endSpatial - startSpatial) / 1e9);
    }
}