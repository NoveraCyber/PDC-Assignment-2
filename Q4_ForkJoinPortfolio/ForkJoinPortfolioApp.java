package Q4_ForkJoinPortfolio;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPortfolioApp {
    public static void main(String[] args) {
        int datasetSize = 10000;
        double[] assets = new double[datasetSize];
        Random rand = new Random(42);
        for (int i = 0; i < datasetSize; i++) assets[i] = 100 + (1000 - 100) * rand.nextDouble();

        ForkJoinPool pool = ForkJoinPool.commonPool();

        long startTime = System.nanoTime();
        double totalRiskScore = pool.invoke(new ParallelRiskCalculator(assets, 0, datasetSize));
        long endTime = System.nanoTime();
        System.out.println("Total Initial Risk Score: " + String.format("%.2f", totalRiskScore));
        System.out.println("Parallel Calc Time: " + (endTime - startTime) / 1e6 + " ms");

        double riskCap = 800.0;
        startTime = System.nanoTime();
        pool.invoke(new PortfolioThresholdTask(assets, riskCap, 0, datasetSize));
        endTime = System.nanoTime();
        System.out.println("Stress Penalty Applied to Assets > " + riskCap);
        System.out.println("Parallel Adjustment Time: " + (endTime - startTime) / 1e6 + " ms");
    }
}