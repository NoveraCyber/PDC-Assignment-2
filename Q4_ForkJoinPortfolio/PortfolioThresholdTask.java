package Q4_ForkJoinPortfolio;

import java.util.concurrent.RecursiveAction;

public class PortfolioThresholdTask extends RecursiveAction {
    private static final int THRESHOLD = 1000;
    private double[] assetValues;
    private double riskCap;
    private int start, end;

    public PortfolioThresholdTask(double[] assetValues, double riskCap, int start, int end) {
        this.assetValues = assetValues;
        this.riskCap = riskCap;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                if (assetValues[i] > riskCap) assetValues[i] += assetValues[i] * 0.05;
            }
        } else {
            int mid = start + (end - start) / 2;
            invokeAll(new PortfolioThresholdTask(assetValues, riskCap, start, mid),
                      new PortfolioThresholdTask(assetValues, riskCap, mid, end));
        }
    }
}
