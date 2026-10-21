package Q6_CatalogBenchmark;

public class InventoryCatalogManager {
    public static void main(String[] args) {
        InventoryCatalog catalog = new InventoryCatalog();
        int opCount = 100000;

        System.out.println("--- Starting High-Frequency Catalog Lookup Benchmark ---");
        catalog.benchmarkSyncMap(opCount);
        catalog.benchmarkConcurrentMap(opCount);
        System.out.println("Catalog Benchmarking Successfully Finalized.");
    }
}