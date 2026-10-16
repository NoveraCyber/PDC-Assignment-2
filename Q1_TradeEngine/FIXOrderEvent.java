package Q1_TradeEngine;

public class FIXOrderEvent extends TradeEvent {
    private String clOrdId;

    public FIXOrderEvent(String senderId, long timestamp, double basePrice, String clOrdId) {
        super(senderId, timestamp, basePrice);
        this.clOrdId = clOrdId;
    }

    @Override
    public void dispatch() {
        double fee = basePrice * 0.0015;
        double totalCost = basePrice + fee;
        System.out.println("[FIX Gateway] Executing Stock Purchase | ClOrdID: " + clOrdId +
                           " | Sender: " + senderId + " | Price: $" + basePrice +
                           " | Fee (0.15%): $" + String.format("%.2f", fee) +
                           " | Total: $" + String.format("%.2f", totalCost));
    }
}